package br.com.lightflow.java;


import java.util.ArrayList;
import java.util.List;

import java.awt.Color;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

public class Utility extends ListenerAdapter{

    

    public static List<Button> sendButtons(){
        List<Button> buttons = new ArrayList<>();
        buttons.add(Button.danger("capture", "Capturar!"));
        
        return buttons;

    }
  
    EmbedBuilder builder = new EmbedBuilder();

    public MessageEmbed pokeEmbed(String nome, String tipoUm, String tipoDois,String color, String png, Member author){
       
            builder.setTitle("*"+nome+"*");
            builder.setThumbnail(png);

            
        if (tipoDois.equals("null")) {
            builder.setDescription("Tipo: "+tipoUm+"\nPokemon!");
        }else{
            builder.setDescription("Tipo: "+tipoUm+"\nTipo dois: "+tipoDois);
        }
        builder.setColor(Color.decode(color));
        
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
    public static String formata(String str){
        str = str.substring(0, 1).toUpperCase() + str.substring(1);
        str = str.replace('-', ' ');

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

      public static String traduzTipo(String str){
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
        if (str.equals("normal")){
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

}
  
        //String corDois[] = new String[2];
        
        // }else if (tipoUm.equals("fire")){
        //     cor = "Fogo";
        // }else if(tipoUm.equals("water")){
        //     cor = "Água";
        // }else if(tipoUm.equals("grass")){
        //     cor = "Grama";
        // }else if(tipoUm.equals("electric")){
        //     cor = "Elétrico";
        // }else if(tipoUm.equals("psychic")){
        //     cor = "Psíquico";
        // }else if(tipoUm.equals("ice")){
        //     cor = "Gelo";
        // }else if(tipoUm.equals("ghost")){
        //     cor = "Fantasma";
        // }else if(tipoUm.equals("dragon")){
        //     cor = "Dragão";
        // }else if(tipoUm.equals("fighting")){
        //     cor = "Lutador";
        // }else if(tipoUm.equals("flying")){
        //     cor = "Voador";
        // }else if(tipoUm.equals("poison")){
        //     cor = "Veneno";
        // }else if(tipoUm.equals("ground")){
        //     cor = "Terra";
        // }else if(tipoUm.equals("rock")){
        //     cor = "Pedra";
        // }else if(tipoUm.equals("bug")){
        //     cor = "Inseto";
        // }else if(tipoUm.equals("steel")){
        //     cor = "Aço";
        // }else if(tipoUm.equals("dark")){
        //     cor = "Sombrio";
        // }else if(tipoUm.equals("fairy")){
        //     cor = "Fada";
        // }else{
        //     cor = "Erro, tipo inválido.";
        // }