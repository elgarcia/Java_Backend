package Ejercicio07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.prefs.Preferences;

public class Ejercicio07 {
	private static final String USER_HOME = System.getProperty("user.home");
	public static void main(String[] args) {
		long        startTime = System.currentTimeMillis();
		Preferences userPrefs = Preferences.userRoot().node(Ejercicio07.class.getName());
		File        propiertyFile = new File(USER_HOME, "configuraciones.properties");
		Properties  properties = new Properties();

		if (propiertyFile.exists()){
			try (FileInputStream fis = new FileInputStream(propiertyFile)){
				properties.load(fis);
				String  lastAccess = properties.getProperty("ultimoAcceso");
				String  lastDuration = properties.getProperty("duracion", "No disponible");
				System.out.println("Fecha/hora de inicio de la última ejecución: " + lastAccess);
				System.out.println("Duración de la última ejecución: " + lastDuration + " milisegundos");
			} catch (IOException e){
				e.printStackTrace();
			}
		} else {
			System.out.println("Es tu primera ejecución");
		}
		long    endTime = System.currentTimeMillis();
		long    duration = endTime - startTime;
		userPrefs.putLong("duracion", duration);
		properties.setProperty("ultimoAcceso", new Date().toString());
		try (FileOutputStream fos = new FileOutputStream(propiertyFile)){
			properties.store(fos, "Configuracion del programa");
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}
