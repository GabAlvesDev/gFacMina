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
        	final String facção = n.trim().replace(".yml", "");
            final File file2 = DataManager.getFile(facção, "data");
            final FileConfiguration config = DataManager.getConfiguration(file2);
            final String nível = config.getString("Nivel");
            Nivel.put(facção, nível);
        }
        Bukkit.getConsoleSender().sendMessage("§a[gFacMina] Foi carregado um total de <i> níveis de facçõe(s)".replace("<i>", String.valueOf(i)));
    }

    public static int save() {
        int saved = 0;
        final Iterator<Map.Entry<String, String>> Iterator = Nivel.entrySet().iterator();
        while (Iterator.hasNext()) {
            final Map.Entry<String, String> entry = Iterator.next();
            final String facção = entry.getKey();
            final String nivel = entry.getValue();
            final File file = DataManager.getFile(facção, "data");
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
                    Bukkit.getConsoleSender().sendMessage("§c[gFacMina] Não foi possível salvar o nível da facção <fac>, mande o código do erro para o Gabriel Alves ".replace("<fac>", file.getName()) + e);
                }
            }
        }
        return saved;
    }
	
	public static int get(String facção) {
		final String nome_da_facção = facção;
		final int nível = Integer.valueOf(Nivel.get(nome_da_facção));
        return nível;
	}
	
	public static void add(String facção, int nivel) {
		final String nome_da_facção = facção;
		int nível = Integer.valueOf(Nivel.get(nome_da_facção)) + nivel;
		Nivel.put(nome_da_facção, String.valueOf(nível));
	}
	
	public static void set(String facção, int nivel) {
		final String nome_da_facção = facção;
		final String nível = String.valueOf(nivel);
		Nivel.put(nome_da_facção, nível);
	}
	
	public static boolean is(String facção) {
        if (!Nivel.containsKey(facção)) {
        	return false;
        }
        return true;
	}
	
    public static void remove(final String facção) {
        Nivel.put(facção, null);
    }

    public static void delete(final String facção) {
        if (!is(facção)) {
            return;
        }
        final File file = DataManager.getFile(facção, "data");
        remove(facção);
        file.delete();
    }

}
