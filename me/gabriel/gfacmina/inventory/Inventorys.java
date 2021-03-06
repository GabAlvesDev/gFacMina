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
	
	public static void Menu_Principal(final Player player, String fac玢o) {
		final MPlayer mplayer = MPlayer.get(player);
		final String nome_da_fac玢o = mplayer.getFactionName();
        final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 54, "[" + nome_da_fac玢o + "] Mina񗉲񗱌");
        final ItemStack ir_mina = new ItemBuilder(Material.GRASS)
        		.setName("Teleporte at� a mina")
        		.setLore("�7Ao clicar aqui �7voc� ser� teleportado para mina �7."
        				, "OBS: �7A mina de fac珲es � a mesma que a mina normal,"
        				, "�7a mina de fac珲es serve apenas para adquirir vantagens.")
        		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
        		.toItemStack();
        final ItemStack velocidade = new ItemBuilder(Material.POTION)
        		.setName("Velocidade")
        		.setLore("�7Ao adquirir est� vantagem sua fac玢o"
        				,"�7ir� receber Velocidade III �7no mundo de minera玢o."
        				, ""
        				,"Vantagem adquirirda no n韛el: 1")
        		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
        		.toItemStack();
        final ItemStack moeda = new ItemBuilder(Material.DOUBLE_PLANT)
        		.setName("�6Moeda de Repara玢o")
        		.setEnchant(Enchantment.DURABILITY, 1)
        		.setLore("�7Ao adquirir est� vantagem sua fac玢o"
        				,"�7ao minerar ter鉶 chances de encontar"
        				, "�7uma Moeda de Repara玢o7."
        				, ""
        				,"Vantagem adquirirda no n韛el: 2")
        		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
        		.addItemFlag(ItemFlag.HIDE_ENCHANTS)
        		.toItemStack();
        final ItemStack ma鏰 = new ItemBuilder(Material.GOLDEN_APPLE)
        		.setName("Ma鏰 Dourada")
        		.setEnchant(Enchantment.DURABILITY, 1)
        		.setLore("�7Ao adquirir est� vantagem sua fac玢o"
        				,"�7ao minerar ter� chances de encontar"
        				, "�7uma Ma鏰 Dourada�7."
        				, ""
        				, "Vantagem adquirirda no n韛el: 3")
        		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
        		.addItemFlag(ItemFlag.HIDE_ENCHANTS)
        		.toItemStack();
        final ItemStack experi阯cia = new ItemBuilder(Material.EXP_BOTTLE)
        		.setName("Experi阯cia")
        		.setEnchant(Enchantment.DURABILITY, 1)
        		.setLore("�7Ao adquirir est� vantagem sua fac玢o"
        				,"�7ao minerar, a quantidade de XP �7ganho ser� dobrado."
        				, ""
        				, "Vantagem adquirirda no n韛el: 4")
        		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
        		.addItemFlag(ItemFlag.HIDE_ENCHANTS)
        		.toItemStack();
        final ItemStack durabilidade = new ItemBuilder(Material.BEDROCK)
        		.setName("�3Durabilidade")
        		.setEnchant(Enchantment.DURABILITY, 1)
        		.setLore("�7Ao adquirir est� vantagem sua fa玢o ao minerar"
        				,"�7a dubilidade �7de suas farramentas n鉶 ser鉶 alteradas."
        				, ""
        				, "Vantagem adquirirda no n韛el: 5")
        		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
        		.addItemFlag(ItemFlag.HIDE_ENCHANTS)
        		.toItemStack();
        final ItemStack indispon韛el = new ItemBuilder(Material.BARRIER)
        		.setName("Indispon韛el")
        		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
        		.toItemStack();
        inv.setItem(4, ir_mina);
        inv.setItem(19, velocidade);
        inv.setItem(20, moeda);
		inv.setItem(21, ma鏰);
		inv.setItem(22, experi阯cia);
		inv.setItem(23, durabilidade);
		inv.setItem(24, indispon韛el);
		inv.setItem(25, indispon韛el);
		inv.setItem(40, Evoluir_Mina(nome_da_fac玢o));
        player.openInventory(inv);
	}
	
	public static ItemStack Evoluir_Mina(final String nome_da_fac玢o) {
		ItemStack i = null;
		int n韛el = Nivel_Manager.get(nome_da_fac玢o);
		switch (n韛el) {
		case 0:
	        i = new ItemBuilder(Material.EMERALD)
    		.setName("Evoluir mina")
    		.setEnchant(Enchantment.DURABILITY, 1)
    		.setLore("�7Clique aqui para evoluir �7a mina de sua"
    				,"�7fac玢o para o pr髕imo n韛el."
    				, ""
    				, "�7N韛el atual: " + n韛el
    				, ""
    				, "�7Custo para o pr髕imo n韛el: �6250.000 �2$")
    		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
    		.addItemFlag(ItemFlag.HIDE_ENCHANTS)
    		.toItemStack();
			break;
		case 1:
	        i = new ItemBuilder(Material.EMERALD)
    		.setName("Evoluir mina")
    		.setEnchant(Enchantment.DURABILITY, 1)
    		.setLore("�7Clique aqui para evoluir �7a mina de sua"
    				,"�7fac玢o para o pr髕imo n韛el."
    				, ""
    				, "�7N韛el atual: " + n韛el
    				, ""
    				, "�7Custo para o pr髕imo n韛el: �6550.000 �2$")
    		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
    		.addItemFlag(ItemFlag.HIDE_ENCHANTS)
    		.toItemStack();
			break;
		case 2:
	        i = new ItemBuilder(Material.EMERALD)
    		.setName("Evoluir mina")
    		.setEnchant(Enchantment.DURABILITY, 1)
    		.setLore("�7Clique aqui para evoluir �7a mina de sua"
    				,"�7fac玢o para o pr髕imo n韛el."
    				, ""
    				, "�7N韛el atual: " + n韛el
    				, ""
    				, "�7Custo para o pr髕imo n韛el: �6850.000 �2$")
    		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
    		.addItemFlag(ItemFlag.HIDE_ENCHANTS)
    		.toItemStack();
			break;
		case 3:
	        i = new ItemBuilder(Material.EMERALD)
    		.setName("Evoluir mina")
    		.setEnchant(Enchantment.DURABILITY, 1)
    		.setLore("�7Clique aqui para evoluir �7a mina de sua"
    				,"�7fac玢o para o pr髕imo n韛el."
    				, ""
    				, "�7N韛el atual: " + n韛el
    				, ""
    				, "�7Custo para o pr髕imo n韛el: �620.000 de cash")
    		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
    		.addItemFlag(ItemFlag.HIDE_ENCHANTS)
    		.toItemStack();
			break;
		case 4:
	        i = new ItemBuilder(Material.EMERALD)
    		.setName("Evoluir mina")
    		.setEnchant(Enchantment.DURABILITY, 1)
    		.setLore("�7Clique aqui para evoluir �7a mina de sua"
    				,"�7fac玢o para o pr髕imo n韛el."
    				, ""
    				, "�7N韛el atual: " + n韛el
    				, ""
    				, "�7Custo para o pr髕imo n韛el: �630.000 de cash")
    		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
    		.addItemFlag(ItemFlag.HIDE_ENCHANTS)
    		.toItemStack();
			break;
		default:
	        i = new ItemBuilder(Material.EMERALD)
    		.setName("Evoluir mina")
    		.setEnchant(Enchantment.DURABILITY, 1)
    		.setLore("�7Clique aqui para evoluir �7a mina de sua"
    				,"�7fac玢o para o pr髕imo n韛el."
    				, ""
    				, "�7N韛el atual: " + n韛el
    				, ""
    				, "�7Custo para o pr髕imo n韛el: N韛el m醲imo!")
    		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
    		.addItemFlag(ItemFlag.HIDE_ENCHANTS)
    		.toItemStack();
			break;
		}
		return i;
	}

}
