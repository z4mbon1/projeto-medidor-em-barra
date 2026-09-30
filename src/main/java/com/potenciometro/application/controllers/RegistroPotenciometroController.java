package com.potenciometro.application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.potenciometro.application.entities.RegistroPotenciometro;
import com.potenciometro.application.services.RegistroPotenciometroService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/potenciometro")
@CrossOrigin("*")
public class RegistroPotenciometroController {

	@Autowired
	private RegistroPotenciometroService service;

	@PostMapping
	public ResponseEntity<RegistroPotenciometro> salvar(@Valid @RequestBody RegistroPotenciometro potenciometro) {
		RegistroPotenciometro registroPotenciometro = service.salvar(potenciometro);
		return ResponseEntity.status(HttpStatus.CREATED).body(registroPotenciometro);
	}

	@GetMapping
	public ResponseEntity<List<RegistroPotenciometro>> listarTodos() {
		return ResponseEntity.ok(service.listarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<RegistroPotenciometro> buscarPorId(@PathVariable Long id) {
		return service.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<RegistroPotenciometro> atualizar(@PathVariable Long id,
			@Valid @RequestBody RegistroPotenciometro potenciometro) {

		try {
			RegistroPotenciometro atualizado = service.atualizar(id, potenciometro);
			return ResponseEntity.ok(atualizado);
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		try {
			service.deletar(id);
			return ResponseEntity.noContent().build();
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}

}
