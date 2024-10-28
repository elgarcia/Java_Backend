package com.elias.Service;

import com.elias.Domain.Radiacion;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Service
public class RadiacionService {

    private static final String FILE_NAME = "src/main/resources/static/file.json";

    public void saveRadiacion(Radiacion radiacion) throws IOException{
        ObjectMapper oMapper = new ObjectMapper();
        File file = new File(FILE_NAME);
        if (!file.exists()){
            throw new FileNotFoundException();
        }
        List<Radiacion> radiaciones = loadRadiacion();
        radiaciones.add(radiacion);
        oMapper.writeValue(file, radiaciones);
    }

    public List<Radiacion> loadRadiacion() throws IOException{
        ObjectMapper    oMapper = new ObjectMapper();
        List<Radiacion> radiacions = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (file.exists()){
            try (BufferedReader reader = Files.newBufferedReader(file.toPath())){
                String  line;
                while((line = reader.readLine()) != null){
                    try{
                        Radiacion   radiacion = oMapper.readValue(line, Radiacion.class);
                        radiacions.add(radiacion);
                    } catch (JsonMappingException | JsonParseException e) {
                        radiacions = oMapper.readValue(file, new TypeReference<List<Radiacion>>() {});
                    }
                }
            }
        }
        return (radiacions);
    }

    public void update(Long id, Radiacion newRadiacion) throws IOException {
        List<Radiacion> radiaciones = loadRadiacion();

        radiaciones.replaceAll(radiacion -> radiacion.getId().equals(id) ? newRadiacion: radiacion);

        ObjectMapper oMapper = new ObjectMapper();
        File file = new File(FILE_NAME);
        oMapper.writeValue(file, radiaciones);
    }

    public void delete(Long id) throws IOException {
        List<Radiacion> radiaciones = loadRadiacion();

        radiaciones.removeIf(radiacion -> radiacion.getId().equals(id));

        ObjectMapper oMapper = new ObjectMapper();
        File file = new File(FILE_NAME);
        if (radiaciones.isEmpty()){
            try (FileWriter filew = new FileWriter(file,false)){
                filew.write("");
            }
        }
        else {
            oMapper.writeValue(file, radiaciones);
        }
    }
}
