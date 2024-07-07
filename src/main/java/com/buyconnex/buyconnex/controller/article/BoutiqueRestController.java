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

import com.buyconnex.buyconnex.service.article.BoutiqueService;
import com.buyconnex.buyconnex.vo.article.BoutiquesVo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/boutiques")
@CrossOrigin(origins = "*")
public class BoutiqueRestController {

	@Autowired
	BoutiqueService boutiqueService;
	
	@GetMapping
	public ResponseEntity<List<BoutiquesVo>> findAllBoutiques() {
		List<BoutiquesVo> boutique = boutiqueService.findAll();
		return ResponseEntity.ok(boutique);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BoutiquesVo> findBoutiquesById(@PathVariable Long id) {
		BoutiquesVo boutique = boutiqueService.findById(id).isPresent() ? boutiqueService.findById(id).get() : null;
		return boutique != null ? ResponseEntity.ok(boutique) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<BoutiquesVo> saveBoutiques(@Valid @RequestBody BoutiquesVo boutiquesVo) {
		BoutiquesVo boutique = boutiqueService.saveBoutique(boutiquesVo);
		return ResponseEntity.status(201).body(boutique);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<BoutiquesVo> updateBoutique(@PathVariable Long id, @Valid @RequestBody BoutiquesVo boutiquesVo) {
		BoutiquesVo boutique = boutiqueService.updateBoutique(id, boutiquesVo);
		return boutique != null ? ResponseEntity.ok(boutique) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdBoutique(@PathVariable Long id) {
		boutiqueService.deleteBoutiqueById(id);
		return ResponseEntity.noContent().build();
	}
}
