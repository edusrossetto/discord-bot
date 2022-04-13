package br.com.lightflow.main;

import java.io.IOException;
import java.text.ParseException;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.login.LoginException;

import br.com.lightflow.actions.CapturePokemon;
import br.com.lightflow.actions.CaptureProcess;
import br.com.lightflow.actions.EvolvePokemon;
import br.com.lightflow.actions.MemberLeave;
import br.com.lightflow.actions.NewMember;
import br.com.lightflow.commands.ClearChannel;
import br.com.lightflow.commands.ListPokemons;
import br.com.lightflow.commands.MultiplePokemon;
import br.com.lightflow.commands.PokemonStatus;
import br.com.lightflow.commands.RandomPokemon;
import br.com.lightflow.commands.Status;
import br.com.lightflow.commands.TestCommand;
import br.com.lightflow.java.PokeUtility;
import br.com.lightflow.security.Token;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.requests.GatewayIntent;

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
        jda.addEventListener(new PokeUtility());
        jda.addEventListener(new CapturePokemon());
        jda.addEventListener(new CaptureProcess());
        jda.addEventListener(new NewMember());
        jda.addEventListener(new MemberLeave());
        jda.addEventListener(new EvolvePokemon());
        jda.addEventListener(new ListPokemons());

        // Iterando os servidores que o andrômeda está!
        for (Guild guild : jda.awaitReady().getGuilds()) {
            mapGuildName.put(guild.getIdLong(), guild.getName());
        }

    }
}
