package br.com.lightflow.commands;

import java.net.URL;
import java.util.Random;

import org.jetbrains.annotations.NotNull;

import br.com.lightflow.java.Pokemon;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MultiplePokemon extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String[] message = event.getMessage().getContentRaw().split(" ");
        TextChannel channel = (TextChannel) event.getChannel();
     
        if (message.length>1 && 
            message[0].toLowerCase().equals("$pokemons")) {
           
            for (int i = 1; i < Integer.parseInt(message[1]); i++) {
                Random r = new Random();
                try {
                    URL url = new URL(
                        "https://pokeapi.co/api/v2/pokemon/" + (r.nextInt((649 - 1) + 1) + 1));
                        Pokemon.printPokemon(event, null, channel,  url, 3, true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
               

                
                
            }
            

        }

        

    }
}
