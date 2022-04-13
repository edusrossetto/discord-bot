package br.com.lightflow.commands;

import org.jetbrains.annotations.NotNull;

import br.com.lightflow.main.Dev;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Status extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String mensagem = event.getMessage().getContentRaw();
        TextChannel textChannel = (TextChannel) event.getChannel();
        // MessageChannel channel = event.getChannel();

        if (mensagem.toLowerCase().equals("$status")) {

            textChannel.sendMessage(Dev.jda.getGatewayPing() + "ms de ping.\n ").queue();


        }

    }
}
