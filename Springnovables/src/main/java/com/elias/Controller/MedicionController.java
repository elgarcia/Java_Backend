package com.elias.Controller;

import com.elias.DTO.MedicionDTO;
import com.elias.Domain.MedicionEntity;
import com.elias.Domain.Radiacion;
import com.elias.Service.MedicionService;
import com.elias.Service.RadiacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/mediciones")
public class MedicionController {
    @Autowired
    private MedicionService     medicionService;

    @Autowired
    private RadiacionService    radiacionService;

    private MedicionDTO convertToDto(MedicionEntity medicion) {
        return (new MedicionDTO(medicion));
    }

    private MedicionEntity convertToEntity(MedicionDTO dto) {
        return (new MedicionEntity(dto));
    }

    private Radiacion   dtoToRadiacion(MedicionDTO dto){
        return (new Radiacion(dto));
    }
    //Crear Medicion
    @PostMapping
    public ResponseEntity<MedicionDTO>   createMedicion(@RequestBody MedicionDTO medicion) throws IOException {
        MedicionEntity  medicionEntity = convertToEntity(medicion);
        medicionService.create(medicionEntity);
        MedicionDTO     medicionDTO = convertToDto(medicionEntity);
        System.out.println(medicionDTO);
        radiacionService.saveRadiacion(dtoToRadiacion(medicionDTO));
        return (ResponseEntity.ok(medicionDTO));
    }

    //Update Medicion
    @PutMapping("/{id}")
    public ResponseEntity<MedicionDTO>   updateMedicion(@PathVariable("id") Long id, @RequestBody MedicionDTO medicion) throws IOException {
        MedicionEntity medicionEntity = convertToEntity(medicion);
        medicionService.update(id, medicionEntity);
        MedicionDTO     medicionDTO = convertToDto(medicionEntity);
        radiacionService.update(id, dtoToRadiacion(medicionDTO));
        return (ResponseEntity.ok(medicionDTO));
    }

    //Delete Medicion
    @DeleteMapping("/{id}")
    public ResponseEntity<MedicionDTO>   deleteMedicion(@PathVariable("id") Long id) throws IOException {
        medicionService.delete(id);
        radiacionService.delete(id);
        return (ResponseEntity.noContent().build());
    }

    //Ver Todas
    @GetMapping
    public ResponseEntity<List<MedicionDTO>> getAllMediciones() throws IOException {
        return (ResponseEntity.ok(medicionService.loadMediciones()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicionDTO>  getMedicionById(@PathVariable("id") Long id) throws IOException {
        return (ResponseEntity.ok(medicionService.getMedicionById(id)));
    }

    @GetMapping("/filter/{any}")
    public ResponseEntity<List<MedicionDTO>> filterByAny(@PathVariable("id") Short any) throws IOException {
        List<MedicionDTO>   filterDto = medicionService.loadMediciones().stream()
                .filter(medicion -> medicion.getAnho().equals(any))
                .toList();

        return (ResponseEntity.ok(filterDto));
    }
}
