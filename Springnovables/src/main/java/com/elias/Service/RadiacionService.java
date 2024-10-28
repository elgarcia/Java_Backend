package com.elias.Service;

import com.elias.Domain.Radiacion;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Service
public class RadiacionService {

    private static final String FILE_NAME = "file.json";

    public void saveRadiacion(Radiacion radiacion) throws IOException{
        ObjectMapper oMapper = new ObjectMapper();
        URL resource = getClass().getClassLoader().getResource(FILE_NAME);
        if (resource == null){
            throw new FileNotFoundException("File not found: " + FILE_NAME);
        }
        File file = new File(resource.getPath());

        try(FileWriter fileWriter = new FileWriter(file, true)){
            String  jsonString = oMapper.writeValueAsString(radiacion);
            System.out.println(jsonString);
            fileWriter.write(jsonString + "\n");
        }
    }

    public List<Radiacion> loadRadiacion() throws IOException{
        ObjectMapper    oMapper = new ObjectMapper();
        List<Radiacion> radiacions = new ArrayList<>();
        URL resource = getClass().getClassLoader().getResource(FILE_NAME);
        if (resource == null){
            throw new FileNotFoundException("File not found: " + FILE_NAME);
        }
        File file = new File(resource.getPath());

        if (file.exists()){
            try (BufferedReader reader = Files.newBufferedReader(file.toPath())){
                String  line;
                while((line = reader.readLine()) != null){
                    Radiacion   radiacion = oMapper.readValue(line, Radiacion.class);
                    radiacions.add(radiacion);
                }
            }
        }
        return (radiacions);
    }

    public void update(Long id, Radiacion newRadiacion) throws IOException {
        List<Radiacion> radiaciones = loadRadiacion();

        radiaciones.replaceAll(radiacion -> radiacion.getId().equals(id) ? newRadiacion: radiacion);

        ObjectMapper oMapper = new ObjectMapper();
        URL resource = getClass().getClassLoader().getResource(FILE_NAME);
        if (resource == null){
            throw new FileNotFoundException("File not found: " + FILE_NAME);
        }
        File file = new File(resource.getPath());
        oMapper.writeValue(file, radiaciones);
    }

    public void delete(Long id) throws IOException {
        List<Radiacion> radiaciones = loadRadiacion();

        radiaciones.removeIf(radiacion -> radiacion.getId().equals(id));

        ObjectMapper oMapper = new ObjectMapper();
        URL resource = getClass().getClassLoader().getResource(FILE_NAME);
        if (resource == null){
            throw new FileNotFoundException("File not found: " + FILE_NAME);
        }
        File file = new File(resource.getPath());
        oMapper.writeValue(file, radiaciones);
    }
}
