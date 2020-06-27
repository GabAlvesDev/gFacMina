package me.gabriel.gfacmina.eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import com.massivecraft.factions.entity.MPlayer;

import me.gabriel.gfacmina.inventory.Inventorys;

public class PlayerCommandPreprocessEvent implements Listener {
    
	@EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onPlayerCommandPreprocessEvent(final org.bukkit.event.player.PlayerCommandPreprocessEvent e) {
        final String message = e.getMessage().toLowerCase();
        if (message.startsWith("/f mina")) {
            e.setCancelled(true);
            final Player player = e.getPlayer();
            final MPlayer mplayer = MPlayer.get(player);
            final String nome_da_fac��o = mplayer.getFaction().getName();
            if (!mplayer.hasFaction()) {
            	player.sendMessage("�cVoc� n�o est� em nenhuma fac��o, portanto voc� n�o tem acesso a evolu�r a fac��o!");
            	return;
            }
            Inventorys.Menu_Principal(player, nome_da_fac��o);
        }
    }
}
