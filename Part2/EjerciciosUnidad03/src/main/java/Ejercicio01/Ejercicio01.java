package Ejercicio01;

import com.elias.main;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio01 {
	public static void main( String[] args )
	{
		String      fileContent;
		String[]    fileSplitted;
		int         wordCount;
		int         esWords = 0;
		String      enFile;

		fileContent = leer("articulo.txt");
		fileSplitted = Counter.trocear(fileContent);
		wordCount = Counter.contar(fileSplitted);
		Counter.startUpper(fileSplitted);
		fileContent = Counter.toUpper(fileContent);
		esWords = Counter.countEs(fileContent.split("\\s+"));
		fileContent = Counter.removeEn(fileContent);
		System.out.println("EN delete word \n" + fileContent);
		wordCount = Counter.contar(fileContent.trim().split("\\s+"));

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
