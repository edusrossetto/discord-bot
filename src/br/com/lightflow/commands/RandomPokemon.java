package br.com.lightflow.commands;

import java.net.URL;
import java.util.Random;

import org.jetbrains.annotations.NotNull;

import br.com.lightflow.java.Pokemon;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class RandomPokemon extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        TextChannel textChannel = (TextChannel) event.getChannel();
        String mensagem = event.getMessage().getContentRaw();
        if (mensagem.toLowerCase().equals("$pokemon")) {
            try {
                Random r = new Random();
                URL url = new URL(
                        "https://pokeapi.co/api/v2/pokemon/" + (r.nextInt((898 - 1) + 1) + 1));

                Pokemon.printPokemon(event,textChannel,  url);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
