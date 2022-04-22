package br.com.lightflow.actions;

import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Delete extends ListenerAdapter {

    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        
            if (event.getComponentId().equals("delete")) {
               event.getMessage().delete().queue();
            }
        
    }
}
