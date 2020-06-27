package me.gabriel.gfacmina.manager;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

public class Nivel_Manager {

    private static HashMap<String, String> Nivel = new HashMap<String, String>();
    
    public static void load() {
        final File file = DataManager.getFolder("data");
        int i = 0;
        for (final String n : file.list()) {
        	i ++;
        	final String fac��o = n.trim().replace(".yml", "");
            final File file2 = DataManager.getFile(fac��o, "data");
            final FileConfiguration config = DataManager.getConfiguration(file2);
            final String n�vel = config.getString("Nivel");
            Nivel.put(fac��o, n�vel);
        }
        Bukkit.getConsoleSender().sendMessage("�a[gFacMina] Foi carregado um total de <i> n�veis de fac��e(s)".replace("<i>", String.valueOf(i)));
    }

    public static int save() {
        int saved = 0;
        final Iterator<Map.Entry<String, String>> Iterator = Nivel.entrySet().iterator();
        while (Iterator.hasNext()) {
            final Map.Entry<String, String> entry = Iterator.next();
            final String fac��o = entry.getKey();
            final String nivel = entry.getValue();
            final File file = DataManager.getFile(fac��o, "data");
            if (nivel == null) {
                file.delete();
                Iterator.remove();
            }
            else {
                try {
                    final FileConfiguration config = DataManager.getConfiguration(file);
                    config.set("Nivel", nivel);
                    config.save(file);
                    ++saved;
                }
                catch (IOException e) {
                    Bukkit.getConsoleSender().sendMessage("�c[gFacMina] N�o foi poss�vel salvar o n�vel da fac��o <fac>, mande o c�digo do erro para o Gabriel Alves ".replace("<fac>", file.getName()) + e);
                }
            }
        }
        return saved;
    }
	
	public static int get(String fac��o) {
		final String nome_da_fac��o = fac��o;
		final int n�vel = Integer.valueOf(Nivel.get(nome_da_fac��o));
        return n�vel;
	}
	
	public static void add(String fac��o, int nivel) {
		final String nome_da_fac��o = fac��o;
		int n�vel = Integer.valueOf(Nivel.get(nome_da_fac��o)) + nivel;
		Nivel.put(nome_da_fac��o, String.valueOf(n�vel));
	}
	
	public static void set(String fac��o, int nivel) {
		final String nome_da_fac��o = fac��o;
		final String n�vel = String.valueOf(nivel);
		Nivel.put(nome_da_fac��o, n�vel);
	}
	
	public static boolean is(String fac��o) {
        if (!Nivel.containsKey(fac��o)) {
        	return false;
        }
        return true;
	}
	
    public static void remove(final String fac��o) {
        Nivel.put(fac��o, null);
    }

    public static void delete(final String fac��o) {
        if (!is(fac��o)) {
            return;
        }
        final File file = DataManager.getFile(fac��o, "data");
        remove(fac��o);
        file.delete();
    }

}
