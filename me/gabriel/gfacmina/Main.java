package me.gabriel.gfacmina;

import org.black_ixx.playerpoints.PlayerPoints;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import me.gabriel.gfacmina.eventos.BlockBreakEvent;
import me.gabriel.gfacmina.eventos.EventFactionsCreate;
import me.gabriel.gfacmina.eventos.EventFactionsDisband;
import me.gabriel.gfacmina.eventos.InventoryClickEvent;
import me.gabriel.gfacmina.eventos.PlayerChangedWorldEvent;
import me.gabriel.gfacmina.eventos.PlayerCommandPreprocessEvent;
import me.gabriel.gfacmina.manager.DataManager;
import me.gabriel.gfacmina.manager.Nivel_Manager;
import net.milkbowl.vault.economy.Economy;

public class Main extends JavaPlugin {

    public static Economy economy;
	private static Main main;
	public static PlayerPoints playerpoints;

	public void onEnable() {
		enablePlugin();
		registrarEventos();
	}

	@Override
	public void onDisable() {
		disablePlugin();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void enablePlugin() {
		main = this;
		setupEconomy();
        Main.playerpoints = (PlayerPoints)PlayerPoints.getPlugin((Class)PlayerPoints.class);
		gerarData();
		Nivel_Manager.load();
		sheduler();
		saveDefaultConfig();
	}

	private void registrarEventos() {
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new EventFactionsCreate(), this);
		pm.registerEvents(new EventFactionsDisband(), this);
		pm.registerEvents(new PlayerCommandPreprocessEvent(), this);
		pm.registerEvents(new InventoryClickEvent(), this);
		pm.registerEvents(new PlayerChangedWorldEvent(), this);
		pm.registerEvents(new BlockBreakEvent(), this);
	}
	
	private void disablePlugin() {
		try {
			Nivel_Manager.save();
			HandlerList.unregisterAll(this);
			Bukkit.getScheduler().cancelTasks(this);
		} catch (Throwable e) {}
	}

	private void gerarData() {
		DataManager.createFolder("data");
	}

	public static Main get() {
		return main;
	}
	
	private void sheduler() {
        final int autosaveInterval = 1 * 1200;
        if (autosaveInterval > 0) {
            this.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin)this, (Runnable)new Runnable() {
                public void run() {
                    final int saved = Nivel_Manager.save();
                    if (saved > 0) {
                    	Bukkit.getConsoleSender().sendMessage("§a[gFacMina] Auto-Save > Foi salvo um total de " + saved + " minas de facções.");
                    }
                }
            }, (long)autosaveInterval, (long)autosaveInterval);
        }
		
	}

    @SuppressWarnings({ "unchecked", "rawtypes" })
	private boolean setupEconomy() {
        final RegisteredServiceProvider<Economy> economyProvider = (RegisteredServiceProvider<Economy>)this.getServer().getServicesManager().getRegistration((Class)Economy.class);
        if (economyProvider != null) {
            Main.economy = (Economy)economyProvider.getProvider();
        }
        return Main.economy != null;
    }
}
