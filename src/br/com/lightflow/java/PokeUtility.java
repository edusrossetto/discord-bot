package br.com.lightflow.java;


import java.awt.Color;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class PokeUtility extends ListenerAdapter{
    
    
   
    EmbedBuilder builder = new EmbedBuilder();

    public MessageEmbed pokeEmbed(String nome, String tipoUm, String tipoDois, String color, String png, boolean desc, Member author){
       
        builder.setTitle("*"+nome+"*");
        builder.setThumbnail(png);

        if(desc){
            if (tipoDois.equals("null")||tipoDois.toLowerCase().contains("erro")) {
                builder.setDescription("Tipo: "+tipoUm+"\nPokemon!");
            }else{
                builder.setDescription("Tipo: "+tipoUm+"\nTipo dois: "+tipoDois);
            }
            builder.setColor(Color.decode(color));
        }else{
            builder.setDescription("Acerte o\n*Tipo!*");
            builder.setColor(Color.decode("#808080"));
        }
        
        
        
        return builder.build();
    }
    public MessageEmbed shopEmbed(long discord_id){
       
        builder.setTitle("**Loja**");
        builder.setColor(Color.decode("#d43c31"));        

        builder.setDescription(
        "Pokebola simples: 2 moedas\n"+
        "Fruta: 3 moedas");
        
        
        return builder.build();
    }
    public MessageEmbed typeEmbed(String tipoUm, String tipoDois){
        
    if (tipoDois.equals("null")) {
        builder.setThumbnail(tipoDois);
    }else{
        builder.setDescription("Tipo: "+tipoUm+"\nTipo dois: "+tipoDois);
    }
  
    
    return builder.build();
}

    public static boolean exception(int id){
        if(id == 119 || id == 130 || id == 132 || id == 139 || id == 141 || id == 201 || id == 233 || id == 234 || id == 354 || id == 362 || id == 368 || id == 369 || id == 370 || id == 398 || id == 413 || id == 483 || id == 547 || id == 754){
            return true;
        }
        return false;
        
    }

    public static int getIdPokemon(String nomePokemon){
    
        try {
        URL url = new URL(
            "https://pokeapi.co/api/v2/pokemon/"+SemanticUtility.desFormata(nomePokemon)
        );
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

        int pokeid = (int) json.get("id");

        return pokeid;

        }catch (Exception e) {
            e.printStackTrace();

            return 404;
        }

        
    }

    public static String getNamePokemon(int id){
    
        try {
        URL url = new URL(
            "https://pokeapi.co/api/v2/pokemon/"+(id)
        );
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

        String name = (String) json.get("name");

        return name;

        }catch (Exception e) {
            e.printStackTrace();

            return "errado";
        }

        
    }

    public static ArrayList<String> getPokeTypes(int id){
        ArrayList<String> tipos = new ArrayList<>();
        
        try {
            URL url = new URL(
                "https://pokeapi.co/api/v2/pokemon/"+(id)
            );
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

            String typeOne = (String) typeMain.get("name");
            String typeTwo = "null";

            tipos.add(typeOne);
            
            if (types.length() > 1) {
                JSONObject type2 = types.getJSONObject(1);
                JSONObject typeMain2 = type2.getJSONObject("type");
                typeTwo = (String) typeMain2.get("name");
                tipos.add(typeTwo);
                System.out.println(typeTwo);
            }
            
    
            }catch (Exception e) {
                e.printStackTrace();
    
            }
            System.out.println(tipos);
        return tipos;

        }

    public String traduzTipo(String str){
        if (str.equals("normal")){
            return "Normal";
        }else if (str.equals("fire")){
            str = "Fogo";
        }else if(str.equals("water")){
            str = "Água";
        }else if(str.equals("grass")){
            str = "Grama";
        }else if(str.equals("electric")){
            str = "Elétrico";
        }else if(str.equals("psychic")){
            str = "Psíquico";
        }else if(str.equals("ice")){
            str = "Gelo";
        }else if(str.equals("ghost")){
            str = "Fantasma";
        }else if(str.equals("dragon")){
            str = "Dragão";
        }else if(str.equals("fighting")){
            str = "Lutador";
        }else if(str.equals("flying")){
            str = "Voador";
        }else if(str.equals("poison")){
            str = "Veneno";
        }else if(str.equals("ground")){
            str = "Terra";
        }else if(str.equals("rock")){
            str = "Pedra";
        }else if(str.equals("bug")){
            str = "Inseto";
        }else if(str.equals("steel")){
            str = "Aço";
        }else if(str.equals("dark")){
            str = "Sombrio";
        }else if(str.equals("fairy")){
            str = "Fada";
        }else{
            str = "Erro, tipo inválido.";
        }
        
        return str;
    }

    public static String getColor(String str){
        if       (str.equals("normal")){
            str = "#A8A77A";
        }else if (str.equals("fire")){
            str = "#EE8130";
        }else if(str.equals("water")){
            str = "#6390F0";
        }else if(str.equals("grass")){
            str = "#7AC74C";
        }else if(str.equals("electric")){
            str = "#F7D02C";
        }else if(str.equals("psychic")){
            str = "#F95587";
        }else if(str.equals("ice")){
            str = "#96D9D6";
        }else if(str.equals("ghost")){
            str = "#735797";
        }else if(str.equals("dragon")){
            str = "#6F35FC";
        }else if(str.equals("fighting")){
            str = "#C22E28";
        }else if(str.equals("flying")){
            str = "#A98FF3";
        }else if(str.equals("poison")){
            str = "#A33EA1";
        }else if(str.equals("ground")){
            str = "#E2BF65";
        }else if(str.equals("rock")){
            str = "#B6A136";
        }else if(str.equals("bug")){
            str = "#A6B91A";
        }else if(str.equals("steel")){
            str = "#B7B7CE";
        }else if(str.equals("dark")){
            str = "#705746";
        }else if(str.equals("fairy")){
            str = "#D685AD";
        }else{
            str = "Erro, tipo inválido.";
        }
        
        return str;
    }

    public ArrayList<String> tipos(){
        ArrayList<String> tipos = new ArrayList<>();
        tipos.add("normal");
        tipos.add("fire");
        tipos.add("water");
        tipos.add("ice");
        tipos.add("electric");
        tipos.add("fairy");
        tipos.add("psychic");
        tipos.add("dragon");
        tipos.add("ground");
        tipos.add("rock");
        tipos.add("fighting");
        tipos.add("bug");
        tipos.add("steel");
        tipos.add("dark");
        tipos.add("ghost");
        tipos.add("flying");
        tipos.add("grass");
        tipos.add("poison");

        return tipos;
    }

}