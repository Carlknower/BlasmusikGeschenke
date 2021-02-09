package de.carlos.commands;

import java.util.ArrayList;
import java.util.List;

import de.carlos.commands.manager.ServerCommand;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CategorizeCommand implements ServerCommand{

	@Override
	public void performCommand(Member p, TextChannel channel, Message message, MessageReceivedEvent event) {
		if(!hasRole(p, "Admin")) {
			channel.sendMessage("Dieser Befehl ist einem Admin vorbehalten!").queue();
			return;
		}

		// Jedem Member auf dem Server die Kategorie-Rolle "Instrumente" zuweisen, wenn eine Instrumenten-Rolle vorhanden ist.
		List<Member> serverMembers = channel.getGuild().getMembers(); // Liste mit allen Servermitgliedern
		List<String> allMainInstr = new ArrayList<String>(); // Liste mit allen Instrumentenrollen (nur erst-Instr.)
		allMainInstr.add("Dirigent/Stabführer");
		allMainInstr.add("Flöte");
		allMainInstr.add("Klarinette");
		allMainInstr.add("Oboe");
		allMainInstr.add("Saxophon");
		allMainInstr.add("Horn");
		allMainInstr.add("Trompete");
		allMainInstr.add("Flügelhorn");
		allMainInstr.add("Tenorhorn");
		allMainInstr.add("Posaune");
		allMainInstr.add("Tuba");
		allMainInstr.add("Schlagzeug");
		allMainInstr.add("Komponist/Arrangeur");
		
		for(Member m : serverMembers) { // für jedes Servermitglied
			for(String mainInstr: allMainInstr) { // für jede Instrumentenrolle
				for(Role mRole : m.getRoles()) { // für jede Rolle des Mitglieds
					if(mRole.getName().equals(mainInstr)){
						if(!m.getRoles().contains(channel.getGuild().getRoleById(806937768403533835l))){
							// System.out.println("Ich würde jetzt " + m.getEffectiveName() + " die Rolle 'Instrumente' hinzufügen.");
							channel.getGuild().addRoleToMember(m, channel.getGuild().getRoleById(806937768403533835l)).queue();
						}
						if(!m.getRoles().contains(channel.getGuild().getRoleById(806961301392719913l))){
							// System.out.println("Ich würde jetzt " + m.getEffectiveName() + " die Rolle 'Instrumente' hinzufügen.");
							channel.getGuild().addRoleToMember(m, channel.getGuild().getRoleById(806961301392719913l)).queue();
						}
						
					}
				}	
			}
		}
	}

	@Override
	public String getInformation() {
		// TODO Auto-generated method stub
		return null;
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
}
