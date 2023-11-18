package com.fiap.gs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.gs.models.Vacina;
import com.fiap.gs.repository.VacinaRepository;

@RestController
@RequestMapping("/api/vacina")
public class VacinaController {
	
	@Autowired
	VacinaRepository repository;
	
	@GetMapping()
	public ResponseEntity<List<Vacina>> list() {
		List<Vacina> vacinas = repository.findAll();
		
		return ResponseEntity.ok(vacinas);
	}

}
