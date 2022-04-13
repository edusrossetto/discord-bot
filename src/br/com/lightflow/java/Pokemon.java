package br.com.lightflow.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;

import br.com.lightflow.security.Sqlite;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Pokemon {
    
   
    public static void printPokemon(MessageReceivedEvent event,ButtonInteractionEvent butEvent, TextChannel channel, URL url, int buttons) {

        try {
            long id = (long)404;
            if(event != null){
                id = event.getMessage().getMember().getIdLong();
            }else{
                id = butEvent.getMessage().getMember().getIdLong();
            }
            
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.connect();

            if (conn.getResponseCode() != 200) {
                channel.sendMessage("Pokemon não existe").queue();
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
            int pokeid = (int) json.get("id");
            
            nome = SemanticUtility.formata(nome);
            String png = (String) forms.get("front_default");

            JSONArray types = json.getJSONArray("types");
            JSONArray abilities = json.getJSONArray("abilities");
            JSONObject abilitieszero = abilities.getJSONObject(0);
            JSONObject ability = abilitieszero.getJSONObject("ability");
            String pokeAbility = (String) ability.get("name");
 

            JSONObject type = types.getJSONObject(0);

            JSONObject typeMain = type.getJSONObject("type");

            String typeOne = (String) typeMain.get("name");
            String typeTwo = "null";

            String color = PokeUtility.getColor(typeOne);

            Random r = new Random();
            int numerorandom = (r.nextInt((2 - 1) + 1) + 1);

            if (types.length() > 1) {
                JSONObject type2 = types.getJSONObject(1);
                JSONObject typeMain2 = type2.getJSONObject("type");
                typeTwo = (String) typeMain2.get("name");

                if (numerorandom==2){
                    color = PokeUtility.getColor(typeTwo);
                }

                typeTwo = PokeUtility.traduzTipo(typeTwo);
                
            }

            boolean evolveButton = NextPokemon.canEvolve(pokeid, pokeAbility, typeOne);


            typeOne = PokeUtility.traduzTipo(typeOne);
              
            PokeUtility uti = new PokeUtility();

            if(event != null){
                if(buttons == 2 && evolveButton){
                    event.getChannel().sendMessageEmbeds(uti.pokeEmbed(nome, typeOne, typeTwo, color, png,
                    event.getMember())).setActionRow(Components.evolveButton()).queue();
                   
                }else if(buttons  == 3 && evolveButton){
                    event.getChannel().sendMessageEmbeds(uti.pokeEmbed(nome, typeOne, typeTwo, color, png,
                    event.getMember())).setActionRow(Components.captureButton(),Components.evolveButton()).queue();
                  
                }else if(buttons == 0){
                    event.getChannel().sendMessageEmbeds(uti.pokeEmbed(nome, typeOne, typeTwo, color, png,
                    event.getMember())).queue();
                }else if(buttons == 2){
                    event.getChannel().sendMessageEmbeds(uti.pokeEmbed(nome, typeOne, typeTwo, color, png,
                    event.getMember())).queue();
                }else{
                    event.getChannel().sendMessageEmbeds(uti.pokeEmbed(nome, typeOne, typeTwo, color, png,
                    event.getMember())).setActionRow(Components.captureButton()).queue();
                   
                }
            }else{
                if(buttons == 2 && evolveButton){
                    butEvent.getChannel().sendMessageEmbeds(uti.pokeEmbed(nome, typeOne, typeTwo, color, png,
                    butEvent.getMember())).setActionRow(Components.evolveButton()).queue();
                }else if(buttons  == 3 && evolveButton){
                    butEvent.getChannel().sendMessageEmbeds(uti.pokeEmbed(nome, typeOne, typeTwo, color, png,
                    butEvent.getMember())).setActionRow(Components.captureButton(),Components.evolveButton()).queue();
                }else{
                    butEvent.getChannel().sendMessageEmbeds(uti.pokeEmbed(nome, typeOne, typeTwo, color, png,
                    butEvent.getMember())).setActionRow(Components.captureButton()).queue();
                }
            }
           
            
            Sqlite bd = new Sqlite();
            bd.setPokeTemp(id, nome);
            
        } catch (Exception e) {
            System.out.println("Pokemon não existe");
        }
    }
       

}