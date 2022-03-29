package br.com.lightflow.commands;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class TestCommand extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        TextChannel textChannel = (TextChannel) event.getChannel();

        if (args[0].toLowerCase().equals("$spamma")) {
            // separado = args[0].split("\\s+");
            for (int i = 1; i <= Integer.parseInt(args[1]); i++) {
                textChannel.sendMessage(i + " Spammado").queue();
                

            }

        }

    }
}
