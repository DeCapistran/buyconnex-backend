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

import com.buyconnex.buyconnex.service.article.CouleurService;
import com.buyconnex.buyconnex.vo.article.CouleursVo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/couleurs")
@CrossOrigin(origins = "*")
public class CouleurRestController {

	@Autowired
	CouleurService couleurService;
	
	@GetMapping
	public ResponseEntity<List<CouleursVo>> findAllCouleurs() {
		List<CouleursVo> couleur = couleurService.findAll();
		return ResponseEntity.ok(couleur);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CouleursVo> findCouleurById(@PathVariable Long id) {
		CouleursVo couleur = couleurService.findById(id).isPresent() ? couleurService.findById(id).get() : null;
		return couleur != null ? ResponseEntity.ok(couleur) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<CouleursVo> saveCouleur(@Valid @RequestBody CouleursVo couleursVo) {
		CouleursVo couleur = couleurService.saveCouleurs(couleursVo);
		return ResponseEntity.status(201).body(couleur);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CouleursVo> updateCouleur(@PathVariable Long id, @Valid @RequestBody CouleursVo couleursVo) {
		CouleursVo couleur = couleurService.updateCouleurs(id, couleursVo);
		return couleur != null ? ResponseEntity.ok(couleur) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdCouleur(@PathVariable Long id) {
		couleurService.deleteCouleursById(id);
		return ResponseEntity.noContent().build();
	}
}
