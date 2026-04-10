package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.RemedioEntity;
import com.example.demo.interfaces.IRemedioService;

@RestController
@RequestMapping("/api/v1/entities/remedio")
public class RemedioController {
	@Autowired
	private IRemedioService service;
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		try {
			return ResponseEntity.ok(service.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(404).body(e);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		try {
			return ResponseEntity.ok(service.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(404).body(e);
		}
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody RemedioEntity remedio){
		try {
			return ResponseEntity.ok(service.save(remedio));
		} catch (Exception e) {
			return ResponseEntity.status(404).body(e);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody RemedioEntity remedio, @PathVariable Long id){
		try {
			RemedioEntity existingRemedio = service.findById(id);
			if (existingRemedio == null) {
				return ResponseEntity.status(404).body("Remedio no encontrado");
			}
			existingRemedio.setNombreCientifico(remedio.getNombreCientifico());
			existingRemedio.setAnio(remedio.getAnio());
			existingRemedio.setGramos(remedio.getGramos());
			existingRemedio.setMarca(remedio.getMarca());
			existingRemedio.setTipo(remedio.getTipo());
			existingRemedio.setControlado(remedio.controlado);
			return ResponseEntity.ok(service.save(existingRemedio));
		} catch (Exception e) {
			return ResponseEntity.status(404).body(e);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		try {
			RemedioEntity existingPersona = service.findById(id);
			if (existingPersona == null) {
				return ResponseEntity.status(404).body("Remedio no encontrado");
			}
			service.deleteById(id);
			return ResponseEntity.ok("Remedio eliminado exitosamente");
		} catch (Exception e) {
			return ResponseEntity.status(404).body(e);
		}
	}
}
