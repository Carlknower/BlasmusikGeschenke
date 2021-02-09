package de.carlos.commands;

import java.util.concurrent.ConcurrentHashMap;

import de.carlos.BlasmusikGeschenkeBot;
import de.carlos.commands.manager.ServerCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class HelpCommand implements ServerCommand {

	@Override
	public void performCommand(Member p, TextChannel channel, Message message, MessageReceivedEvent event) {
		sendCommands(p, channel, message);
		message.delete().queue();
	}

	private void sendCommandDetails(Member p, TextChannel channel, String command) {
		//ConcurrentHashMap<String, ServerCommand> befehle = BlasmusikGeschenkeBot.INSTANCE.getCmdMan().getCommands();	
		String erklaerung = BlasmusikGeschenkeBot.INSTANCE.getCmdMan().getHelpText(command);
			String message = "Hey, " + p.getAsMention() + "!\n" + "`/" + command + erklaerung + "\nFür Informationen zu anderen Commands benutze `/bg help [Befehl]`.";
		channel.sendMessage(message).queue();
	}

	private void sendCommands( Member p, TextChannel channel, Message nachricht) {
		if (nachricht.getContentDisplay().split(" ").length > 2) {
			sendCommandDetails(p, channel, nachricht.getContentDisplay().substring(9));
		} else {
			EmbedBuilder builder = new EmbedBuilder();
			builder.setDescription("Hi, " + p.getAsMention() + "!\n"
					+ "`/help2 [Befehl]` zeigt dir spezifische Hilfe und Erklärungen zu einem Command an. Folgende Befehle stehen zur Auswahl:\n\n");
			
			ConcurrentHashMap<String, ServerCommand> befehle = BlasmusikGeschenkeBot.INSTANCE.getCmdMan().getCommands();
			String[] commands = befehle.toString().split(",");
			//String message = "Hi, " + p.getAsMention() + "!\n" +"/bg help [Befehl] zeigt dir Erklärung zum jeweiligen Befehl an. Folgende Befehle stehen zur Auswahl:\n\n";
			/*for (int i = 0; i < commands.length; i++) {
				String fueryojo = commands[i].split("=")[0].substring(1);
				builder.setDescription(builder.getDescriptionBuilder()+ "\n`/bg " + fueryojo + "`");
			}*/
				//message = message + "/bg " + fueryojo + "\n";
				builder.addField("Admin-Befehle:", "`/shutdown`"
						+ "\n `/categorize`", false);
				builder.addField("Mod-Befehle:", "`/clear [Anzahl]` "
						+ "\n`/preview [Textkanal] [Nachricht]`"
						+ "\n`/react [Textkanal] [Nachrichten-ID] [Emojis]`", false);
				builder.addField("Allgemeine Befehle:", "`/help [command]`"
						+ "\n`/echo [Nachricht]`"
						+ "\n`/role [Rolle]`"
						+ "\n`/info`"/*
						+ "\n`/tusch1` oder `/t1`"
						+ "\n`/tusch2` oder `/t2`"
						+ "\n`/t <open|close|reopen|add @User|remove @User>`"*/, false);
				/*builder.addField("Musik-Befehle:", "`/join`"
						+ "\n`/leave`"
						+ "\n`/play <url|Suchbegriff>`"
						+ "\n`/np`"
						+ "\n`/queue` oder `/q`"
						+ "\n`/skip`"
						+ "\n`/repeat` oder `/loop`"
						+ "\n`/stop`", false);*/
				builder.addField("Musik-Befehle:", "Für Hilfe zu den Musik-Befehlen nutze bitte `/help`.", false);
				
			
			//channel.sendMessage(message).queue();
			builder.setColor(0x26a65b);
			builder.setTitle("Hilfe zum BlasmusikGeschenke-Bot");
			channel.sendMessage(builder.build()).queue();
		}
	}

	public String getInformation() {
		return "help [Befehl]` zeigt dir Erklärung zum jeweiligen Befehl an.";
	}
}
