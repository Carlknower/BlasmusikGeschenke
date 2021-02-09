package de.carlos.listener;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class LeaveListener extends ListenerAdapter {
	@Override
	public void onGuildMemberLeave(GuildMemberLeaveEvent event) {
		Member p = event.getMember();

		String nachricht1 = "Hey, " + p.getAsMention() + "!\n" + "Schade, dass du uns verl�sst!"
				+ "\nUm unseren Server zu verbessern, w�re es voll cool, wenn du uns kurz sagen k�nntest, warum du gegangen bist."
				+ "\nHat dir der Server nicht gefallen? Warst du mit einer unserer Entscheidungen unzufrieden?"
				+ "\nWir wollen dich hier jetzt nicht auf Biegen und Brechen �berreden, noch zu bleiben; das ist ganz allein deine Entscheidung, aber "
				+ "wir m�chten unseren Server nat�rlich so benutzerfreundlich wie m�glich gestalten und sind daher interessiert daran, "
				+ "Kritik zu erhalten."
				+ "\n"
				+ "\nWir w�rden uns �ber eine kurze R�ckmeldung freuen!"
				+ "\nAlles Gute und die besten Gr��e"
				+ "\n"
				+ "\nDein BlasmusikGeschenke-Team";
		p.getUser().openPrivateChannel().queue((pc) -> {
			pc.sendMessage(nachricht1).queue();
		});

	}
}