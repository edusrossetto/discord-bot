package br.com.lightflow.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class NextPokemon {
    
   
    public static boolean canEvolve(int id, String firstAbility, String tipoUm) {
        String pokeAbility = null;
        String typeOne = null;
        String typeTwo = null;
        if(PokeUtility.exception(id)){
            return false;
        }
        try {
            
            URL url = new URL("https://pokeapi.co/api/v2/pokemon/"+(id+1));
            
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

            JSONObject json = new JSONObject(response);

            JSONArray types = json.getJSONArray("types");
            JSONObject type = types.getJSONObject(0);
            JSONObject typeMain = type.getJSONObject("type");
            typeOne = (String) typeMain.get("name");
            typeTwo = "null";

            if (types.length() > 1) {
                JSONObject type2 = types.getJSONObject(1);
                JSONObject typeMain2 = type2.getJSONObject("type");
                typeTwo = (String) typeMain2.get("name");

                typeTwo = PokeUtility.traduzTipo(typeTwo);
                
            }

            JSONArray abilities = json.getJSONArray("abilities");
            JSONObject abilitieszero = abilities.getJSONObject(0);
            JSONObject ability = abilitieszero.getJSONObject("ability");
            pokeAbility = (String) ability.get("name");
 
            
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        
        if(typeOne.equals(tipoUm)){
            return true;
        }else if(pokeAbility.equals(firstAbility)){
            return true;
        }else{
            return false;
        }
    }
       

}