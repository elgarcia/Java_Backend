package logic;

import entities.Ingreso;
import top.jfunc.json.impl.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class GestionIngresos {
	public static List<Ingreso> getContent(Path ruta){
		List<Ingreso>   ingresos = new ArrayList<>();

		try {
			List<String>    lines = Files.readAllLines(ruta);

			for (int i = 1; i < lines.size(); i++) {
				ingresos.add(Ingreso.toIngreso(lines.get(i)));
			}
		}   catch (IOException e){
			e.printStackTrace();
		}
		return (ingresos);
	}

	public static void saveContent(Path output, List<Ingreso> ingresos){
		String  content = new JSONObject().serialize(ingresos);
		try {
			Files.writeString(output, content);
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}
