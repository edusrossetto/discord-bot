package br.com.lightflow.actions;

import java.net.MalformedURLException;
import java.net.URL;

import br.com.lightflow.java.Pokemon;
import br.com.lightflow.java.SemanticUtility;
import br.com.lightflow.java.PokeUtility;
import br.com.lightflow.security.Sqlite;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class EvolvePokemon extends ListenerAdapter{

    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        if (event.getComponentId().equals("evolve")) {

            event.getMessage().reply("Evoluindo...").queue();
            event.deferEdit().queue();
            
            try {
                Thread.sleep(500);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }

            URL url = null;
            TextChannel channel = event.getTextChannel();

            long id = event.getUser().getIdLong();
            Sqlite bd = new Sqlite();
            String title;

            title = event.getMessage().getEmbeds().get(0).getTitle();
            title = title.replaceAll("\\*", "");
            title = SemanticUtility.desFormata(title);
            bd.setPokeTemp(id, title);

            String pokemon = bd.getPokeTemp(id);
            int pokeid = PokeUtility.getIdPokemon(pokemon);
            pokemon = SemanticUtility.formata(pokemon);
            
            try {
                
                if(pokeid == 117){
                    url = new URL("https://pokeapi.co/api/v2/pokemon/"+230);
                }else{
                    url = new URL("https://pokeapi.co/api/v2/pokemon/"+(pokeid+1));
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            pokemon = PokeUtility.getNamePokemon(pokeid+1);
            pokemon = SemanticUtility.formata(pokemon);
            bd.setPokeTemp(id, pokemon);

            Pokemon.printPokemon(null, event, channel, url, 3,true);
            
        }
    }
}