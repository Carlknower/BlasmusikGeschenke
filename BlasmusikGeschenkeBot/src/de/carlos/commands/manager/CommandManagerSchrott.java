package de.carlos.commands.manager;

import de.carlos.commands.CommandContext;
import de.carlos.commands.ICommand;
//import me.duncte123.jdatuts.command.commands.*;
//import me.duncte123.jdatuts.command.commands.admin.SetPrefixCommand;
//import me.duncte123.jdatuts.command.commands.music.*;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import javax.annotation.Nullable;

import de.carlos.music.commands.JoinCommand;
import de.carlos.music.commands.NowPlayingCommand;
import de.carlos.music.commands.PlayCommand;
import de.carlos.music.commands.QueueCommand;
import de.carlos.music.commands.RepeatCommand;
import de.carlos.music.commands.SkipCommand;
import de.carlos.music.commands.StopCommand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class CommandManagerSchrott {}
    /*/private final List<ICommand> commands = new ArrayList<>();

    public CommandManagerSchrott() {
        addCommand(new PingCommand());
        addCommand(new HelpCommand(this));
        addCommand(new PasteCommand());
        addCommand(new HasteCommand());
        addCommand(new KickCommand());
        addCommand(new MemeCommand());
        addCommand(new JokeCommand());
        addCommand(new WebhookCommand());
        addCommand(new InstagramCommand());
        addCommand(new MinecraftCommand());

        addCommand(new SetPrefixCommand());

        addCommand(new JoinCommand());
        addCommand(new NowPlayingCommand());
        addCommand(PlayCommand());
        addCommand(StopCommand());
        addCommand(SkipCommand());
        addCommand(QueueCommand());
        addCommand(RepeatCommand());
        /*/
    

    //private void addCommand(ICommand cmd) {}
        /*/boolean nameFound = this.commands.stream().anyMatch((it) -> it.getName().equalsIgnoreCase(cmd.getName()));

        if (nameFound) {
            throw new IllegalArgumentException("A command with this name is already present");
        }

        commands.add(cmd);
        /*/
    

   // public List<ICommand> getCommands() {}
        //return commands;
    

   // @Nullable
   // public ICommand getCommand(String search) {}
       /*/ String searchLower = search.toLowerCase();

        for (ICommand cmd : this.commands) {
            if (cmd.getName().equals(searchLower) || cmd.getAliases().contains(searchLower)) {
                return cmd;
            }
        }

        return null;/*/
    

  //  void handle(GuildMessageReceivedEvent event, String prefix) {}
       /*/ String[] split = event.getMessage().getContentRaw()
                .replaceFirst("(?i)" + Pattern.quote(prefix), "")
                .split("\\s+");

        String invoke = split[0].toLowerCase();
        ICommand cmd = this.getCommand(invoke);

        if (cmd != null) {
            event.getChannel().sendTyping().queue();
            List<String> args = Arrays.asList(split).subList(1, split.length);

            CommandContext ctx = new CommandContext(event, args);

            cmd.handle(ctx);
        }
    }
/*/

