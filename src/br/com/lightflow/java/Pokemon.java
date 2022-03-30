package br.com.lightflow.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Pokemon {

    public static void printPokemon( MessageReceivedEvent event, TextChannel channel, URL url) {
        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.connect();

            if (conn.getResponseCode() != 200) {
                channel.sendMessage("Erro nos números").queue();
                conn.disconnect();
            }

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

            JSONObject json = new JSONObject(response);
            JSONObject forms = json.getJSONObject("sprites");

            String nome = (String) json.get("name");
            String png = (String) forms.get("front_default");

            JSONArray types = json.getJSONArray("types");

            JSONObject type = types.getJSONObject(0);

            JSONObject typeMain = type.getJSONObject("type");

            String typeOne = (String) typeMain.get("name");
            String typeTwo = null;

            if (types.length() > 1) {
                JSONObject type2 = types.getJSONObject(1);
                JSONObject typeMain2 = type2.getJSONObject("type");
                typeTwo = (String) typeMain2.get("name");
            }

            StringBuilder sb = new StringBuilder();
            sb.append("\nNome: " + nome);
            sb.append("\nTipo: " + typeOne);

            if (types.length() > 1) {
                sb.append("\nSegundo tipo: " + typeTwo);
            }

            sb.append("\n" + png);
            event.getMessage().reply(sb).queue();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}