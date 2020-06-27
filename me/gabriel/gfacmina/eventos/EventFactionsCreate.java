package me.gabriel.gfacmina.eventos;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.gabriel.gfacmina.manager.Nivel_Manager;


public class EventFactionsCreate implements Listener {
	
	@EventHandler
	private void create(final com.massivecraft.factions.event.EventFactionsCreate event) {
		final String nome_da_fac��o = event.getFactionName();
		if (!Nivel_Manager.is(nome_da_fac��o)) {
			Nivel_Manager.set(nome_da_fac��o, 0);
		}
	}

}
