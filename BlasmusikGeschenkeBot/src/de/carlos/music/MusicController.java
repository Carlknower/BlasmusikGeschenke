package de.carlos.music;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;

import de.carlos.BlasmusikGeschenkeBot;
import net.dv8tion.jda.api.entities.Guild;

public class MusicController {

	private Guild guild;
	private AudioPlayer player;

	public MusicController(Guild guild) {
		this.guild = guild;
		this.player = BlasmusikGeschenkeBot.INSTANCE.audioPlayerManager.createPlayer();
		
		this.guild.getAudioManager().setSendingHandler(new AudioPlayerSendHandler(player));
		this.player.addListener(new TrackScheduler(player));
		this.player.setVolume(100);		
	}
	
	public Guild getGuild() {
		return guild;
	}
	
	public AudioPlayer getPlayer() {
		return player;
	}

}
