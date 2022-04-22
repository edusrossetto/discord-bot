package br.com.lightflow.commands;

import org.jetbrains.annotations.NotNull;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Shop extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();
        TextChannel channel = (TextChannel) event.getChannel();

        if (message.toLowerCase().equals("$shop")) {
            channel.sendMessageEmbeds(null);
        }
    }
}
