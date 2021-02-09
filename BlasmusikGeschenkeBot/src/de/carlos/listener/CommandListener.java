package de.carlos.listener;

import java.util.List;

import de.carlos.BlasmusikGeschenkeBot;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.internal.entities.UserById;

public class CommandListener extends ListenerAdapter {
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		// Privatnachrichten an Carlos weiterleiten
		if(event.isFromType(ChannelType.PRIVATE) && !event.getAuthor().getName().equalsIgnoreCase("BlasmusikGeschenke")) {
			Message nachricht = event.getMessage();
			User p = event.getAuthor();
			//User carlos = User.fromId(782299938293022751l);
			String carlosIdStr = "782299938293022751";
			long carlosIdLong = Long.parseLong(carlosIdStr);
			User carlos = event.getJDA().getUserById(carlosIdLong);
			System.out.println(carlos);
			
			carlos.openPrivateChannel().queue((pc) -> {
				pc.sendMessage(p.getName() + "#" + p.getDiscriminator() + " hat folgende Nachricht an mich gesendet:").queue();
				pc.sendMessage(nachricht).queue();
			});
			
		}
		
		
		
		if (event.isFromType(ChannelType.TEXT) && !event.getAuthor().getName().equalsIgnoreCase("BlasmusikGeschenke")) {
			String message = event.getMessage().getContentDisplay();
			if (!message.startsWith("/")) {
				return;
			}
			if(!event.getChannel().getId().equals("782310867190022194") && !event.getChannel().getName().equals("bottest")) {
				if(!hasRole(event.getMember(), 782264406180495420l) && !hasRole(event.getMember(), 806863959440621629l) && !hasRole(event.getMember(), 802133957096505345l)) {
					event.getChannel().sendMessage("Bitte benutze Befehle immer nur in #bot-befehle, um andere Mitglieder nicht vollzuspammen.").queue();
					return;
				}
			}
			String[] args = message.substring(1).split(" ");

			if (args.length > 0) {
				Boolean success = BlasmusikGeschenkeBot.INSTANCE.getCmdMan().canPerform(args[0], event.getMember(),
						event.getTextChannel(), event.getMessage(), event);
				if (!success) {
					/*event.getChannel()
							.sendMessage("Ich kenne diesen Command nicht. '/help' zeigt dir alle meine Commands an.")
							.queue();
							*/
				}
			}
			// event.getChannel().sendMessage("Hallo Welt").queue();
		}

	}
	
	private boolean isBot(Member player) {
		if (player.getEffectiveName().equalsIgnoreCase("BlasmusikGeschenke")) {
			return true;
		}
		return false;
	}
	public boolean hasRole(Member member, String name) {
		List<Role> roles = member.getRoles();
		for(int i = 0; i < roles.size(); i++) {
			if(roles.get(i).getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	public boolean hasRole(Member member, Long roleIdLong) {
		List<Role> roles = member.getRoles();
		for (int i = 0; i < roles.size(); i++) {
			if (roles.get(i).getIdLong() == roleIdLong) {
				return true;
			}
		}
		return false;
	}
}
