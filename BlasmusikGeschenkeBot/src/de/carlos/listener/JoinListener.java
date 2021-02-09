package de.carlos.listener;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class JoinListener extends ListenerAdapter {

	@Override
	public void onGuildMemberJoin(GuildMemberJoinEvent event) {
		Member p = event.getMember();
		//System.out.println(p);
		String nachricht1 = "Hey, " + p.getAsMention() + "!\n" + "Sch�n, dass du da bist!"
				+ "\nUm dir den Einstieg auf dem Server ein wenig zu vereinfachen hier ein paar Hinweise und Tipps.\n\n"
				+ "1. ROLLEN:\n"
				+ "@Admin und @Team: 	die Leute, die hinter dem Instagram-Account @blasmusikgeschenk und hinter dem Discord-Server stecken. Bei Fragen kannst du dich jederzeit an uns wenden - entweder als Privatnachricht, �ber #support oder Insta-DM.\n"
				+ "@Mitglieder:			jeder, der die Regeln akzeptiert hat. Diese Rolle gew�hrt dir Zugang zu allen Text- und Sprachkan�len und erm�glicht dir auch, deinen eigenen Sprachkanal zu erstellen. Klicke hierzu einfach auf den Sprachkanal \"Join = eigener Channel\".\n"
				+ "[Instrument]:		Es gibt f�r die popul�rsten Instrumente sowie d�r Dirigent/Stabf�hrer und Komponist/Arrangeur eigene Rollen. Diese kannst du dir selbst zuweisen. Schreibe dazu in einen Textkanal (am besten in #blasmusik-h�ren, da st�rt es niemanden) \"?role [Instrument]\" (nat�rlich ohne Anf�hrungszeichen und eckige Klammern). Du wirst dann rechts in der �bersicht angezeigt und dein Name wird gr�n. Wenn du dir mehrere Instrumente zuweist, werden alle in deinem Profil angezeigt; rechts aber nur das, welches in der Paritur f�r gew�hnlich am weitesten oben steht. Zum Entfernen einer Rolle wiederhole einfach den Command.\n"
				+ "@Bots: 				alle Bots, die auf dem Server aktiv sind. Infos zu ihren jeweiligen Funktionen findest du am einfachsten, wenn du kurz googlest ;-)\n";
		String nachricht2 = "\n" + "2. KAN�LE:\n"
				+ "#willkommen-und-richtlinien sowie #ank�ndigungen sind rein informative Channel. Du kannst hier nichts reinschreiben.\n"
				+ "#musikertalk ist der allgemeine Textkanal f�r Unterhaltungen jeglicher Art.\n"
				+ "#vorstellung bietet dir Raum, ein paar Worte zu deiner Person/deinem Instrument zu verlieren. Gib aber KEINE vertraulichen Informationen wie Passw�rter oder Bankdaten preis!\n"
				+ "#komposition ist ein Kanal zum Austausch �ber das Komponieren/Arrangieren. Falls du Fragen dazu hast, hilft dir unsere Community immer gerne weiter.\n"
				+ "#spiele-und-co erwacht meist abends zum Leben. Hier spielen wir zusammen viele verschiedene Spiele. Komm doch mal dazu!\n"
				+ "#post-vorschl�ge beinhaltet ein Ticket-System, mit dem du einen Textkanal erzeugst, den nur du und wir Admins lesen k�nnen. Da kannst du uns dann Ideen f�r Instagram-Beitr�ge (als Text oder Bild) schicken. Achte bitte bei Bildern auf die Urheberrechte etc.\n";
		String nachricht3 = "#support beinhaltet ein Ticket-System, mit dem du einen Textkanal erzeugst, den nur du und wir Admins lesen k�nnen. Da kannst du mit uns Kontakt aufnehmen, wenn du Fragen oder Probleme hast. Wir sind f�r Kritik immer offen!\n"
				+ "#blasmusik-h�ren kannst du theoretisch gleich stummschalten. Der Channel ist nur f�r die Steuerung des Musikbots Rythm da.\n\n"
				+ "Jetzt ist aber genug erz�hlt. Geh auf den Server und hab' Spa�! Und wenn dir etwas auff�llt, was man verbessern k�nnte, meld dich einfach bei uns!\n\n"
				+ "Dein BlasmusikGeschenke-Team";
		/*/p.getUser().openPrivateChannel().queue((pc) -> {
			pc.sendMessage(nachricht1).queue();
			pc.sendMessage(nachricht2).queue();
			pc.sendMessage(nachricht3).queue();
			//System.out.println(nachricht1);
		});
/*/
	}
}
