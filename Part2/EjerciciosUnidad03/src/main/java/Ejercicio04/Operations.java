package Ejercicio04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Operations {
	public static void  word_counter(String content){
		String[]    contentSplitted;
		int         words;

		contentSplitted = content.trim().split("\\s+");
		words = contentSplitted.length;
		System.out.println(words);
	}

	public static List<String> siglas(String content){
		List<String>    sig = new ArrayList<>();
		int             aux = 0;

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
				sig.add(a);
			}
			aux = 0;
		}
		System.out.println(sig.toString());
		return (sig);
	}

	public static List<String> punts(String content){
		List<String>    puntuaciones = new ArrayList<>();

		for (String a: content.trim().
				split("\\s+")){
			if (a.contains(".") ||
					a.contains(",") ||
					a.contains(";") ||
					a.contains(":") ||
					a.contains("¡") ||
					a.contains("!") ||
					a.contains("¿") ||
					a.contains("?") ||
					a.contains("...")){
				puntuaciones.add(a.replaceAll("\\w", ""));
			}
		}
		System.out.println(puntuaciones.toString());
		return (puntuaciones);
	}

	public static String    toUpper(String content){
		System.out.println(content.toUpperCase());
		return (content.toUpperCase());
	}

	public static String    eraseAccents(String content){
		String  nContent;

		nContent = content.
				replaceAll("Á", "A").
				replaceAll("É", "E").
				replaceAll("Í", "I").
				replaceAll("Ó", "O").
				replaceAll("Ú", "U");
		System.out.println(nContent);
		return (nContent);
	}

	public static String    eraseNumbers(String content){
		String  nContent;

		nContent = content.replaceAll("\\d", "");
		System.out.println(nContent.trim());
		return (nContent.trim());
	}

	public static String    eraseWords(String content, String stopwords){
		String      nContent = content;
		String[]    words;

		words = stopwords.split("\n");
		for (String a: words){
			nContent = nContent.replaceAll("\\b" + a.toUpperCase() + "\\b", "").trim();
		}
		System.out.println(nContent);
		return (nContent);
	}

	public static double   score(String content, String positive, String negative){
		Map<String, String> pcontent = new HashMap<>();
		Map<String, String> ncontent = new HashMap<>();
		double              fScore = 0;

		for(String a: positive.split("\n")){
			String[]    parts = a.split(" ");
			if (parts.length == 2){
				pcontent.put(parts[0].toUpperCase(), parts[1]);
			}
		}
		for(String a: negative.split("\n")){
			String[]    parts = a.split(" ");
			if (parts.length == 2){
				ncontent.put(parts[0].toUpperCase(), parts[1]);
			}
		}
		for (String a: content.split(" ")){
			if (pcontent.containsKey(a)){
				fScore += Double.parseDouble(pcontent.get(a));
			}
			else if (ncontent.containsKey(a)){
				fScore += Double.parseDouble(ncontent.get(a));
			}
		}
		System.out.println("Score = " + fScore);
		return (fScore);
	}
}
