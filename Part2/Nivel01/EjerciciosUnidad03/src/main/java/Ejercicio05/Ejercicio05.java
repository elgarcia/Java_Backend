package Ejercicio05;

import com.elias.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class Ejercicio05 {
	public static String[] formatosNumero(double numero, int redondeo, Locale... idiomas ){
		String[]        res = new String[idiomas.length];
		for (int i = 0; i < idiomas.length; i++){
			StringBuilder   number = new StringBuilder();
			Formatter       formatter = new Formatter(number, idiomas[i]);
			formatter.format("%,." + redondeo + "f", numero);
			res[i] = number.toString();
			formatter.close();
		}
		return (res);
	}

	public static String[] separaInfoPersonaST( String info ){
		StringTokenizer stringTokenizer = new StringTokenizer(info, "-/;");
		String[]        res = new String[stringTokenizer.countTokens()];
		int             i = 0;

		while(stringTokenizer.hasMoreTokens()){
			res[i++] = stringTokenizer.nextToken().trim();
		}
		return (res);
	}
	public static String[] separaInfoPersonaSS( String info ){
		String[]    res = info.split("[-/;]+");
		for (int i = 0; i < res.length; i++){
			res[i] = res[i].trim();
		}
		return (res);
	}
	public static String[] separaInfoPersonaP( String info ){
		Pattern     pattern = Pattern.compile("[-/;]+");
		String []   res = pattern.split(info);

		for (int i = 0; i < res.length; i++){
			res[i] = res[i].trim();
		}
		return (res);
	}

	enum FormatoValido {
		Corto ("yyyy/MMMM/dd"),
		Largo ("yyyy/MM/dd HH:mm:ss"),
		Medio ("yyyy/MM/dd/HH");

		private final String value;

		FormatoValido(String s) {
			value = s;
		}

		public String getValue() {return value;}
	}

	public static java.util.Date convierteFecha(String fecha, FormatoValido formato) throws RuntimeException{
		SimpleDateFormat    sdformat = new SimpleDateFormat(formato.getValue());
		Date                date = null;
		try {
			date = sdformat.parse(fecha);
		} catch (ParseException e){
			System.out.println(e.getMessage());
		}
		return (date);
	}

	public static void main(String[] args) {
		Locale[] loc = new Locale[] {Locale.ENGLISH, Locale.GERMAN};
		String[] values = formatosNumero(1451212.12123, 4, loc);
		System.out.println(Arrays.toString(values));

		System.out.println(Arrays.toString(separaInfoPersonaST("Juan  ; 23 años - teléfono 123456789  / Nacido en España")));
		System.out.println(Arrays.toString(separaInfoPersonaSS("Juan  ; 23 años - teléfono 123456789  / Nacido en España")));
		System.out.println(Arrays.toString(separaInfoPersonaP("Juan  ; 23 años - teléfono 123456789  / Nacido en España")));

		try {
			Date date = convierteFecha("2013/Noviembre/24", FormatoValido.Corto);
			Date date2 = convierteFecha("2013/11/24 7:34:12", FormatoValido.Largo);
			Date date3 = convierteFecha("2013/11/24/11", FormatoValido.Medio);
			System.out.println(date);
			System.out.println(date2);
			System.out.println(date3);
		} catch (RuntimeException e){
			System.out.println(e.getMessage());
		}
	}
}
