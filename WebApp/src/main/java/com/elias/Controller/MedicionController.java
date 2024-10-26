package com.elias.Controller;

import com.elias.DTO.MedicionDTO;
import com.elias.Service.MedicionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/mediciones")
public class MedicionController {
    @Autowired
    private MedicionService medicionService;

    @GetMapping
    public String   getMediciones(Model model){
        model.addAttribute("mediciones", medicionService.getAllMediciones());
        return ("/api/mediciones/lista");
    }

    @GetMapping("/form")
    public String   medicionForm(Model model){
        model.addAttribute("medicion", new MedicionDTO());
        return ("/api/mediciones/form");
    }

    @PostMapping
    public String   createMedicion(@ModelAttribute MedicionDTO medicion){
        medicionService.createMedicion(medicion);
        return ("redirect:/api/mediciones");
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        MedicionDTO medicion = medicionService.getMedicionById(id);
        if (medicion == null){
            return ("redirect:/api/mediciones");
        }
        model.addAttribute("medicion", medicion);
        return "/api/mediciones/form";
    }

    @PostMapping("/editar/{id}")
    public String   updateMedicion(@PathVariable Long id, @ModelAttribute MedicionDTO medicion){
        medicionService.updateMedicion(id, medicion);
        return ("redirect:/api/mediciones");
    }

    @GetMapping("/eliminar/{id}")
    public String   deleteMedicion(@PathVariable Long id){
        medicionService.deleteMedicion(id);
        return ("redirect:/api/mediciones");
    }
}
