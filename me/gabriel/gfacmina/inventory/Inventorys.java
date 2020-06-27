package me.gabriel.gfacmina.inventory;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import com.massivecraft.factions.entity.MPlayer;

import me.gabriel.gfacmina.manager.Nivel_Manager;
import me.gabriel.gfacmina.utils.ItemBuilder;

public class Inventorys {
	
	public static void Menu_Principal(final Player player, String facção) {
		final MPlayer mplayer = MPlayer.get(player);
		final String nome_da_facção = mplayer.getFactionName();
        final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 54, "[" + nome_da_facção + "] Mina§1§2§3§4");
        final ItemStack ir_mina = new ItemBuilder(Material.GRASS)
        		.setName("§eTeleporte até a mina")
        		.setLore("§7Ao §fclicar aqui §7você será teleportado para §fmina §7."
        				, "§fOBS: §7A mina de facções é a mesma que a mina normal,"
        				, "§7a mina de facções serve apenas para adquirir vantagens.")
        		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
        		.toItemStack();
        final ItemStack velocidade = new ItemBuilder(Material.POTION)
        		.setName("§bVelocidade")
        		.setLore("§7Ao adquirir esté vantagem sua facção"
        				,"§7irá receber §fVelocidade III §7no mundo de mineração."
        				, ""
        				,"§eVantagem adquirirda no nível: §f1")
        		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
        		.toItemStack();
        final ItemStack moeda = new ItemBuilder(Material.DOUBLE_PLANT)
        		.setName("§6Moeda de Reparação")
        		.setEnchant(Enchantment.DURABILITY, 1)
        		.setLore("§7Ao adquirir está vantagem sua facção"
        				,"§7ao minerar terão chances de encontar"
        				, "§7uma §fMoeda de Reparação7."
        				, ""
        				,"§eVantagem adquirirda no nível: §f2")
        		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
        		.addItemFlag(ItemFlag.HIDE_ENCHANTS)
        		.toItemStack();
        final ItemStack maça = new ItemBuilder(Material.GOLDEN_APPLE)
        		.setName("§dMaça Dourada")
        		.setEnchant(Enchantment.DURABILITY, 1)
        		.setLore("§7Ao adquirir está vantagem sua facção"
        				,"§7ao minerar terá chances de encontar"
        				, "§7uma §fMaça Dourada§7."
        				, ""
        				, "§eVantagem adquirirda no nível: §f3")
        		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
        		.addItemFlag(ItemFlag.HIDE_ENCHANTS)
        		.toItemStack();
        final ItemStack experiência = new ItemBuilder(Material.EXP_BOTTLE)
        		.setName("§aExperiência")
        		.setEnchant(Enchantment.DURABILITY, 1)
        		.setLore("§7Ao adquirir está vantagem sua facção"
        				,"§7ao minerar, a quantidade de §fXP §7ganho será dobrado."
        				, ""
        				, "§eVantagem adquirirda no nível: §f4")
        		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
        		.addItemFlag(ItemFlag.HIDE_ENCHANTS)
        		.toItemStack();
        final ItemStack durabilidade = new ItemBuilder(Material.BEDROCK)
        		.setName("§3Durabilidade")
        		.setEnchant(Enchantment.DURABILITY, 1)
        		.setLore("§7Ao adquirir está vantagem sua fação ao minerar"
        				,"§7a §fdubilidade §7de suas farramentas não serão alteradas."
        				, ""
        				, "§eVantagem adquirirda no nível: §f5")
        		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
        		.addItemFlag(ItemFlag.HIDE_ENCHANTS)
        		.toItemStack();
        final ItemStack indisponível = new ItemBuilder(Material.BARRIER)
        		.setName("§cIndisponível")
        		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
        		.toItemStack();
        inv.setItem(4, ir_mina);
        inv.setItem(19, velocidade);
        inv.setItem(20, moeda);
		inv.setItem(21, maça);
		inv.setItem(22, experiência);
		inv.setItem(23, durabilidade);
		inv.setItem(24, indisponível);
		inv.setItem(25, indisponível);
		inv.setItem(40, Evoluir_Mina(nome_da_facção));
        player.openInventory(inv);
	}
	
	public static ItemStack Evoluir_Mina(final String nome_da_facção) {
		ItemStack i = null;
		int nível = Nivel_Manager.get(nome_da_facção);
		switch (nível) {
		case 0:
	        i = new ItemBuilder(Material.EMERALD)
    		.setName("§aEvoluir mina")
    		.setEnchant(Enchantment.DURABILITY, 1)
    		.setLore("§7Clique aqui para §fevoluir §7a mina de sua"
    				,"§7facção para o próximo nível."
    				, ""
    				, "§7Nível atual: §f" + nível
    				, ""
    				, "§7Custo para o próximo nível: §6250.000 §2$")
    		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
    		.addItemFlag(ItemFlag.HIDE_ENCHANTS)
    		.toItemStack();
			break;
		case 1:
	        i = new ItemBuilder(Material.EMERALD)
    		.setName("§aEvoluir mina")
    		.setEnchant(Enchantment.DURABILITY, 1)
    		.setLore("§7Clique aqui para §fevoluir §7a mina de sua"
    				,"§7facção para o próximo nível."
    				, ""
    				, "§7Nível atual: §f" + nível
    				, ""
    				, "§7Custo para o próximo nível: §6550.000 §2$")
    		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
    		.addItemFlag(ItemFlag.HIDE_ENCHANTS)
    		.toItemStack();
			break;
		case 2:
	        i = new ItemBuilder(Material.EMERALD)
    		.setName("§aEvoluir mina")
    		.setEnchant(Enchantment.DURABILITY, 1)
    		.setLore("§7Clique aqui para §fevoluir §7a mina de sua"
    				,"§7facção para o próximo nível."
    				, ""
    				, "§7Nível atual: §f" + nível
    				, ""
    				, "§7Custo para o próximo nível: §6850.000 §2$")
    		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
    		.addItemFlag(ItemFlag.HIDE_ENCHANTS)
    		.toItemStack();
			break;
		case 3:
	        i = new ItemBuilder(Material.EMERALD)
    		.setName("§aEvoluir mina")
    		.setEnchant(Enchantment.DURABILITY, 1)
    		.setLore("§7Clique aqui para §fevoluir §7a mina de sua"
    				,"§7facção para o próximo nível."
    				, ""
    				, "§7Nível atual: §f" + nível
    				, ""
    				, "§7Custo para o próximo nível: §620.000 §fde cash")
    		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
    		.addItemFlag(ItemFlag.HIDE_ENCHANTS)
    		.toItemStack();
			break;
		case 4:
	        i = new ItemBuilder(Material.EMERALD)
    		.setName("§aEvoluir mina")
    		.setEnchant(Enchantment.DURABILITY, 1)
    		.setLore("§7Clique aqui para §fevoluir §7a mina de sua"
    				,"§7facção para o próximo nível."
    				, ""
    				, "§7Nível atual: §f" + nível
    				, ""
    				, "§7Custo para o próximo nível: §630.000 §fde cash")
    		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
    		.addItemFlag(ItemFlag.HIDE_ENCHANTS)
    		.toItemStack();
			break;
		default:
	        i = new ItemBuilder(Material.EMERALD)
    		.setName("§aEvoluir mina")
    		.setEnchant(Enchantment.DURABILITY, 1)
    		.setLore("§7Clique aqui para §fevoluir §7a mina de sua"
    				,"§7facção para o próximo nível."
    				, ""
    				, "§7Nível atual: §f" + nível
    				, ""
    				, "§7Custo para o próximo nível: §cNível máximo!")
    		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
    		.addItemFlag(ItemFlag.HIDE_ENCHANTS)
    		.toItemStack();
			break;
		}
		return i;
	}

}
