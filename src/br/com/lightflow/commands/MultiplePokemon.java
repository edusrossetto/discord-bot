package br.com.lightflow.commands;

import org.jetbrains.annotations.NotNull;

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

        if (Utility.contemNumero(mensagem[0]) && 
        mensagem[1].toLowerCase().equals("pokemons") &&
        admin) {
            for (int i = 0; i < Integer.parseInt(mensagem[0]); i++) {
                textChannel.sendMessage("$pokemon").queue();
                
            }
            

        }

        

    }
}
