package access;

import entities.Ingreso;
import logic.GestionIngresos;
import top.jfunc.json.impl.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioIngresos implements IRepositorioIngresos {
    private Path            ruta;
    private Path            output;
    private List<Ingreso>   ingresos;
    private String          url = "jdbc:h2:./EMPRESASBD";
    final private String    user = "sa";
    final private String    password = "";

    public List<Ingreso> getIngresos() {
        return (this.ingresos);
    }

    public RepositorioIngresos(Path ruta){
        String  newPath;
        String  path;
        int     dot;

        this.ruta = ruta;
        path = ruta.getFileName().toString();
        dot = path.lastIndexOf('.');
        newPath = path.substring(0, dot) + ".json";
        this.output = Paths.get(newPath);
        if (this.ingresos == null){
            this.ingresos = new ArrayList<>();
        }
        this.ingresos = GestionIngresos.getContent(this.ruta);
        GestionIngresos.saveContent(this.output, this.ingresos);
    }

    private Connection  getConnection() throws SQLException {
        return (DriverManager.getConnection(this.url, this.user, this.password));
    }

    @Override
    public void add(Ingreso ingreso) {
        String sql = "INSERT INTO Ingreso(anho, clasificacion, empresa, ingresos)" +
                "VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection()){
            try (PreparedStatement preState = conn.prepareStatement(sql)){
                preState.setInt(1, ingreso.getAnho());
                preState.setInt(2, ingreso.getClasificacion());
                preState.setString(3, ingreso.getEmpresa());
                preState.setDouble(4, ingreso.getIngresos());
                preState.execute();
            }   catch (SQLException e){
                e.printStackTrace();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void addTable(){
        String  sql = "CREATE TABLE IF NOT EXISTS Ingreso (\n" +
                "    id IDENTITY NOT NULL PRIMARY KEY,\n" +
                "    anho INTEGER NOT NULL,\n" +
                "    clasificacion INTEGER NOT NULL,\n" +
                "    empresa VARCHAR NOT NULL,\n" +
                "    ingresos DECIMAL NOT NULL\n" +
                ");";

        try (Connection conn = getConnection()){
            try (Statement state = conn.createStatement()){
                state.execute(sql);
            }   catch (SQLException e){
                e.printStackTrace();
            }
        }   catch (SQLException e){
            e.printStackTrace();
        }
    }
}
