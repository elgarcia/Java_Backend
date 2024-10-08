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
		String          content;
		String          stopwords;
		String          positive;
		String          negative;
		double          puntuacion;
		List<String>    siglas;
		List<String>    puntaciones;

		content = leer("articulo.txt");
		stopwords = leer("stopwords.txt");
		positive = leer("positive_lex.txt");
		negative = leer("negative_lex.txt");
		Operations.word_counter(content);
		siglas = Operations.siglas(content);
		puntaciones = Operations.punts(content);
		content = Operations.toUpper(content);
		content = Operations.eraseAccents(content);
		content = Operations.eraseNumbers(content);
		content = Operations.eraseWords(content, stopwords);
		puntuacion = Operations.score(content, positive, negative);
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
