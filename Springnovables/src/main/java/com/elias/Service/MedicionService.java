package com.elias.Service;

import com.elias.Domain.MedicionEntity;
import com.elias.DTO.MedicionDTO;
import com.elias.Domain.Radiacion;
import com.elias.Repository.MedicionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MedicionService {
    @Autowired
    private MedicionRepository  medicionRepo;

    @Autowired
    private RadiacionService    radiacionService;

    public List<MedicionDTO>    loadMediciones() throws IOException{
        List<MedicionEntity>  mediciones = medicionRepo.findAll();
        List<Radiacion> radiaciones = radiacionService.loadRadiacion();

        List<MedicionDTO>   medicionDTO = new ArrayList<>();

        for (MedicionEntity medicion : mediciones) {
            MedicionDTO dto = new MedicionDTO();
            dto.setPkMedicionID(medicion.getPk_MedicionID());
            dto.setLatitud(medicion.getLatitud());
            dto.setLongitud(medicion.getLongitud());
            dto.setAny(medicion.getAnho());
            dto.setTemperatura(medicion.getTemperatura());
            dto.setViento(medicion.getViento());
            dto.setPrecipitacion(medicion.getPrecipitacion());

            radiaciones.stream()
                    .filter(r -> r.getLatitud().equals(medicion.getLatitud())
                            && r.getLongitud().equals(medicion.getLongitud())
                            && r.getAny().equals(medicion.getAnho()))
                    .findFirst()
                    .ifPresent(r -> dto.setRadiacion(r.getRadiacion()));

            medicionDTO.add(dto);
        }
        return medicionDTO;
    }

    public MedicionEntity create(MedicionEntity medicion) {
        return medicionRepo.save(medicion);
    }

    public MedicionEntity update(Long id, MedicionEntity medicion) {
        medicion.setPk_MedicionID(id);
        return medicionRepo.save(medicion);
    }

    public void delete(Long id) {
        medicionRepo.deleteById(id);
    }

    public List<MedicionEntity> findAll() {
        return medicionRepo.findAll();
    }

    public List<MedicionEntity> findByAny(Short any) {
        return medicionRepo.findByAnho(any);
    }
}
