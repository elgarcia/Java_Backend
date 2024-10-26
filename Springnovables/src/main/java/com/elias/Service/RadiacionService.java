package com.elias.Service;

import com.elias.Domain.Radiacion;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class RadiacionService {
    public List<Radiacion> loadRadiacion() throws IOException{
        ObjectMapper    oMapper = new ObjectMapper();

        File file = new File("../../../resources/file.json");
        return (Arrays.asList(oMapper.readValue(file, Radiacion[].class)));
    }
}
