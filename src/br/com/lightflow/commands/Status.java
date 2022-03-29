package br.com.lightflow.commands;

import br.com.lightflow.main.*;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


import org.jetbrains.annotations.NotNull;

public class Status extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String mensagem = event.getMessage().getContentRaw();
        TextChannel textChannel = (TextChannel) event.getChannel();
        MessageChannel channel = event.getChannel();

        if (mensagem.toLowerCase().equals("$status")) {

            textChannel.sendMessage(Dev.jda.getGatewayPing() + "ms de ping");

            channel.getHistory().retrievePast(1)
                    .map(messages -> messages.get(0))
                    .queue(message -> {
                        message.addReaction("\u2620").queue();
                    });
        }

    }
}
