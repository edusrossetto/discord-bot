package br.com.lightflow.commands;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class TestCommand extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String[] mensagem = event.getMessage().getContentRaw().split(" ");
        TextChannel textChannel = (TextChannel) event.getChannel();

        if (mensagem[0].toLowerCase().equals("$spamma") && mensagem.length < 2) {
            textChannel.sendMessage("Quanto tem que ser spammado? Tipo \"$spamma 5\"").queue();

        }

        if (mensagem[0].toLowerCase().equals("$spamma") && mensagem.length > 1) {
            for (int i = 1; i <= Integer.parseInt(mensagem[1]); i++) {
                if (i == 1) {
                    textChannel.sendMessage(i + " Spammado").queue();

                } else {
                    textChannel.sendMessage(i + " Spammados").queue();

                }

            }

        }

    }
}