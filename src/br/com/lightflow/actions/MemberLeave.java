package br.com.lightflow.actions;

import br.com.lightflow.security.Sqlite;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MemberLeave extends ListenerAdapter {
    @Override
    public void onGuildMemberRemove(GuildMemberRemoveEvent event) {
        long discord_id = event.getMember().getIdLong();
        Sqlite bd = new Sqlite();
        bd.deleteUser(discord_id);
        
    }
   
}
