package br.com.lightflow.commands;

import java.net.URL;

import org.jetbrains.annotations.NotNull;

import br.com.lightflow.java.Pokemon;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class PokemonStatus extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        TextChannel textChannel = (TextChannel) event.getChannel();
        String mensagem[] = event.getMessage().getContentRaw().split(" ");
        if (mensagem[0].toLowerCase().contains("$pokemon") && mensagem.length > 1) {
            try {
                URL url = new URL("https://pokeapi.co/api/v2/pokemon/" + mensagem[1]);
                
                Pokemon.printPokemon(event,textChannel,  url);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
