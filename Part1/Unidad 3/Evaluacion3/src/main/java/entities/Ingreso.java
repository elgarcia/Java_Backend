package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingreso {
    private int id;
    private int     anho;
    private int     clasificacion;
    private String  empresa;
    private double  ingresos;

    public static Ingreso  toIngreso(String csv){
        String[] clientescsv = csv.split(",");

        return (new Ingreso(Integer.parseInt(clientescsv[0]),
                Integer.parseInt(clientescsv[1]),
                Integer.parseInt(clientescsv[2]),
                clientescsv[3],
                Double.parseDouble(clientescsv[4])));
    }
}
