package br.com.lightflow.commands;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jetbrains.annotations.NotNull;

import br.com.lightflow.java.Pokemon;
import br.com.lightflow.java.SemanticUtility;
import br.com.lightflow.security.Sqlite;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ListPokemons extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String mensagem = event.getMessage().getContentRaw();
        long id = event.getMessage().getMember().getIdLong();
        TextChannel textChannel = (TextChannel) event.getChannel();

        if (mensagem.toLowerCase().equals("$pokelista")) {

            Sqlite bd = new Sqlite();
            String pokemons = bd.getPokemons(id);

            List<String> pokeList = new ArrayList<String>(Arrays.asList(pokemons.split(", ")));
            
            String[] pokeArray = new String[pokeList.size()];
            pokeArray = pokeList.toArray(pokeArray);

            for (String poke : pokeArray) {
                try {
                    URL url = new URL("https://pokeapi.co/api/v2/pokemon/"+ SemanticUtility.desFormata(poke));
                    Pokemon.printPokemon(event, null, textChannel, url, 0);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }


        }

    }
}
