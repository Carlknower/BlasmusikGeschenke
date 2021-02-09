package de.carlos.commands.manager;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public interface ServerCommand {
	public void performCommand(Member p, TextChannel channel, Message message, MessageReceivedEvent event);
	public String getInformation();
	
}
