package com.elias.AppSpring.Controller;

import com.elias.AppSpring.Entity.Agenda;
import com.elias.AppSpring.Entity.Anotacion;
import com.elias.AppSpring.Repository.AgendaRepository;
import com.elias.AppSpring.Repository.AnotacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendas")
public class AgendaController {
	@Autowired
	private AgendaRepository    agendaRepository;

	@Autowired
	private AnotacionRepository anotacionRepository;

	@GetMapping
	public List<Agenda>        getAllAgendas(){
		return this.agendaRepository.findAll();
	}

	@PostMapping
	public Agenda createAgenda(@RequestBody Agenda agenda) {
		return agendaRepository.save(agenda);
	}

	@PostMapping("/{agendaId}/anotaciones")
	public ResponseEntity<Anotacion> addAnotacion(@PathVariable("agendaId") int agendaId, @RequestBody Anotacion anotacion) {
		return agendaRepository.findById(agendaId).map(agenda -> {
			anotacion.setAgenda(agenda);
			Anotacion newAnotacion = anotacionRepository.save(anotacion);
			return ResponseEntity.ok(newAnotacion);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public void deleteAgenda(@PathVariable("id") int id) {
		this.agendaRepository.deleteById(id);
	}

	@DeleteMapping("/anotaciones/{id}")
	public void deleteAnotacion(@PathVariable("id") int id) {
		this.anotacionRepository.deleteById(id);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Agenda> getAgendaById(@PathVariable("id") int id) {
		return agendaRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/anho/{anho}")
	public List<Agenda> getAgendasByAnho(@PathVariable("anho") int anho) {
		return agendaRepository.findByAnho(anho);
	}

	@PutMapping("/anotaciones/{id}")
	public ResponseEntity<Anotacion> updateAnotacion(@PathVariable("id") int id, @RequestBody Anotacion newAnotacion) {
		return anotacionRepository.findById(id).map(anotacion -> {
			anotacion.setContenido(newAnotacion.getContenido());
			anotacionRepository.save(anotacion);
			return ResponseEntity.ok(anotacion);
		}).orElse(ResponseEntity.notFound().build());
	}
}
