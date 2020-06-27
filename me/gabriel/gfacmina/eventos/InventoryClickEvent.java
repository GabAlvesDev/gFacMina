package me.gabriel.gfacmina.eventos;


import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.Event.Result;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.massivecraft.factions.entity.MPlayer;

import me.gabriel.gfacmina.Main;
import me.gabriel.gfacmina.manager.Nivel_Manager;


public class InventoryClickEvent implements Listener{ 
	
	@SuppressWarnings({ "deprecation", "unused" })
	@EventHandler
	private void onInventoryClickEvent2(final org.bukkit.event.inventory.InventoryClickEvent e) {
		final Player player = (Player) e.getWhoClicked();
		if (e.getCursor() == null) {
			return;
		}
		if (e.getCursor().getType() == Material.AIR) {
			return;
		}
		if (!e.getCursor().hasItemMeta()) {
			return;
		}
		if (!e.getCursor().getItemMeta().hasDisplayName()) {
			return;
		}
		if (e.getCursor().getType() != Material.DOUBLE_PLANT) {
			return;
		}
		if (e.getCursor().getAmount() != 1) {
			return;
		}
		if (e.getCurrentItem() == null) {
			return;
		}
		if (e.getCurrentItem().getType() == Material.AIR) {
			return;
		}
		if (!e.getCursor().getItemMeta().getDisplayName().contains("�6Moeda de Repara��o")) {
			return;
		}
		if (e.getCurrentItem().getDurability() == 0) {
			player.sendMessage("�cEste item j� est� reparado!");
			player.playSound(player.getLocation(), Sound.BAT_DEATH, 1, 1);
			return;
		}
		if (e.getCurrentItem().getType().name().toLowerCase().endsWith("_pickaxe")) {
			ItemStack item = e.getCurrentItem();
			ItemMeta im = item.getItemMeta();
			ItemStack Item = e.getCurrentItem();
			player.playSound(player.getLocation(), Sound.ANVIL_USE, 1, 1);
			Item.setDurability((short) 0);
			e.setCurrentItem((ItemStack) Item);
			e.setCursor(null);
			player.updateInventory();
			return;
		}
		if (e.getCurrentItem().getType().name().toLowerCase().endsWith("_sword")) {
			ItemStack Item = e.getCurrentItem();
			player.playSound(player.getLocation(), Sound.ANVIL_USE, 1, 1);
			Item.setDurability((short) 0);
			e.setCurrentItem((ItemStack) Item);
			e.setCursor(null);
			player.updateInventory();
			return;
		}
	}
	
	@EventHandler
	private void onInventoryClickEvent(final org.bukkit.event.inventory.InventoryClickEvent e) {
        if (e.getSlotType() == InventoryType.SlotType.OUTSIDE) {
            return;
        }
        if (!e.getClickedInventory().getTitle().contains("Mina�1�2�3�4")) {
            return;
        }
        final Player p = (Player)e.getWhoClicked();
        e.setCancelled(true);
        e.setResult(Result.DENY);
        if (!e.isLeftClick() && e.getRawSlot() == 53) {
            return;
        }
        this.selectedItem(e.getCurrentItem(), p);
    }

    void selectedItem(final ItemStack select, final Player player) {
        final MPlayer mplayer = MPlayer.get(player);
        final String nome_da_fac��o = mplayer.getFactionName();
        int i = Nivel_Manager.get(nome_da_fac��o);
        if (select.getType().equals(Material.GRASS) && select.getItemMeta().getDisplayName().equals("�eTeleporte at� a mina")) {
        	player.closeInventory();
        	player.chat("/mina");
        	return;
        	
        }
        if (select.getType().equals(Material.EMERALD) && select.getItemMeta().getDisplayName().equals("�aEvoluir mina")) {
        	switch (i) {
			case 0:
				retirarMoney(player, nome_da_fac��o, 0);
				player.closeInventory();
				break;
			case 1:
				retirarMoney(player, nome_da_fac��o, 1);
				player.closeInventory();
				break;
			case 2:
				retirarMoney(player, nome_da_fac��o, 2);
				player.closeInventory();
				break;
			case 3:
				retirarMoney(player, nome_da_fac��o, 3);
				player.closeInventory();
				break;
			case 4:
				retirarMoney(player, nome_da_fac��o, 4);
				player.closeInventory();
				break;
			default:
				retirarMoney(player, nome_da_fac��o, 5);
				player.sendMessage("�cN�vel m�ximo atingido.");
				player.closeInventory();
				break;
			}
        	return;
        }
    }
    
    @SuppressWarnings({ "deprecation" })
	private void retirarMoney(final Player player, final String fac��o, int n�vel) {
    	int i = n�vel;
    	switch (i) {
		case 0:
			if (!Main.economy.has(player.getName(), 250000)) {
				player.sendMessage("�cVoc� n�o tem �2$ �csuficiente para completar est� a��o!");
				return;
			}
			Main.economy.bankWithdraw(player.getName(), 250000);
			Nivel_Manager.set(fac��o, 1);
			player.sendMessage("�aVoc� evoluiu � mina da sua fac��o parab�ns, agora voc�s tem novas vantagens unicas no servidor verifique todas no men� de mina da sua fac��o!");
			break;
		case 1:
			if (!Main.economy.has(player.getName(), 550000)) {
				player.sendMessage("�cVoc� n�o tem �2$ �csuficiente para completar est� a��o!");
				return;
			}
			Main.economy.bankWithdraw(player.getName(), 550000);
			Nivel_Manager.set(fac��o, 2);
			player.sendMessage("�aVoc� evoluiu � mina da sua fac��o parab�ns, agora voc�s tem novas vantagens unicas no servidor verifique todas no men� de mina da sua fac��o!");
			break;
		case 2:
			if (!Main.economy.has(player.getName(), 850000)) {
				player.sendMessage("�cVoc� n�o tem �2$ �csuficiente para completar est� a��o!");
				return;
			}
			Main.economy.bankWithdraw(player.getName(), 850000);
			Nivel_Manager.set(fac��o, 3);
			player.sendMessage("�aVoc� evoluiu � mina da sua fac��o parab�ns, agora voc�s tem novas vantagens unicas no servidor verifique todas no men� de mina da sua fac��o!");
			break;
		case 3:
			if (Main.playerpoints.getAPI().look(player.getName()) < 20000) {
				player.sendMessage("�cVoc� n�o tem �2$ �csuficiente para completar est� a��o!");
				return;
			}
			Main.playerpoints.getAPI().take(player.getName(), 20000);
			Nivel_Manager.set(fac��o, 4);
			player.sendMessage("�aVoc� evoluiu � mina da sua fac��o parab�ns, agora voc�s tem novas vantagens unicas no servidor verifique todas no men� de mina da sua fac��o!");
			break;
		case 4:
			if (Main.playerpoints.getAPI().look(player.getName()) < 30000) {
				player.sendMessage("�cVoc� n�o tem �6Cash �csuficiente para completar est� a��o!");
				return;
			}
			Main.playerpoints.getAPI().take(player.getName(), 30000);
			Nivel_Manager.set(fac��o, 5);
			player.sendMessage("�aVoc� evoluiu � mina da sua fac��o parab�ns, agora voc�s tem novas vantagens unicas no servidor verifique todas no men� de mina da sua fac��o!");
			break;
		default:
			break;
		}
    }
}
