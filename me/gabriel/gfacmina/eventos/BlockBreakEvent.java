package me.gabriel.gfacmina.eventos;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import com.massivecraft.factions.entity.MPlayer;

import me.gabriel.gfacmina.Main;
import me.gabriel.gfacmina.manager.Nivel_Manager;
import me.gabriel.gfacmina.utils.ItemBuilder;

public class BlockBreakEvent implements Listener{

	@EventHandler
	private void onBlockBreakEvent_durabilidade(final org.bukkit.event.block.BlockBreakEvent event) {
		final Player player = event.getPlayer();
		final MPlayer mplayer = MPlayer.get(player);
		final String nome_da_facção = mplayer.getFactionName();
		final String world = player.getWorld().getName();
		final String mundo_mina = Main.get().getConfig().getString("Config.Mundo");
		if (!world.equalsIgnoreCase(mundo_mina)) {
			return;
		}
		if (Nivel_Manager.get(nome_da_facção) >= 5 ) {
			if (player.getItemInHand().getType().name().toLowerCase().endsWith("_pickaxe")) {
				player.getItemInHand().setDurability((short) 0);
				return;
			}
			if (player.getItemInHand().getType().name().toLowerCase().endsWith("_sword")) {
				player.getItemInHand().setDurability((short) 0);
				return;
			}
		}
	}
	
	@EventHandler
	private void onBlockBreakEvent_Xp(final org.bukkit.event.block.BlockBreakEvent event) {
		final Player player = event.getPlayer();
		final MPlayer mplayer = MPlayer.get(player);
		final String nome_da_facção = mplayer.getFactionName();
		final String world = player.getWorld().getName();
		final String mundo_mina = Main.get().getConfig().getString("Config.Mundo");
		if (!world.equalsIgnoreCase(mundo_mina)) {
			return;
		}
		if (Nivel_Manager.get(nome_da_facção) >= 4 ) {
			event.setExpToDrop(event.getExpToDrop() * 2);
		}
	}

	@EventHandler
	private void onBlockBreakEvent_Maça(final org.bukkit.event.block.BlockBreakEvent event) {
		final Player player = event.getPlayer();
		final MPlayer mplayer = MPlayer.get(player);
		final String nome_da_facção = mplayer.getFactionName();
		final String world = player.getWorld().getName();
		final String mundo_mina = Main.get().getConfig().getString("Config.Mundo");
		if (!world.equalsIgnoreCase(mundo_mina)) {
			return;
		}
		if (Nivel_Manager.get(nome_da_facção) >= 3 ) {
			final ItemStack i = new ItemBuilder(Material.GOLDEN_APPLE)
					.setName("§dMaça Dourada")
					.toItemStack();
			if (this.percentChance(Main.get().getConfig().getDouble("Config.Chance.Apple-Dourada"))) {
	        	player.getWorld().dropItemNaturally(player.getLocation(), i);
	        	player.sendMessage("§aVocê encontrou uma " + i.getItemMeta().getDisplayName());
			}
		}
	}
	
	@EventHandler
	private void onBlockBreakEvent_Moeda(final org.bukkit.event.block.BlockBreakEvent event) {
		final Player player = event.getPlayer();
		final MPlayer mplayer = MPlayer.get(player);
		final String nome_da_facção = mplayer.getFactionName();
		final String world = player.getWorld().getName();
		final String mundo_mina = Main.get().getConfig().getString("Config.Mundo");
		if (!world.equalsIgnoreCase(mundo_mina)) {
			return;
		}
		if (Nivel_Manager.get(nome_da_facção) >= 2 ) {
	    	final ItemStack i = new ItemBuilder(Material.DOUBLE_PLANT)
	    			.setName("§6Moeda de Reparação")
	    			.setEnchant(Enchantment.DURABILITY, 1)
	    			.addItemFlag(ItemFlag.HIDE_ENCHANTS)
	    			.toItemStack();
			if (this.percentChance(Main.get().getConfig().getDouble("Config.Chance.Moeda-Repair"))) {
	        	player.getWorld().dropItemNaturally(player.getLocation(), i);
	        	player.sendMessage("§aVocê encontrou uma " + i.getItemMeta().getDisplayName());
			}
		}
	}

	protected final boolean percentChance(final double percent) {
		if (percent < 0.0 || percent > 100.0) {
			throw new IllegalArgumentException("A percentagem nao pode ser maior do que 100 nem menor do que 0");
		}
		final double result = new Random().nextDouble() * 100.0;
		return result <= percent;
	}

}
