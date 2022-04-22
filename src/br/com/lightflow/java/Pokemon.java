package br.com.lightflow.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;

import br.com.lightflow.security.Sqlite;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

public class Pokemon {
    
   
    public static void printPokemon(MessageReceivedEvent event,ButtonInteractionEvent butEvent, TextChannel channel, URL url, int buttons, boolean desc) {
        PokeUtility uti = new PokeUtility();
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

                typeTwo = uti.traduzTipo(typeTwo);
                
            }

            boolean evolveButton = NextPokemon.canEvolve(pokeid, pokeAbility, typeOne);


            typeOne = uti.traduzTipo(typeOne);
              
         

            Components c = new Components();

            ArrayList<String> tiposList = PokeUtility.getPokeTypes(pokeid);

            ArrayList<Button> buttonList = new ArrayList<>();

            if(buttons == 1){
                buttonList.add(c.captureButton());
            }else if(buttons == 2 && evolveButton){
                buttonList.add(c.evolveButton());   
            }else if(buttons == 3 && evolveButton){
                buttonList.add(c.captureButton());
                buttonList.add(c.evolveButton());

            }else if (buttons == 4 && tiposList.size() > 1){
                int x = r.nextInt((2 - 1) + 1) + 1;
                if(x == 1){
                    buttonList.add(c.typeButton(tiposList));
                }else{
                    buttonList.add(c.typeTwoButton(tiposList));

                }
                
                Button randomButton = c.newButton(tiposList);
                buttonList.add(randomButton);
                String randomString = randomButton.toString();
                tiposList.add(randomString.substring(randomString.indexOf("(") + 1, randomString.indexOf(")")));
                System.out.println(tiposList);
                buttonList.add(c.newButton(tiposList));
            }else if (buttons == 4){
                buttonList.add(c.typeButton(tiposList));
                Button randomButton = c.newButton(tiposList);
                buttonList.add(randomButton);
                String randomString = randomButton.toString();
                tiposList.add(randomString.substring(randomString.indexOf("(") + 1, randomString.indexOf(")")));
                buttonList.add(c.newButton(tiposList));

            }else{
                buttonList.add(c.delete());
            }
            
            if(event != null){
                Collections.shuffle(buttonList);
                event.getChannel().sendMessageEmbeds(uti.pokeEmbed(nome, typeOne, typeTwo, color, png, desc,
                event.getMember())).setActionRow(buttonList).queue();
                
            }else{
                Collections.shuffle(buttonList);
                butEvent.getChannel().sendMessageEmbeds(uti.pokeEmbed(nome, typeOne, typeTwo, color, png, desc,
                butEvent.getMember())).setActionRow(buttonList).queue();
            }
        
            Sqlite bd = new Sqlite();
            bd.setPokeTemp(id, nome);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
       

}