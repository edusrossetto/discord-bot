package br.com.lightflow.commands;

import java.net.URL;
import java.util.Random;

import org.jetbrains.annotations.NotNull;

import br.com.lightflow.java.Pokemon;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class TypeGame extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        TextChannel channel = (TextChannel) event.getChannel();
        String message = event.getMessage().getContentRaw();
        if (message.toLowerCase().equals("$pokegame")) {
            try {
                
                Random r = new Random();

                URL url = new URL(
                        "https://pokeapi.co/api/v2/pokemon/" + (r.nextInt((649 - 1) + 1) + 1));

                Pokemon.printPokemon(event, null, channel,  url, 4, false);



            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
