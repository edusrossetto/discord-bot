package br.com.lightflow.commands;

import java.net.URL;
import java.util.Random;

import org.jetbrains.annotations.NotNull;

import br.com.lightflow.java.Pokemon;
import br.com.lightflow.java.Utility;
import br.com.lightflow.security.Verification;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MultiplePokemon extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String[] mensagem = event.getMessage().getContentRaw().split(" ");
        TextChannel textChannel = (TextChannel) event.getChannel();
        long id = Long.parseLong(event.getAuthor().getId());
        boolean admin = Verification.verifica(id);

        if (mensagem.length>1 && 
            mensagem[0].toLowerCase().equals("$pokemonvarios") &&
            Utility.contemNumero(mensagem[1]) &&
            admin) {
            for (int i = 0; i < Integer.parseInt(mensagem[1]); i++) {
                Random r = new Random();
                try {
                    URL url = new URL(
                        "https://pokeapi.co/api/v2/pokemon/" + (r.nextInt((649 - 1) + 1) + 1));
                        Pokemon.printPokemon(event,textChannel,  url);
                } catch (Exception e) {
                }
               

                
                
            }
            

        }

        

    }
}
