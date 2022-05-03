package br.com.lightflow.actions;

import br.com.lightflow.security.Sqlite;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BuyAction extends ListenerAdapter{
    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        String[] identifier = event.getComponentId().split("\\s+");

        if (identifier[0].equals("$buy")||true) {
            long id = event.getMember().getIdLong();
            TextChannel channel = event.getTextChannel();

           if(identifier[1].equals("pokeball")|| true){
               Sqlite bd = new Sqlite();
               channel.sendMessage("Pokeball comprada!");
               bd.setTableValue(id, "pokeballs", Integer.toString(bd.getIntByName("pokeballs", id)+1));
           }
           
            
        }
    }
}
