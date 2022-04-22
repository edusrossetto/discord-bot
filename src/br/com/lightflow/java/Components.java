package br.com.lightflow.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;

import net.dv8tion.jda.api.entities.Emoji;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

public class Components {

    public Button captureButton(){
        Button button = Button.danger("capture", "Capturar");
        return button;

    }
    public Button evolveButton(){
        Button button = Button.primary("evolve", "Evoluir");
        return button;

    }
    public Button normal(){
        Button button = Button.secondary("normal", "Normal").withEmoji(Emoji.fromUnicode("U+1F365"));
        return button;

    }
    public Button fire(){
        Button button = Button.secondary("fire", "Fogo").withEmoji(Emoji.fromUnicode("U+1F525"));
        return button;
        
    }
    public Button water(){
        Button button = Button.secondary("water", "Água").withEmoji(Emoji.fromUnicode("U+1F30A"));
        return button;

    }
    public Button grass(){
        Button button = Button.secondary("grass", "Grama").withEmoji(Emoji.fromUnicode("U+1F343"));
        return button;
        
    }
    public Button electric(){
        Button button = Button.secondary("electric", "Elétrico").withEmoji(Emoji.fromUnicode("U+26A1"));
        return button;

    }
    public Button psychic(){
        Button button = Button.secondary("psychic", "Psíquico").withEmoji(Emoji.fromUnicode("U+1F300"));
        return button;

    }
    public Button ice(){
        Button button = Button.secondary("ice", "Gelo").withEmoji(Emoji.fromUnicode("U+1F9CA"));
        return button;

    }
    public Button ghost(){
        Button button = Button.secondary("ghost", "Fantasma").withEmoji(Emoji.fromUnicode("U+1F47B"));
        return button;

    }
    public Button fairy(){
        Button button = Button.secondary("fairy", "Fada").withEmoji(Emoji.fromUnicode("U+1F98B"));
        return button;

    }
    public Button dragon(){
        Button button = Button.secondary("dragon", "Dragão").withEmoji(Emoji.fromUnicode("U+1F004"));
        return button;

    }
    public Button fighting(){
        Button button = Button.secondary("fighting", "Luta").withEmoji(Emoji.fromUnicode("U+1F94A"));
        return button;

    }
    public Button flying(){
        Button button = Button.secondary("flying", "Voador").withEmoji(Emoji.fromUnicode("U+1F32B"));
        return button;

    }
    public Button poison(){
        Button button = Button.secondary("poison", "Venenoso").withEmoji(Emoji.fromUnicode("U+1F9EA"));
        return button;
        
    }
    public Button ground(){
        Button button = Button.secondary("ground", "Terra").withEmoji(Emoji.fromUnicode("U+1F3D4"));
        return button;

    }
    public Button rock(){
        Button button = Button.secondary("rock", "Pedra").withEmoji(Emoji.fromUnicode("U+1FAA8"));
        return button;
    }
    public Button bug(){
        Button button = Button.secondary("bug", "Inseto").withEmoji(Emoji.fromUnicode("U+1F41E	"));
        return button;
    }
    public Button steel(){
        Button button = Button.secondary("rock", "Aço").withEmoji(Emoji.fromUnicode("U+1F517"));
        return button;
    }
    public Button dark(){
        Button button = Button.secondary("dark", "Sombra").withEmoji(Emoji.fromUnicode("U+1F56F"));
        return button;
    }

    public Button delete(){
        Button button = Button.secondary("delete", "Deletar");
        return button;
    }

    public Button randomType(){
        Random r = new Random();
        int x = r.nextInt(18 - 1 + 1) + 1;
        if(x == 1){
            
            Button button = Button.secondary("normal", "Normal").withEmoji(Emoji.fromUnicode("U+1F365"));
            return button;
        }else if(x == 2){
            Button button = Button.secondary("fire", "Fogo").withEmoji(Emoji.fromUnicode("U+1F525"));
            return button;
        }else if(x == 3){
            Button button = Button.secondary("water", "Água").withEmoji(Emoji.fromUnicode("U+1F30A"));
            return button;
        }else if(x == 4){
            Button button = Button.secondary("grass", "Grama").withEmoji(Emoji.fromUnicode("U+1F343"));
            return button;
        }else if(x == 5){
            Button button = Button.secondary("electric", "Elétrico").withEmoji(Emoji.fromUnicode("U+26A1"));
            return button;
        }else if(x == 6){
            Button button = Button.secondary("psychic", "Psíquico").withEmoji(Emoji.fromUnicode("U+1F9FF"));
            return button;
        }else if(x == 7){
            Button button = Button.secondary("dark", "Sombrio").withEmoji(Emoji.fromUnicode("U+1F56F"));
            return button;
        }else if(x == 8){
            Button button = Button.secondary("rock", "Aço").withEmoji(Emoji.fromUnicode("U+1F517"));
            return button;
        }else if(x == 9){
            Button button = Button.secondary("ground", "Terra").withEmoji(Emoji.fromUnicode("U+1F3D4"));
            return button;
        }else if(x == 10){
            Button button = Button.secondary("poison", "Venenoso").withEmoji(Emoji.fromUnicode("U+1F9EA"));
            return button;
        }else if(x == 11){
            Button button = Button.secondary("flying", "Voador").withEmoji(Emoji.fromUnicode("U+1F32B"));
            return button;
        }else if(x == 12){
            Button button = Button.secondary("fighting", "Luta").withEmoji(Emoji.fromUnicode("U+1F94A"));
            return button;
        }else if(x == 13){
            Button button = Button.secondary("dragon", "Dragão").withEmoji(Emoji.fromUnicode("U+1F004"));
            return button;
        }else if(x == 14){
            Button button = Button.secondary("fairy", "Fada").withEmoji(Emoji.fromUnicode("U+1F98B"));
            return button;
        }else if(x == 15){
            Button button = Button.secondary("ghost", "Fantasma").withEmoji(Emoji.fromUnicode("U+1F47B"));
            return button;
        }else if(x == 16){
            Button button = Button.secondary("ice", "Gelo").withEmoji(Emoji.fromUnicode("U+1F9CA"));
            return button;
        }else if(x == 17){
            Button button = Button.secondary("steel", "Aço").withEmoji(Emoji.fromUnicode("U+26A1"));
            return button;
        }else if(x == 18){
            Button button = Button.secondary("psychic", "Psíquico").withEmoji(Emoji.fromUnicode("U+1F9FF"));
            return button;
        }
        
        Button button = Button.secondary("test", "Oloco").withEmoji(Emoji.fromUnicode("U+1F9EA"));
        
        return button;
    }

    public Button pokeType(String tipo){

        if(tipo.toLowerCase().equals("Normal")){
            
            Button button = Button.secondary("normal", "Normal").withEmoji(Emoji.fromUnicode("U+1F365"));
            return button;
        }else if(tipo.toLowerCase().equals("Fogo")){
            Button button = Button.secondary("fire", "Fogo").withEmoji(Emoji.fromUnicode("U+1F525"));
            return button;
        }else if(tipo.toLowerCase().equals("Fogo")){
            Button button = Button.secondary("water", "Água").withEmoji(Emoji.fromUnicode("U+1F30A"));
            return button;
        }else if(tipo.toLowerCase().equals("Fogo")){
            Button button = Button.secondary("grass", "Grama").withEmoji(Emoji.fromUnicode("U+1F343"));
            return button;
        }else if(tipo.toLowerCase().equals("Fogo")){
            Button button = Button.secondary("electric", "Elétrico").withEmoji(Emoji.fromUnicode("U+26A1"));
            return button;
        }else if(tipo.toLowerCase().equals("Fogo")){
            Button button = Button.secondary("psychic", "Psíquico").withEmoji(Emoji.fromUnicode("U+1F9FF"));
            return button;
        }else if(tipo.toLowerCase().equals("Fogo")){
            Button button = Button.secondary("dark", "Sombra").withEmoji(Emoji.fromUnicode("U+1F56F"));
            return button;
        }else if(tipo.toLowerCase().equals("Fogo")){
            Button button = Button.secondary("rock", "Aço").withEmoji(Emoji.fromUnicode("U+1F517"));
            return button;
        }else if(tipo.toLowerCase().equals("Fogo")){
            Button button = Button.secondary("ground", "Terra").withEmoji(Emoji.fromUnicode("U+1F3D4"));
            return button;
        }else if(tipo.toLowerCase().equals("Fogo")){
            Button button = Button.secondary("poison", "Venenoso").withEmoji(Emoji.fromUnicode("U+1F9EA"));
            return button;
        }else if(tipo.toLowerCase().equals("Fogo")){
            Button button = Button.secondary("flying", "Voador").withEmoji(Emoji.fromUnicode("U+1F32B"));
            return button;
        }else if(tipo.toLowerCase().equals("Fogo")){
            Button button = Button.secondary("fighting", "Luta").withEmoji(Emoji.fromUnicode("U+1F94A"));
            return button;
        }else if(tipo.toLowerCase().equals("Fogo")){
            Button button = Button.secondary("dragon", "Dragão").withEmoji(Emoji.fromUnicode("U+1F004"));
            return button;
        }else if(tipo.toLowerCase().equals("Fogo")){
            Button button = Button.secondary("fairy", "Fada").withEmoji(Emoji.fromUnicode("U+1F98B"));
            return button;
        }else if(tipo.toLowerCase().equals("Fogo")){
            Button button = Button.secondary("ghost", "Fantasma").withEmoji(Emoji.fromUnicode("U+1F47B"));
            return button;
        }else if(tipo.toLowerCase().equals("Fogo")){
            Button button = Button.secondary("ice", "Gelo").withEmoji(Emoji.fromUnicode("U+1F9CA"));
            return button;
        }else if(tipo.toLowerCase().equals("Fogo")){
            Button button = Button.secondary("electric", "Elétrico").withEmoji(Emoji.fromUnicode("U+26A1"));
            return button;
        }else if(tipo.toLowerCase().equals("Fogo")){
            Button button = Button.secondary("psychic", "Psíquico").withEmoji(Emoji.fromUnicode("U+1F9FF"));
            return button;
        }
        
        Button button = Button.secondary("test", "Oloco").withEmoji(Emoji.fromUnicode("U+1F9EA"));
        
        return button;
    }

    public HashMap<Integer, Button> typeMap(){
        HashMap<Integer, Button>
        typeMap = new HashMap<>();
    
        typeMap.put(1, fighting());
        typeMap.put(2, dark());
        typeMap.put(3, bug());
        typeMap.put(4, fairy());
        typeMap.put(5, steel());
        typeMap.put(6, normal());
        typeMap.put(7, flying());
        typeMap.put(8, electric());
        typeMap.put(9, dragon());
        typeMap.put(10, fire());
        typeMap.put(11, water());
        typeMap.put(12, ice());
        typeMap.put(13, grass());
        typeMap.put(14, psychic());
        typeMap.put(15, ground());
        typeMap.put(16, rock());
        typeMap.put(17, poison());
        typeMap.put(18, ghost());



        return typeMap;
    }

    public Button newButton(ArrayList<String> tipos){

   
        boolean novo = false;
        while(!novo){

            Random r = new Random();

            Collection <Button> collectionButton = typeMap().values();
            ArrayList<Button> buttonList = new ArrayList<>(collectionButton);

            Button randomButton = buttonList.get(r.nextInt((17 - 0) + 1) + 0);
            String bstring = randomButton.toString();
            bstring = bstring.substring(bstring.indexOf("(") + 1, bstring.indexOf(")"));

            if (tipos.contains(bstring)){
                System.out.println("repetiu");

            }else{
                novo = true;
                return randomButton;
            }
            
            
        }
        return null;
        
    }

    
    public static int typeId(String str){
        int i = 0;
        if       (str.equals("normal")){
            i = 6;
            return i;
        }else if (str.equals("fire")){
            i = 10;
            return i;
        }else if(str.equals("water")){
            i = 11;
            return i;
        }else if(str.equals("grass")){
            i = 13;
            return i;
        }else if(str.equals("electric")){
            i = 8;
            return i;
        }else if(str.equals("psychic")){
            i = 14;
            return i;
        }else if(str.equals("ice")){
            i = 12;
            return i;
        }else if(str.equals("ghost")){
            i = 18;
            return i;
        }else if(str.equals("dragon")){
            i = 9;
            return i;
        }else if(str.equals("fighting")){
            i = 1;
            return i;
        }else if(str.equals("flying")){
            i = 7;
            return i;
        }else if(str.equals("poison")){
            i = 17;
            return i;
        }else if(str.equals("ground")){
            i = 15;
            return i;
        }else if(str.equals("rock")){
            i = 16;
            return i;
        }else if(str.equals("bug")){
            i = 3;
            return i;
        }else if(str.equals("steel")){
            i = 5;
            return i;
        }else if(str.equals("dark")){
            i = 2;
            return i;
        }else if(str.equals("fairy")){
            i = 4;
            return i;
        }
        return i;
    }
    
    public Button typeButton(ArrayList<String> tipoUm){
        int id = typeId(tipoUm.get(0));
        Button button = typeMap().get(id);
        return button;
    }
    public Button typeTwoButton(ArrayList<String> tipoUm){
        int id = typeId(tipoUm.get(1));
        Button button = typeMap().get(id);
        return button;
    }
    
}
