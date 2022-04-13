package br.com.lightflow.java;

public class SemanticUtility {
    public static String formata(String str){
        str = str.substring(0, 1).toUpperCase() + str.substring(1);
        str = str.replace('-', ' ');

        return str;

    }

    public static String desFormata(String str){
        str = str.substring(0, 1).toLowerCase() + str.substring(1);
        str = str.replace(' ', '-');

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
}
