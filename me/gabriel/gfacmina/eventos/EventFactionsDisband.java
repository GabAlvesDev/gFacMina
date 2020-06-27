package me.gabriel.gfacmina.eventos;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.gabriel.gfacmina.manager.Nivel_Manager;

public class EventFactionsDisband implements Listener{
	
	@EventHandler
	private void onEventFactionsDisband(final com.massivecraft.factions.event.EventFactionsDisband event) {
		final String nome_da_facção = event.getFaction().getName();
		Nivel_Manager.delete(nome_da_facção);
	}

}
