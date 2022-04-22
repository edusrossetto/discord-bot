package br.com.lightflow.actions;

import java.util.Random;

import br.com.lightflow.java.SemanticUtility;
import br.com.lightflow.security.Sqlite;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BuyAction extends ListenerAdapter{
    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        String[] identifier = event.getComponentId().split("\\s+");
        if (true||identifier[0].equals("$buy")) {
           
           if(identifier[1].equals("pokeball"));
            
        }
    }
}
