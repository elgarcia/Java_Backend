package Ejercicio04;

import com.elias.main;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Ejercicio04 {
	public static void main(String[] args) {
		String  content;
		String[]  contentSplitted;
		int     words;
		List<String>    siglas = new ArrayList<>();
		List<String>    puntaciones = new ArrayList<>();
		int             aux = 0;

		content = leer("articulo.txt");
		contentSplitted = content.trim().split("\\s+");
		words = contentSplitted.length;
		System.out.println(words);
		for (String a: content.trim().
				replaceAll(",", "").
				replaceAll("\\(", "").
				replaceAll("\\)", "").
				split("\\s+")){
			for (Character b: a.toCharArray()){
				if (!Character.isUpperCase(b)) {
					aux = 1;
					break;
				}
			}
			if (aux == 0){
				siglas.add(a);
			}
			aux = 0;
		}
		System.out.println(siglas.toString());
	}

	public static String leer(String rutaFichero) {
		try {
			URL ruta =  main.class.getClassLoader().getResource(rutaFichero);
			return Files.readString(Path.of(ruta.toURI()));
		} catch (Exception e) {
			return "No se pudo leer: " + e;
		}
	}
}
