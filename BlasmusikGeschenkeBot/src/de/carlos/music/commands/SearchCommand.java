package de.carlos.music.commands;

import java.net.URI;
import java.net.URISyntaxException;

import de.carlos.BlasmusikGeschenkeBot;
import de.carlos.commands.manager.ServerCommand;
import de.carlos.music.PlayerManager;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class SearchCommand implements ServerCommand {
	// @SuppressWarnings("ConstantConditions")

	private static SearchCommand INSTANCE;

	@Override
	public void performCommand(Member p, TextChannel channel, Message message, MessageReceivedEvent event) {
		if (message.getContentDisplay().toString().length() < 11) {
			channel.sendMessage(
					"Du hast zu wenig Argumente für diesen Befehl angegeben. Nutze `/help search` für Hilfe.")
					.queue();
		} else {
			String[] args = message.getContentDisplay().substring(11).split(" ");

			if (args.length < 1) {
				channel.sendMessage("Die richtige Syntax lautet: `/search [Suchbegriff]`").queue();
				return;
			}

			final GuildVoiceState memberVoiceState = p.getVoiceState();

			if (!memberVoiceState.inVoiceChannel()) {
				channel.sendMessage("Du musst in einem Sprachkanal sein, um diesen Befehl nutzen zu können.").queue();
				return;
			}
			if(BlasmusikGeschenkeBot.INSTANCE.searchComAct) { // wenn schon eine Suche läuft, soll nichts passieren + Fehlermeldung
				channel.sendMessage("Es läuft bereits eine Suchanfrage. Der Ersteller muss diese erst beenden, indem er einen Titel auswählt oder `cancel` eingibt.").queue();
				return;
				
				
				// TODO: Auto-TimeOut, damit nicht ein User ewig den Befehl blockiert, wenn er off ist und nichts ausgewählt/cancel hat 
				
				
			}

			String link = String.join(" ", args);

			/*
			 * /if (!isUrl(link)) { link = "ytsearch:" + link; }/
			 */
			if (!link.startsWith("http")) {
				link = "ytsearch:" + link;
			}
			BlasmusikGeschenkeBot.INSTANCE.searchComAct = true;
			BlasmusikGeschenkeBot.INSTANCE.searchMember = p;
			PlayerManager.getInstance().loadAndSearch(channel, link);
		}
		// JoinCommand join = new JoinCommand();
		// join.performCommand(p, channel, message);
	}

	public void playResult(Member p, TextChannel channel, Message message, MessageReceivedEvent event) {
		PlayerManager.getInstance().loadAndPlay(channel, PlayerManager.getInstance().searchResultTracks
				.get(BlasmusikGeschenkeBot.INSTANCE.eingabe - 1).getInfo().uri);
		JoinCommand join = new JoinCommand();
    	join.performCommand(p, channel, message, event);
    	// jetzt kann der nächste etwas suchen
		BlasmusikGeschenkeBot.INSTANCE.searchComAct = false;
		BlasmusikGeschenkeBot.INSTANCE.searchMember = null;
	}

	private boolean isUrl(String url) {
		try {
			new URI(url);
			return true;
		} catch (URISyntaxException e) {
			return false;
		}
	}

	@Override
	public String getInformation() {
		// TODO Auto-generated method stub
		return "` Sucht einen Titel.\n" + "Benutzung: `/search [Suchbegriff]`";
	}

	public static SearchCommand getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new SearchCommand();
		}

		return INSTANCE;
	}
}
