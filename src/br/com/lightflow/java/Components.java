package br.com.lightflow.java;

import net.dv8tion.jda.api.interactions.components.buttons.Button;

public class Components {
    
    public static Button captureButton(){
        Button button = Button.danger("capture", "Capturar!");
        return button;

    }
    public static Button evolveButton(){
        Button button = Button.primary("evolve", "Evoluir!");
        return button;

    }
}
