package de.carlos.commands;

import de.carlos.commands.manager.ServerCommand;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class EchoCommand implements ServerCommand {
	public String getInformation() {
		return " [Nachricht]` antwortet mit der gleichen Nachricht, die du ihm schreibst";
	}

	@Override
	public void performCommand(Member p, TextChannel channel, Message message, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		channel.sendMessage(message.getContentDisplay().substring(6)).queue();
		
	}
}
