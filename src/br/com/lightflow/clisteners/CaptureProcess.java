package br.com.lightflow.clisteners;

import org.jetbrains.annotations.NotNull;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CaptureProcess extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String mensagem = event.getMessage().getContentRaw();

        if (mensagem.contains("https://c.tenor.com/OPhGGLtFqLQAAAAM/pokeball.gif")) {
           
           event.getMessage().delete().queue();

        }

    }
}
