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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.buyconnex.buyconnex.service.article.MarqueService;
import com.buyconnex.buyconnex.vo.article.MarquesVo;

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
	public ResponseEntity<MarquesVo> saveMarque(@RequestParam("libelle") String libelle, @RequestParam("description") String description) {
		MarquesVo marquesVo = new MarquesVo();
		marquesVo.setLibelle(libelle);
		marquesVo.setDescription(description);
		MarquesVo marque = marqueService.saveMarques(marquesVo);
		return ResponseEntity.status(201).body(marque);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<MarquesVo> updateMarque(@RequestParam("id") Long id, @RequestParam("libelle") String libelle, @RequestParam("description") String description) {
		MarquesVo marquesVo = new MarquesVo();
		marquesVo.setLibelle(libelle);
		marquesVo.setDescription(description);
		MarquesVo marque = marqueService.updateMarques(id, marquesVo);
		return marque != null ? ResponseEntity.ok(marque) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdMarque(@PathVariable Long id) {
		marqueService.deleteMarquesById(id);
		return ResponseEntity.noContent().build();
	}
}
