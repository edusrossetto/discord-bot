package br.com.lightflow.commands;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import org.jetbrains.annotations.NotNull;

import java.net.URL;
import java.net.HttpURLConnection;
import com.google.gson.JsonObject;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class PokemonAleatorio extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        TextChannel textChannel = (TextChannel) event.getChannel();
        String mensagem = event.getMessage().getContentRaw();
        if (mensagem.toLowerCase().equals("$pokemon")) {
            try {

                URL url = new URL("https://pokeapi.co/api/v2/pokemon/chandelur" + "e");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.connect();

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                conn.disconnect();
                String response = content.toString();

                Gson gson = new Gson();
                JsonObject obj = gson.fromJson(response, JsonObject.class);

                JsonObject pokepoke = new Gson().fromJson(obj, JsonObject.class);

                
                String nomepoke = pokepoke.get("name").getAsString();

                textChannel.sendMessage(nomepoke + " name").queue();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
