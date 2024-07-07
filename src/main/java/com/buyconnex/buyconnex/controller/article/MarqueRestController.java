package com.buyconnex.buyconnex.controller.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.buyconnex.buyconnex.service.article.MarqueService;
import com.buyconnex.buyconnex.vo.article.MarquesVo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/marques")
@CrossOrigin(origins = "*")
public class MarqueRestController {

	@Autowired
	MarqueService marqueService;
	
	@GetMapping
	public ResponseEntity<List<MarquesVo>> findAllMarques() {
		List<MarquesVo> marque = marqueService.findAll();
		return ResponseEntity.ok(marque);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MarquesVo> findMarqueById(@PathVariable Long id) {
		MarquesVo marque = marqueService.findById(id).isPresent() ? marqueService.findById(id).get() : null;
		return marque != null ? ResponseEntity.ok(marque) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<MarquesVo> saveMarque(@Valid @RequestBody MarquesVo marquesVo) {
		MarquesVo marque = marqueService.saveMarques(marquesVo);
		return ResponseEntity.status(201).body(marque);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<MarquesVo> updateMarque(@PathVariable Long id, @Valid @RequestBody MarquesVo marquesVo) {
		MarquesVo marque = marqueService.updateMarques(id, marquesVo);
		return marque != null ? ResponseEntity.ok(marque) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdMarque(@PathVariable Long id) {
		marqueService.deleteMarquesById(id);
		return ResponseEntity.noContent().build();
	}
}
