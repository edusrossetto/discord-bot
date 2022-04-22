package br.com.lightflow.commands;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;


public class TestCommand extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String[] message = event.getMessage().getContentRaw().split(" ");
        TextChannel channel = (TextChannel) event.getChannel();
        //long id = Long.parseLong(event.getAuthor().getId());
        //boolean admin = Verification.verifica(id);

        if (message[0].toLowerCase().equals("$spamma") && message.length == 1) {
            channel.sendMessage("Quanto tem que ser spammado? Tipo \"$spamma 5\"").queue();

        }

        if (message[0].toLowerCase().equals("$spamma")
                && message.length == 2
                && Integer.parseInt(message[1]) <= 5) {

            for (int i = 1; i <= Integer.parseInt(message[1]); i++) {
                if (i == 1) {
                    channel.sendMessage(i + " Spammado").queue();

                } else {
                    channel.sendMessage(i + " Spammados").queue();

                }

            }

        }
        if (message[0].toLowerCase().equals("$spamma")
                && message.length == 2
                && Integer.parseInt(message[1]) > 5){
                //&& !admin) {
            channel.sendMessage("Precisa ser admin pra mandar mais que 5 mensagens").queue();

        }
        if (message[0].toLowerCase().equals("$spamma")
            && message.length == 2
            && Integer.parseInt(message[1]) > 5){
            //&& admin ) {

            for (int i = 1; i <= Integer.parseInt(message[1]); i++) {
                if (i == 1) {
                    channel.sendMessage(i + " Spammado").queue();

                } else {
                    channel.sendMessage(i + " Spammados").queue();

                }

            }

        }

    }
}
