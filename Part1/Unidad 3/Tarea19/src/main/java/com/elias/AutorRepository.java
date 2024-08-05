package com.elias;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutorRepository implements IAutorRepository{
    final String  url = "jdbc:h2:C:/Users/DBZEL/Desktop/Uni_ciclo/FSCurso/DB/biblioteca";
    final String  user = "sa";
    final String  password = "";

    private Connection getConnection() throws SQLException {
        return (DriverManager.getConnection(this.url, this.user, this.password));
    }

    @Override
    public void insert(Autor autor) {
        final String sql = "INSERT INTO Autor(codigo, nombre, fecha)" +
                "VALUES(?,?,?)";
        try (Connection con = getConnection()){
            try (PreparedStatement command = con.prepareStatement(sql)){
                command.setInt(1, autor.getCodigo());
                command.setString(2, autor.getName());
                java.util.Date fecha = autor.getFecha();
                command.setDate(3, fecha == null ? null : new java.sql.Date(fecha.getTime()));
                command.execute();
            }
        } catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void delete(Autor autor) {
        final String sql = "DELETE FROM Autor" +
                "WHERE codigo = ?";
        try (Connection con = getConnection()){
            try (PreparedStatement command = con.prepareStatement(sql)){
                command.setInt(1, autor.getCodigo());
                command.execute();
            }
        } catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void update(Autor autor) {
        final String sql = "UPDATE Autor SET nombre = ?," +
                "fecha = ? WHERE codigo = ?";
        try (Connection con = getConnection()){
            try (PreparedStatement command = con.prepareStatement(sql)){
                command.setString(1, autor.getName());
                java.util.Date fecha = autor.getFecha();
                command.setDate(2, fecha == null ? null : new java.sql.Date(fecha.getTime()));
                command.setInt(3, autor.getCodigo());
                command.execute();
            }
        } catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Autor> autorBy(int anho) {
        List<Autor> autores = new ArrayList<>();

        final String sql = "SELECT codigo, nombre, fecha" +
                "FROM Autor WHERE year(fecha) >= ?";
        try (Connection con = getConnection()){
            try (PreparedStatement command = con.prepareStatement(sql)){
                command.setInt(1, anho);
                try (ResultSet resultado = command.executeQuery()){
                    while (resultado.next()){
                        int codigo = resultado.getInt("codigo");
                        String nombre = resultado.getString("nombre");
                        java.sql.Date fecha = resultado.getDate("fecha");
                        Autor autor = new Autor(codigo, nombre, fecha);
                        autores.add(autor);
                    }
                }
            }
        } catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return (autores);
    }
}

interface IAutorRepository{
    void insert(Autor autor);
    void delete(Autor autor);
    void update(Autor autor);

    List<Autor> autorBy(int anho);
}
