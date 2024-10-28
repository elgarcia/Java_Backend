package com.elias.Controller;

import com.elias.DTO.MedicionDTO;
import com.elias.Service.MedicionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/mediciones")
public class MedicionController {
    @Autowired
    private MedicionService medicionService;

    @GetMapping
    public String   getMediciones(@RequestParam(value = "year", required = false) Short anho, Model model){
        List<MedicionDTO>   filteredMediciones = (anho != null) ? medicionService.filterByAny(anho) : medicionService.getAllMediciones();
        model.addAttribute("mediciones", filteredMediciones);
        model.addAttribute("selectedYear", anho);
        model.addAttribute("availableYears", medicionService.getAvailableYears());
        return ("/mediciones/lista");
    }

    @GetMapping("/form")
    public String   medicionForm(Model model){
        model.addAttribute("medicion", new MedicionDTO());
        return ("/mediciones/form");
    }

    @PostMapping
    public String   createMedicion(@ModelAttribute MedicionDTO medicion){
        medicionService.createMedicion(medicion);
        return ("redirect:/mediciones");
    }

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        MedicionDTO medicion = medicionService.getMedicionById(id);
        if (medicion == null){
            return ("redirect:/mediciones");
        }
        model.addAttribute("medicion", medicion);
        return "/mediciones/form";
    }

    @PostMapping("/editar/{id}")
    public String   updateMedicion(@PathVariable("id") Long id, @ModelAttribute MedicionDTO medicion){
        medicionService.updateMedicion(id, medicion);
        return ("redirect:/mediciones");
    }

    @GetMapping("/eliminar/{id}")
    public String   deleteMedicion(@PathVariable("id") Long id){
        medicionService.deleteMedicion(id);
        return ("redirect:/mediciones");
    }
}
