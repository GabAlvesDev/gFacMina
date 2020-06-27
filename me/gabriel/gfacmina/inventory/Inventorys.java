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
	
	public static void Menu_Principal(final Player player, String fac��o) {
		final MPlayer mplayer = MPlayer.get(player);
		final String nome_da_fac��o = mplayer.getFactionName();
        final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 54, "[" + nome_da_fac��o + "] Mina�1�2�3�4");
        final ItemStack ir_mina = new ItemBuilder(Material.GRASS)
        		.setName("�eTeleporte at� a mina")
        		.setLore("�7Ao �fclicar aqui �7voc� ser� teleportado para �fmina �7."
        				, "�fOBS: �7A mina de fac��es � a mesma que a mina normal,"
        				, "�7a mina de fac��es serve apenas para adquirir vantagens.")
        		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
        		.toItemStack();
        final ItemStack velocidade = new ItemBuilder(Material.POTION)
        		.setName("�bVelocidade")
        		.setLore("�7Ao adquirir est� vantagem sua fac��o"
        				,"�7ir� receber �fVelocidade III �7no mundo de minera��o."
        				, ""
        				,"�eVantagem adquirirda no n�vel: �f1")
        		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
        		.toItemStack();
        final ItemStack moeda = new ItemBuilder(Material.DOUBLE_PLANT)
        		.setName("�6Moeda de Repara��o")
        		.setEnchant(Enchantment.DURABILITY, 1)
        		.setLore("�7Ao adquirir est� vantagem sua fac��o"
        				,"�7ao minerar ter�o chances de encontar"
        				, "�7uma �fMoeda de Repara��o7."
        				, ""
        				,"�eVantagem adquirirda no n�vel: �f2")
        		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
        		.addItemFlag(ItemFlag.HIDE_ENCHANTS)
        		.toItemStack();
        final ItemStack ma�a = new ItemBuilder(Material.GOLDEN_APPLE)
        		.setName("�dMa�a Dourada")
        		.setEnchant(Enchantment.DURABILITY, 1)
        		.setLore("�7Ao adquirir est� vantagem sua fac��o"
        				,"�7ao minerar ter� chances de encontar"
        				, "�7uma �fMa�a Dourada�7."
        				, ""
        				, "�eVantagem adquirirda no n�vel: �f3")
        		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
        		.addItemFlag(ItemFlag.HIDE_ENCHANTS)
        		.toItemStack();
        final ItemStack experi�ncia = new ItemBuilder(Material.EXP_BOTTLE)
        		.setName("�aExperi�ncia")
        		.setEnchant(Enchantment.DURABILITY, 1)
        		.setLore("�7Ao adquirir est� vantagem sua fac��o"
        				,"�7ao minerar, a quantidade de �fXP �7ganho ser� dobrado."
        				, ""
        				, "�eVantagem adquirirda no n�vel: �f4")
        		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
        		.addItemFlag(ItemFlag.HIDE_ENCHANTS)
        		.toItemStack();
        final ItemStack durabilidade = new ItemBuilder(Material.BEDROCK)
        		.setName("�3Durabilidade")
        		.setEnchant(Enchantment.DURABILITY, 1)
        		.setLore("�7Ao adquirir est� vantagem sua fa��o ao minerar"
        				,"�7a �fdubilidade �7de suas farramentas n�o ser�o alteradas."
        				, ""
        				, "�eVantagem adquirirda no n�vel: �f5")
        		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
        		.addItemFlag(ItemFlag.HIDE_ENCHANTS)
        		.toItemStack();
        final ItemStack indispon�vel = new ItemBuilder(Material.BARRIER)
        		.setName("�cIndispon�vel")
        		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
        		.toItemStack();
        inv.setItem(4, ir_mina);
        inv.setItem(19, velocidade);
        inv.setItem(20, moeda);
		inv.setItem(21, ma�a);
		inv.setItem(22, experi�ncia);
		inv.setItem(23, durabilidade);
		inv.setItem(24, indispon�vel);
		inv.setItem(25, indispon�vel);
		inv.setItem(40, Evoluir_Mina(nome_da_fac��o));
        player.openInventory(inv);
	}
	
	public static ItemStack Evoluir_Mina(final String nome_da_fac��o) {
		ItemStack i = null;
		int n�vel = Nivel_Manager.get(nome_da_fac��o);
		switch (n�vel) {
		case 0:
	        i = new ItemBuilder(Material.EMERALD)
    		.setName("�aEvoluir mina")
    		.setEnchant(Enchantment.DURABILITY, 1)
    		.setLore("�7Clique aqui para �fevoluir �7a mina de sua"
    				,"�7fac��o para o pr�ximo n�vel."
    				, ""
    				, "�7N�vel atual: �f" + n�vel
    				, ""
    				, "�7Custo para o pr�ximo n�vel: �6250.000 �2$")
    		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
    		.addItemFlag(ItemFlag.HIDE_ENCHANTS)
    		.toItemStack();
			break;
		case 1:
	        i = new ItemBuilder(Material.EMERALD)
    		.setName("�aEvoluir mina")
    		.setEnchant(Enchantment.DURABILITY, 1)
    		.setLore("�7Clique aqui para �fevoluir �7a mina de sua"
    				,"�7fac��o para o pr�ximo n�vel."
    				, ""
    				, "�7N�vel atual: �f" + n�vel
    				, ""
    				, "�7Custo para o pr�ximo n�vel: �6550.000 �2$")
    		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
    		.addItemFlag(ItemFlag.HIDE_ENCHANTS)
    		.toItemStack();
			break;
		case 2:
	        i = new ItemBuilder(Material.EMERALD)
    		.setName("�aEvoluir mina")
    		.setEnchant(Enchantment.DURABILITY, 1)
    		.setLore("�7Clique aqui para �fevoluir �7a mina de sua"
    				,"�7fac��o para o pr�ximo n�vel."
    				, ""
    				, "�7N�vel atual: �f" + n�vel
    				, ""
    				, "�7Custo para o pr�ximo n�vel: �6850.000 �2$")
    		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
    		.addItemFlag(ItemFlag.HIDE_ENCHANTS)
    		.toItemStack();
			break;
		case 3:
	        i = new ItemBuilder(Material.EMERALD)
    		.setName("�aEvoluir mina")
    		.setEnchant(Enchantment.DURABILITY, 1)
    		.setLore("�7Clique aqui para �fevoluir �7a mina de sua"
    				,"�7fac��o para o pr�ximo n�vel."
    				, ""
    				, "�7N�vel atual: �f" + n�vel
    				, ""
    				, "�7Custo para o pr�ximo n�vel: �620.000 �fde cash")
    		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
    		.addItemFlag(ItemFlag.HIDE_ENCHANTS)
    		.toItemStack();
			break;
		case 4:
	        i = new ItemBuilder(Material.EMERALD)
    		.setName("�aEvoluir mina")
    		.setEnchant(Enchantment.DURABILITY, 1)
    		.setLore("�7Clique aqui para �fevoluir �7a mina de sua"
    				,"�7fac��o para o pr�ximo n�vel."
    				, ""
    				, "�7N�vel atual: �f" + n�vel
    				, ""
    				, "�7Custo para o pr�ximo n�vel: �630.000 �fde cash")
    		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
    		.addItemFlag(ItemFlag.HIDE_ENCHANTS)
    		.toItemStack();
			break;
		default:
	        i = new ItemBuilder(Material.EMERALD)
    		.setName("�aEvoluir mina")
    		.setEnchant(Enchantment.DURABILITY, 1)
    		.setLore("�7Clique aqui para �fevoluir �7a mina de sua"
    				,"�7fac��o para o pr�ximo n�vel."
    				, ""
    				, "�7N�vel atual: �f" + n�vel
    				, ""
    				, "�7Custo para o pr�ximo n�vel: �cN�vel m�ximo!")
    		.addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
    		.addItemFlag(ItemFlag.HIDE_ENCHANTS)
    		.toItemStack();
			break;
		}
		return i;
	}

}
