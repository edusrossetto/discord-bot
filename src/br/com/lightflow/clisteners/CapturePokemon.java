package br.com.lightflow.clisteners;

import java.util.Random;

import br.com.lightflow.security.Sqlite;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CapturePokemon extends ListenerAdapter{
    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        if (event.getComponentId().equals("capture")) {
            boolean pokemonaqui = true;
            while(pokemonaqui){TextChannel channel = event.getTextChannel();
                long id = event.getUser().getIdLong();
                event.reply("https://c.tenor.com/OPhGGLtFqLQAAAAM/pokeball.gif").queue();
                event.getMessage().delete().queue();
                Random r = new Random();
                int num = (r.nextInt((10 - 1) + 1) + 1);
                if (num >0){
                channel.sendMessage("Você capturou!").queue();
                Sqlite bd = new Sqlite();
    
                String newpokemon = bd.getPokeTemp(id);
                String pokemons = bd.getPokemons(id);
    
                System.out.println(newpokemon);
                System.out.println(pokemons);
    
                bd.setPokemons(id, newpokemon, pokemons);
                pokemonaqui = false;
                }else if(num<0){
                    channel.sendMessage("Fugiu mano!").queue();
                    pokemonaqui = false;
                }}
            
        }
    }
}
