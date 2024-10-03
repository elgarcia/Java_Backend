package com.cloudftic;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
Se quiere gestionar el registro de accesos a nuestro sitio web creando clases que implementen la 
siguiente interfaz:

public interface GestionAccesos {
    // Debe retornar la ruta del fichero usado para almacenar los accesos.
    Path getFichero();
    // Debe insertar un acceso al final del fichero.
    void insertarAcceso(String usuario, LocalDateTime acceso) throws IOException;
    // Debe obtener los nombres de usuario que accedieron en una día concreto
    List<String> consultarUsuarios(LocalDate dia) throws IOException;
}

1) Crea una clase GestionAccesosCSV que utilice fichero CSV para almacenar los datos de acceso. En 
   cada línea del fichero se debe insertar el nombre de usuario, la fecha y hora de acceso, separados 
   por comas. Algo como:  Juan,2022-03-12,08:12:45
2) Crea una clase GestonAccesosXML que utilice un fichero en formato XML para almacenar los datos de 
   acceso. 
3) Crea una clase GestonAccesosJson que utilice un fichero en formato Json para almacenar los datos 
   de acceso. 
4) Crea una clase GestonAccesosBinary que utilice un fichero binario para almacenar los datos de 
   acceso. (Usa serialización binaria con ObjectOutputStream y ObjectInputStream). 
 */

public class Ejercicio03 {

    public static void main(String[] args) throws URISyntaxException, Exception {
        var ruta = Path.of(Ejercicio03.class.getResource("../../accesos.csv").toURI());
        testar(ruta, GestionAccesosCSV.class);

        ruta = Path.of(Ejercicio03.class.getResource("../../accesos.xml").toURI());
        testar(ruta, GestionAccesosXml.class);

        ruta = Path.of(Ejercicio03.class.getResource("../../accesos.json").toURI());
        testar(ruta, GestionAccesosJson.class);

        ruta = Path.of(Ejercicio03.class.getResource("../../accesos.ser").toURI());
        testar(ruta, GestionAccesosBinary.class);
    }

    private static void testar(Path ruta, Class<? extends GestionAccesos> clase) throws Exception {
        Files.writeString(ruta, "", StandardOpenOption.TRUNCATE_EXISTING); // lo vacia
        var gestor = (GestionAccesos) clase.getConstructor(Path.class).newInstance(ruta);
        gestor.insertarAcceso("juan", LocalDateTime.of(2022, 10, 12, 14, 12, 0));
        gestor.insertarAcceso("ana", LocalDateTime.of(2022, 10, 12, 14, 10, 0));
        System.out.println(gestor.consultarUsuarios(LocalDate.of(2022, 10, 12)));
    }
}

interface GestionAccesos {
    // Debe retornar la ruta del fichero usado para almacenar los accesos.
    Path getFichero();

    // Debe insertar un acceso al final del fichero.
    void insertarAcceso(String usuario, LocalDateTime acceso) throws IOException;

    // Debe obtener los nombres de usuario que accedieron en una día concreto
    List<String> consultarUsuarios(LocalDate dia) throws IOException;
}

@Data
class GestionAccesosCSV implements GestionAccesos {
    private final String[] headers = { "usuario", "fecha", "hora" };
    private final Path fichero;
    private CSVFormat csvFormat = CSVFormat.EXCEL.builder()
            .setHeader(headers)
            .setSkipHeaderRecord(true)
            .setIgnoreEmptyLines(true)
            .build();

    public GestionAccesosCSV(Path fichero) {
        this.fichero = fichero;
        // Si el fichero esta vacio se añaden las cabeceras
        try {
            if (Files.isRegularFile(fichero) && Files.size(fichero) == 0) {
                try (var printer = new CSVPrinter(
                        Files.newBufferedWriter(fichero, StandardOpenOption.APPEND),
                        csvFormat)) {
                    printer.printRecord(Stream.of(headers).map(o -> (Object) o).toArray());
                }
            }
        } catch (IOException e) {
        }
    }

    @Override
    public void insertarAcceso(String usuario, LocalDateTime acceso) throws IOException {
        try (var printer = new CSVPrinter(
                Files.newBufferedWriter(fichero, StandardOpenOption.CREATE, StandardOpenOption.APPEND),
                csvFormat)) {
            printer.printRecord(usuario, acceso.toLocalDate().toString(), acceso.toLocalTime().toString());
        }
    }

    @Override
    public List<String> consultarUsuarios(LocalDate dia) throws IOException {
        try (CSVParser parser = CSVParser.parse(Files.newBufferedReader(fichero), csvFormat)) {
            return parser.stream()
                    .map(record -> record.get("usuario"))
                    .toList();
        }

    }

}

@Data
class GestionAccesosXml implements GestionAccesos {
    /*
     * El formato XML no permite añadir parcialmente. Debemos leer el contenido
     * actual, modificarlo, y volverlo a escribir.
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Acceso {
        private String usuario;
        private String fecha;
        private String hora;
    }

    private final Path fichero;

    public GestionAccesosXml(Path fichero) {
        this.fichero = fichero;
        try {
            if (Files.isRegularFile(fichero) && Files.size(fichero) == 0) {
                try (XMLEncoder encoder = new XMLEncoder(Files.newOutputStream(fichero))) {
                    encoder.writeObject(new ArrayList<Acceso>());
                }
            }
        } catch (IOException e) {
        }
    }

    @Override
    public void insertarAcceso(String usuario, LocalDateTime acceso) throws IOException {
        try (XMLDecoder decoder = new XMLDecoder(Files.newInputStream(fichero))) {
            Object resultado = decoder.readObject();
            List<Acceso> accesos = resultado == null ? new ArrayList<>() : (List<Acceso>) resultado;
            accesos.add(new Acceso(usuario, acceso.toLocalDate().toString(), acceso.toLocalTime().toString()));
            try (XMLEncoder encoder = new XMLEncoder(Files.newOutputStream(fichero))) {
                encoder.writeObject(accesos);
            }
        }
    }

    @Override
    public List<String> consultarUsuarios(LocalDate dia) throws IOException {
        try (XMLDecoder decoder = new XMLDecoder(Files.newInputStream(fichero))) {
            List<Acceso> accesos = (List<Acceso>) decoder.readObject();
            return accesos.stream()
                    .filter(acc -> acc.getFecha().equals(dia.toString()))
                    .map(Acceso::getUsuario)
                    .toList();
        }
    }

}

@Data
class GestionAccesosJson implements GestionAccesos {
    /*
     * El formato JSON no permite añadir parcialmente. Debemos leer el contenido
     * actual, modificarlo, y volverlo a escribir.
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Acceso {
        private String usuario;
        private String fecha;
        private String hora;
    }

    private final Path fichero;
    private final ObjectMapper mapper = new ObjectMapper();

    public GestionAccesosJson(Path fichero) {
        this.fichero = fichero;
        try {
            if (Files.isRegularFile(fichero) && Files.size(fichero) == 0) {
                mapper.writeValue(fichero.toFile(), new ArrayList<Acceso>());
            }
        } catch (IOException e) {
        }
    }

    @Override
    public void insertarAcceso(String usuario, LocalDateTime acceso) throws IOException {
        List<Acceso> accesos = mapper.readValue(fichero.toFile(), new TypeReference<List<Acceso>>() {
        });
        accesos.add(new Acceso(usuario, acceso.toLocalDate().toString(), acceso.toLocalTime().toString()));
        mapper.writeValue(fichero.toFile(), accesos);
    }

    @Override
    public List<String> consultarUsuarios(LocalDate dia) throws IOException {
        List<Acceso> accesos = mapper.readValue(fichero.toFile(), new TypeReference<List<Acceso>>() {
        });
        return accesos.stream()
                .filter(acc -> acc.getFecha().equals(dia.toString()))
                .map(Acceso::getUsuario)
                .toList();
    }

}

@Data
class GestionAccesosBinary implements GestionAccesos {
    /*
     * Con serializacion binaria podemos serializar accesos al final del fichero,
     * pero hay que eliminar las cabeceras que mete ObjectOutputStream y lee
     * ObjectInputStream.
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Acceso implements Serializable {
        private String usuario;
        private String fecha;
        private String hora;
    }

    public static class MyObjectOutputStream extends ObjectOutputStream {

        public MyObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        protected void writeStreamHeader() throws IOException {
        }

    }

    public static class MyObjectInputStream extends ObjectInputStream {

        public MyObjectInputStream(InputStream in) throws IOException {
            super(in);
        }

        @Override
        protected void readStreamHeader() throws IOException, StreamCorruptedException {
        }
    }

    private final Path fichero;
    private final ObjectMapper mapper = new ObjectMapper();

    public GestionAccesosBinary(Path fichero) {
        this.fichero = fichero;
    }

    @Override
    public void insertarAcceso(String usuario, LocalDateTime acceso) throws IOException {
        try (ObjectOutputStream out = new MyObjectOutputStream(
                Files.newOutputStream(fichero, StandardOpenOption.APPEND))) {
            out.writeObject(new Acceso(usuario, acceso.toLocalDate().toString(), acceso.toLocalTime().toString()));
        }
    }

    @Override
    public List<String> consultarUsuarios(LocalDate dia) throws IOException {
        List<String> usuarios = new ArrayList<>();
        try (ObjectInputStream out = new MyObjectInputStream(Files.newInputStream(fichero))) {
            while (true) {
                try {
                    Acceso acceso = (Acceso) out.readObject();
                    if (acceso.getFecha().equals(dia.toString())) {
                        usuarios.add(acceso.getUsuario());
                    }
                } catch (EOFException | ClassNotFoundException e) {
                    break;
                }
            }
        }
        return usuarios;
    }
}