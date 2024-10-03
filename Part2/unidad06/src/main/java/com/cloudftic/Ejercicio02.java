package com.cloudftic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import lombok.Data;

/*
Un programa debe almacenar datos de venta (código/nombre producto/precio/fecha de venta) en forma de strings.
Crea la clase GestionVentas para gestionar las ventas con un fichero dado.
Utiliza objetos Reader y Writer para realizar las operaciones con el fichero.
 */
public class Ejercicio02 {

   public static void main(String[] args) throws URISyntaxException {
      URL url = Ejercicio02.class.getResource("../../ventas.txt");
      Path path = Path.of(url.toURI());
      var gv = new GestionVentas(path);
      // gv.agregar(1, "v1", 10, LocalDate.of(2022, 4, 12));
      // gv.agregar(2, "v2", 20, LocalDate.of(2022, 6, 10));
      // gv.agregar(3, "v3", 30, LocalDate.of(2022, 5, 15));
      System.out.println(gv.encontrar(2));
   }
}

@Data
class GestionVentas {

   // SE GUARDAN LAS VENTAS POR LINEAS

   private final Path ficheroVentas;

   record Venta(int codigo, String nombre, double precio, LocalDate fecha) {
   }

   private String toVentaString(int codigo, String nombre, double precio, LocalDate fecha) {
      return String.format(Locale.US, "%d;%s;%.2f;%s", codigo, nombre, precio, fecha);
   }

   private Venta fromVentaString(String venta) {
      String[] datos = venta.split(";");
      return new Venta(Integer.parseInt(datos[0]), datos[1], Double.parseDouble(datos[2]), LocalDate.parse(datos[3]));
   }

   // Debe agregar los datos de una venta al final del fichero.
   public void agregar(int codigo, String nombre, double precio, LocalDate fecha) {
      // Se abre el fichero para modo APPEND
      try (var writer = new FileWriter(ficheroVentas.toFile(), true);
            var buffered = new BufferedWriter(writer)) {
         buffered.write(toVentaString(codigo, nombre, precio, fecha));
         buffered.newLine();
      } catch (Exception e) {
         throw new RuntimeException(e);
      }
   }

   // Debe recuperar los datos de una venta por su código
   public String encontrar(int codigo) {
      try (var reader = new FileReader(ficheroVentas.toFile());
            var buffered = new BufferedReader(reader)) {
         String venta;
         while ((venta = buffered.readLine()) != null) {
            if (!venta.isEmpty() && fromVentaString(venta).codigo() == codigo) {
               return venta;
            }
         }
      } catch (Exception e) {
         throw new RuntimeException(e);
      }
      return null;
   }

   // Debe recuperar todas las ventas de un año dado
   public List<String> encontrarPara(int year) {
      List<String> ventas = new ArrayList<>();
      try (var reader = new FileReader(ficheroVentas.toFile());
            var buffered = new BufferedReader(reader)) {
         String venta;
         while ((venta = buffered.readLine()) != null) {
            if (!venta.isEmpty() && fromVentaString(venta).fecha().getYear() == year) {
               ventas.add(venta);
            }
         }
      } catch (

      Exception e) {
         throw new RuntimeException(e);
      }
      return ventas;
   }
}