package de.carlos.commands;

//import java.security.Permission;
//import java.security.Permissions;
import java.util.Collection;
import java.util.List;

import de.carlos.commands.manager.ServerCommand;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class TicketCommand implements ServerCommand {
	public int ticketCount;

	@Override
	public void performCommand(Member p, TextChannel channel, Message message, MessageReceivedEvent event) {
		// Syntax: /t <open|close|reopen|add @User|remove @User> + delete für Mod und
		// Admin
/*
		String[] args = message.getContentDisplay().substring(3).split(" "); // Argumente auslesen
*/
		// Berechtigungen im Ticket-Channel:
		/*
		 * Collection<net.dv8tion.jda.api.Permission> memberPerm = null; // Rechte des
		 * jeweiligen Nutzers im Ticket-Channel
		 * memberPerm.add(net.dv8tion.jda.api.Permission.MESSAGE_READ);
		 * memberPerm.add(net.dv8tion.jda.api.Permission.MESSAGE_WRITE);
		 * Collection<net.dv8tion.jda.api.Permission> modPerm = null; // Rechte der Mods
		 * (und Support-Team) modPerm.add(net.dv8tion.jda.api.Permission.MESSAGE_READ);
		 * modPerm.add(net.dv8tion.jda.api.Permission.MESSAGE_WRITE);
		 * Collection<net.dv8tion.jda.api.Permission> everyonePerm = null; // Rechte von
		 * everyone everyonePerm.add(net.dv8tion.jda.api.Permission.MESSAGE_READ);
		 * Collection<net.dv8tion.jda.api.Permission> adminPerm = null; // Adminrechte
		 * adminPerm.add(net.dv8tion.jda.api.Permission.MESSAGE_READ);
		 * adminPerm.add(net.dv8tion.jda.api.Permission.MESSAGE_WRITE);
		 * Collection<net.dv8tion.jda.api.Permission> botPerm = null; // BG-Bot-Rechte
		 * botPerm.add(net.dv8tion.jda.api.Permission.MANAGE_CHANNEL);
		 * botPerm.add(net.dv8tion.jda.api.Permission.MESSAGE_READ);
		 * botPerm.add(net.dv8tion.jda.api.Permission.MESSAGE_WRITE);
		 * botPerm.add(net.dv8tion.jda.api.Permission.MESSAGE_MANAGE);
		 * botPerm.add(net.dv8tion.jda.api.Permission.MESSAGE_EMBED_LINKS);
		 * botPerm.add(net.dv8tion.jda.api.Permission.MESSAGE_ATTACH_FILES);
		 * botPerm.add(net.dv8tion.jda.api.Permission.MESSAGE_HISTORY);
		 * botPerm.add(net.dv8tion.jda.api.Permission.MESSAGE_ADD_REACTION);
		 */
		
/*

		if (args.length < 1) { // Wenn keine Argument angegeben, kann auch nichts ausgeführt werden.
			channel.sendMessage(
					"Du musst ein Argument angeben, um diesen Befehl zu benutzen. Die korrekte Syntax lautet: `/t <open|close|reopen|add @User|remove @User>`. Hilfe gibt es unter `/help t`.")
					.queue();
			return;
		}

		if (args[0].contentEquals("open")) {
			// TODO
			channel.getGuild().createTextChannel(channel.getGuild().getEmotesByName("red_square", false) + " ticket-" + ticketCount, channel.getGuild().getCategoryById(799946733928054836l)).queue(ticketChannel -> {
*/
				//ticketChannel.createPermissionOverride(p).setAllow(net.dv8tion.jda.api.Permission.MESSAGE_READ); // Member
																															// Rechte
																															// geben
						//ticketChannel.createPermissionOverride(p)
								//.setAllow(net.dv8tion.jda.api.Permission.MESSAGE_WRITE);// Member Rechte geben
						//ticketChannel.putPermissionOverride(p).setAllow(Permission.MESSAGE_READ);
/*						ticketChannel.upsertPermissionOverride(channel.getGuild().getRolesByName("@everyone", false).get(0)).deny(Permission.MESSAGE_READ);
						ticketChannel.upsertPermissionOverride(p).setAllow(Permission.MESSAGE_WRITE);
*/	
						//ticketChannel.putPermissionOverride(p).setAllow(Permission.MESSAGE_WRITE);
						//ticketChannel.createPermissionOverride(channel.getGuild().getRolesByName("Admin", false).get(0))
							//	.setAllow(net.dv8tion.jda.api.Permission.MESSAGE_WRITE); // Admin Rechte geben
						/*
						 * ticketChannel.createPermissionOverride(channel.getGuild().getRoleById(
						 * 802133957096505345l)).setAllow(adminPerm); // Mods Rechte geben
						 * ticketChannel.createPermissionOverride(channel.getGuild().getRoleById(
						 * 796767508282605589l)).setAllow(adminPerm); // Support-Team Rechte geben
						 * ticketChannel.createPermissionOverride(channel.getGuild().getRoleById(
						 * 804424557368049675l)).setAllow(adminPerm); // BG-Bot Rechte geben
						 * ticketChannel.createPermissionOverride(channel.getGuild().getRoleById(
						 * 782263616073891900l)).setAllow(adminPerm); // everyone Rechte geben
						 */
//					});

			// channel.getGuild().createTextChannel(":red_square: ticket-" + ticketCount)
			// .createPermissionOverride(p).setAllow(Permission.VIEW_CHANNEL)
			/*
			 * .addMemberPermissionOverride(p.getIdLong(), memberPerm, null) // Member
			 * Rechte geben .addRolePermissionOverride(782264406180495420l, adminPerm, null)
			 * // Admin Rechte geben .addRolePermissionOverride(802133957096505345l,
			 * modPerm, null) // Mods Rechte geben
			 * .addRolePermissionOverride(796767508282605589l, modPerm, null) //
			 * Support-Team Rechte geben .addRolePermissionOverride(804424557368049675l,
			 * botPerm, null) // BG-Bot Rechte geben
			 * .addRolePermissionOverride(782263616073891900l, null, everyonePerm) //
			 * everyone Rechte nehmen .queue();
			 */
/*

		}
		if (args[0].contentEquals("close")) {
			// TODO
		}
		if (args[0].contentEquals("reopen")) {
			// TODO
		}
		if (args[0].contentEquals("add")) {
			// TODO
		}
		if (args[0].contentEquals("remove")) {
			// TODO
		}
*/
	}

	@Override
	public String getInformation() {
		// TODO Auto-generated method stub
		return "`";
	}

}
