package br.com.lightflow.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;

import br.com.lightflow.security.Sqlite;
//import br.com.lightflow.security.Sqlite;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Pokemon {
    
   
    public static void printPokemon( MessageReceivedEvent event, TextChannel channel, URL url) {
        try {
            long id = event.getMessage().getMember().getIdLong();
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.connect();

            if (conn.getResponseCode() != 200) {
                channel.sendMessage("Erro nos números/pokemon").queue();
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
            nome = Utility.formata(nome);
            String png = (String) forms.get("front_default");

            JSONArray types = json.getJSONArray("types");

            JSONObject type = types.getJSONObject(0);

            JSONObject typeMain = type.getJSONObject("type");

            String typeOne = (String) typeMain.get("name");
            String typeTwo = "null";

            String color = Utility.getColor(typeOne);

            Random r = new Random();
            int numerorandom = (r.nextInt((2 - 1) + 1) + 1);

            if (types.length() > 1) {
                JSONObject type2 = types.getJSONObject(1);
                JSONObject typeMain2 = type2.getJSONObject("type");
                typeTwo = (String) typeMain2.get("name");
                if (numerorandom==2){
                    color = Utility.getColor(typeTwo);
                }
                typeTwo = Utility.traduzTipo(typeTwo);
                
            }

            typeOne = Utility.traduzTipo(typeOne);
              
            Utility uti = new Utility();
            event.getChannel().sendMessageEmbeds(uti.pokeEmbed(nome, typeOne,typeTwo, color, png,event.getMember())).setActionRow(Utility.sendButtons()).queue();
            
            Sqlite bd = new Sqlite();
            bd.setPokeTemp(id, nome);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
       

}