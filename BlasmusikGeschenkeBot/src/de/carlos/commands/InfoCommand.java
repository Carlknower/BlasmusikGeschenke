package de.carlos.commands;

import de.carlos.commands.manager.ServerCommand;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class InfoCommand implements ServerCommand {
	public String getInformation() {
		return "` gibt dir im Privatchat Informationen �ber die Seite und ihre Betreiber.";
	}

	@Override
	public void performCommand(Member p, TextChannel channel, Message message, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		message.delete().queue();
		String nachricht = "Hey, " + p.getAsMention() + "!\n"
				+ "Sch�n, dass du dich f�r unser Team interessierst. \n" + 
				"Um die anderen nicht unn�tig vollzuspammen, bekommst du diese Nachricht im Privatchat.\n\n" + 
				"Die Seite wurde Anfang 2018 von Philipp erstellt. Im April 2020 hat er sich aus Zeigr�nden dazu entschlossen, sich Verst�rkung zu holen. " +
				"So kamen Susann, Carlos und Jan ins Team. Philipp bleibt uns als Leiter der Gruppe jedoch immer noch erhalten. "
				+ "Im Januar 2021 sind Daniel und Caroline zum Team dazugesto�en, sie befinden sich aktuell noch in der Einarbeitungs- und Probephase. "
				+ "\nDie Arbeit im Team l�uft meist so ab: Susanne sucht Ideen und Memes f�r Posts. Sie oder Jan machen daraus dann Beitr�ge. Jan postet die Beitr�ge auf Instagram und erstellt zusammen mit Carlos Storys. Die beiden k�mmern sich auch um Kommentare und DMs. "
				+ "\n\nFalls du eine gute Idee f�r einen Post hast, darfst du sie gerne auf dem Server unter #post-vorschl�ge einreichen. Vielleicht wird sie ja schon bald ver�ffentlicht... :D. \n"
				+ "Wenn du noch mehr Infos m�chtest, kannst du uns �ber #support kontaktieren oder uns eine DM (Auf Discord oder Instagram) schreiben. Wir freuen uns, von dir zu h�ren!\n\n"
				+ "Dein BlasmusikGeschenke-Team";
		p.getUser().openPrivateChannel().queue((pc) -> {
			pc.sendMessage(nachricht).queue();
		});
	}

}
