package Ejercicio01;

public class Counter {
	public static String[]  trocear(String cadena)
	{
		return (cadena.trim().split("\\s+"));
	}

	public static int   contar(String[] split)
	{
		int wordCount = split.length;
		System.out.println("Number of words: " + wordCount);
		return (wordCount);
	}

	public static void  startUpper(String[] split){
		System.out.println("Starts with Uppercase: ");
		for(String a: split){
			if (!a.isEmpty() && Character.isUpperCase(a.charAt(0))){
				System.out.println(a);
			}
		}
	}

	public static String    toUpper(String file){
		return (file.toUpperCase());
	}

	public static int   countEs(String[] file){
		int i = 0;
		for (String a: file){
			if (!a.isEmpty() && a.startsWith("ES"))
				i++;
		}
		System.out.println("ES words: " + i);
		return (i);
	}

	public static String    removeEn(String file)
	{
		return (file.replaceAll("EN", ""));
	}
}
