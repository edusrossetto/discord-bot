package br.com.lightflow.java;

import br.com.lightflow.main.Dev;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;

public class Utility {


    public static String formata(String str){
        str = str.substring(0, 1).toUpperCase() + str.substring(1);
        str = str.replace('-', ' ');

        return str;

    }
    public static String traduzTipo(String str){
        if (str.equals("normal")){
            return str;
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
        }else if(str.equals("Fairy")){
            str = "Fada";
        }else{
            str = "Erro, tipo inválido.";
        }
        
        return str;
    }
    public static boolean contemNumero(String str) { 
        try {  
          Double.parseDouble(str);  
          return true;
        } catch(NumberFormatException e){  
          return false;  
        }  
      }

    EmbedBuilder builder = new EmbedBuilder();

    public MessageEmbed ping(Member author){
        builder.setTitle("  PING");
        builder.setDescription("" + Dev.jda.getGatewayPing() + "ms" + "");
        builder.setAuthor(author.getUser().getName(),"https://www.google.com/", author.getUser().getAvatarUrl());

        return builder.build();
    }

}
