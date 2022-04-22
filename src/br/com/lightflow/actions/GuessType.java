package br.com.lightflow.actions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import br.com.lightflow.java.Components;
import br.com.lightflow.java.PokeUtility;
import br.com.lightflow.java.SemanticUtility;
import br.com.lightflow.security.Sqlite;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuessType extends ListenerAdapter {

    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        PokeUtility pu = new PokeUtility();
        try {
            if (pu.tipos().contains(event.getComponentId())) {
                long id = event.getMember().getIdLong();
                String butText = event.getComponentId();
                TextChannel channel = event.getTextChannel();
                event.deferEdit().queue();
                
                Thread.sleep(2000);

                String urlName = event.getMessage().getEmbeds().get(0).getTitle();
                urlName = urlName.replaceAll("\\*", "");

                URL url = new URL("https://pokeapi.co/api/v2/pokemon/" +
                        SemanticUtility.desFormata(urlName));


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

                String nome = (String) json.get("name");

                JSONObject forms = json.getJSONObject("sprites");
                String png = (String) forms.get("front_default");


                nome = SemanticUtility.formata(nome);

                JSONArray types = json.getJSONArray("types");

                JSONObject type = types.getJSONObject(0);

                JSONObject typeMain = type.getJSONObject("type");

                String typeOne = (String) typeMain.get("name");
                String typeTwo = "null";

                if (types.length() > 1) {
                    JSONObject type2 = types.getJSONObject(1);
                    JSONObject typeMain2 = type2.getJSONObject("type");
                    typeTwo = (String) typeMain2.get("name");

                }

                if (typeOne.equals(butText)||typeTwo.equals(butText)){
                    Sqlite bd = new Sqlite();
                    Components c = new Components();
                    bd.setCoins(id, 2);
                    String title = event.getMessage().getEmbeds().get(0).getTitle();
                    String color = PokeUtility.getColor(butText);
                    event.getMessage().editMessageEmbeds().setEmbeds(pu.pokeEmbed(title, pu.traduzTipo(typeOne), pu.traduzTipo(typeTwo), color, png, true, event.getMember())).setActionRow(c.delete()).queue();
                    channel.sendMessage("Acertou! Mais duas moedas!").queue();
                }else{
                    channel.sendMessage("Ops errou :(").queue();;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
