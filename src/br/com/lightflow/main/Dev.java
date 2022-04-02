package br.com.lightflow.main;

import br.com.lightflow.clisteners.CapturePokemon;
import br.com.lightflow.clisteners.CaptureProcess;
import br.com.lightflow.commands.*;
import br.com.lightflow.java.Utility;
import br.com.lightflow.security.Token;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;


import java.io.IOException;
import java.text.ParseException;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class Dev {
    public static JDA jda;
    public static Map<Long, String> mapGuildName = new HashMap<>();


    public static void main(String[] args) throws LoginException, InterruptedException, IOException, ParseException {

        jda = JDABuilder.create(Token.getToken(),
                EnumSet.allOf(GatewayIntent.class)).build();

        jda.addEventListener(new Status());
        jda.addEventListener(new ClearChannel());
        jda.addEventListener(new TestCommand());
        jda.addEventListener(new PokemonStatus());
        jda.addEventListener(new RandomPokemon());
        jda.addEventListener(new MultiplePokemon());
        jda.addEventListener(new Utility());
        jda.addEventListener(new CapturePokemon());
        jda.addEventListener(new CaptureProcess());

        // Iterando os servidores que o andrômeda está!
        for (Guild guild : jda.awaitReady().getGuilds()) {
            mapGuildName.put(guild.getIdLong(), guild.getName());
        }

    }
}
