package de.carlos.music.commands;

import de.carlos.commands.manager.ServerCommand;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.managers.AudioManager;

public class LeaveCommand implements ServerCommand {

	@Override
	public String getInformation() {
		return "` l�sst den Bot deinen Voice-Channel verlassen.";
	}

	@Override
	public void performCommand(Member p, TextChannel channel, Message message, MessageReceivedEvent event) {
		// TODO Auto-generated method stub

		final AudioManager audioManager = channel.getGuild().getAudioManager();

		audioManager.closeAudioConnection();
		//channel.sendMessageFormat("Tsch�ss!").queue();

	}

}
