package me.gabriel.gfacmina.eventos;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.massivecraft.factions.entity.MPlayer;

import me.gabriel.gfacmina.Main;
import me.gabriel.gfacmina.manager.Nivel_Manager;

public class PlayerChangedWorldEvent implements Listener{
	
	private ArrayList<Player> efeito = new ArrayList<Player>();
	
	@EventHandler
	private void onPlayerChangedWorldEvent(final org.bukkit.event.player.PlayerChangedWorldEvent event) {
		final Player player = event.getPlayer();
		final MPlayer mplayer = MPlayer.get(player);
		final String nome_da_facção = mplayer.getFactionName();
		final String world = player.getWorld().getName();
		final String mundo = Main.get().getConfig().getString("Config.Mundo");
		if (!world.equalsIgnoreCase(mundo)) {
			if (efeito.contains(player)) {
				player.removePotionEffect(PotionEffectType.SPEED);
				efeito.remove(player);
			}
			return;
		}
		if (!(Nivel_Manager.get(nome_da_facção) >= 1)) {
			return;
		}
		if (!efeito.contains(player)) {
			efeito.add(player);
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 2));
			player.sendMessage("§aVocê ganhou efeito velocidade III");
		}
	}

}
