package br.com.lightflow.actions;

import br.com.lightflow.security.Sqlite;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class NewMember extends ListenerAdapter {
    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        long discord_id = event.getMember().getIdLong();
        Sqlite bd = new Sqlite();
        bd.insertUser(discord_id);
    }
   
}
