package com.elias.Controller;

import com.elias.Domain.MedicionEntity;
import com.elias.Service.MedicionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mediciones")
public class MedicionController {
    @Autowired
    private MedicionService medicionService;

    //Crear Medicion
    @PostMapping
    public ResponseEntity<MedicionEntity>   createMedicion(@RequestBody MedicionEntity medicion){
        return (ResponseEntity.ok(medicionService.create(medicion)));
    }

    //Update Medicion
    @PutMapping("/{id}")
    public ResponseEntity<MedicionEntity>   updateMedicion(@PathVariable Long id, @RequestBody MedicionEntity medicion) {
        return (ResponseEntity.ok(medicionService.update(id, medicion)));
    }

    //Delete Medicion
    @DeleteMapping("/{id}")
    public ResponseEntity<MedicionEntity>   deleteMedicion(@PathVariable Long id) {
        medicionService.delete(id);
        return (ResponseEntity.noContent().build());
    }

    //Ver Todas
    @GetMapping
    public ResponseEntity<List<MedicionEntity>> getAllMediciones() {
        return (ResponseEntity.ok(medicionService.findAll()));
    }

    @GetMapping("/filter/{any}")
    public ResponseEntity<List<MedicionEntity>> filterByAny(@PathVariable Short any){
        return (ResponseEntity.ok(medicionService.findByAny(any)));
    }
}
