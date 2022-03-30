package br.com.lightflow.commands;

import java.util.List;

import org.jetbrains.annotations.NotNull;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageHistory;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ClearChannel extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        // if (args[0].equals("$" + "clear".toLowerCase())) {
        // List<Message> messages =
        // event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
        // textChannel.deleteMessages(messages).queue();

        // }

        if (args[0].equals("$" + "clear".toLowerCase())) {
            for (int i = 0; i <= 1000; i++) {
                
                TextChannel channel = (TextChannel) event.getChannel();

                MessageHistory history = new MessageHistory(channel);
                List<Message> msgs;
        
                msgs = history.retrievePast(100).complete();
                if (msgs.size() > 1) {
                    channel.deleteMessages(msgs).queue();
        
                } else {
                    channel.sendMessage("Mensagens deletadas").queue();
                    return;
                }

            }

        }

    }

    // private void purgeMessages(TextChannel channel, int num) {

    //     MessageHistory history = new MessageHistory(channel);
    //     List<Message> msgs;
    //     history.retrievePast(100);

    //     msgs = history.retrievePast(num).complete();
    //     if (msgs.size() > 1) {
    //         channel.deleteMessages(msgs).queue();

    //     } else {
    //         channel.sendMessage("Mensagens deletadas").queue();
    //         return;
    //     }

    // }
}
