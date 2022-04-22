package br.com.lightflow.actions;

import java.util.Random;

import br.com.lightflow.java.SemanticUtility;
import br.com.lightflow.security.Sqlite;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CapturePokemon extends ListenerAdapter{
    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        if (event.getComponentId().equals("capture")) {
            boolean pokemonaqui = true;
            while(pokemonaqui){
                
                TextChannel channel = event.getTextChannel();
                long id = event.getUser().getIdLong();
                
                event.reply("https://c.tenor.com/OPhGGLtFqLQAAAAM/pokeball.gif").queue();
                

                Random r = new Random();

                int num = (r.nextInt((10 - 1) + 1) + 1);
                
                if (num != 666){
                    
                    Sqlite bd = new Sqlite();
    
                    String title;
                    title = event.getMessage().getEmbeds().get(0).getTitle();
                    title = title.replaceAll("\\*", "");

                    event.getMessage().delete().queue();
                    channel.sendMessage("Você capturou um " + title + "!").queue();

                    title = SemanticUtility.desFormata(title);
                    System.out.println(title);
                    
                    bd.setPokeTemp(id,title);

                    String pokemons = bd.getPokemons(id);
    
                    bd.setPokemons(id, SemanticUtility.formata(bd.getPokeTemp(id)), pokemons);
                    pokemonaqui = false;

                }
                    pokemonaqui = false;
            }
            
        }
    }
}
