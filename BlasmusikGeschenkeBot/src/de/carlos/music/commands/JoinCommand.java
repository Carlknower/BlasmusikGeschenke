package de.carlos.music.commands;

import de.carlos.commands.manager.ServerCommand;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.managers.AudioManager;

@SuppressWarnings("ConstantConditions")
public class JoinCommand implements ServerCommand{

    @Override
    public String getInformation() {
        return "` l�sst den Bot in deinen Voice-Channel joinen.";
    }

	@Override
	public void performCommand(Member p, TextChannel channel, Message message, MessageReceivedEvent event) {
		// TODO Auto-generated method stub

        final GuildVoiceState memberVoiceState = p.getVoiceState();

        if (!memberVoiceState.inVoiceChannel()) {
            channel.sendMessage("Du musst in einem Sprachkanal sein, um diesen Befehl nutzen zu k�nnen.").queue();
            return;
        }

        final AudioManager audioManager = channel.getGuild().getAudioManager();
        final VoiceChannel memberChannel = memberVoiceState.getChannel();

        audioManager.openAudioConnection(memberChannel);

        channel.sendMessageFormat("Verbinden mit `\uD83D\uDD0A %s`", memberChannel.getName()).queue();
		
	}

}
