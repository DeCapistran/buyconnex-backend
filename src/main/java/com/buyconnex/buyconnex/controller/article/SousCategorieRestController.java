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

import com.buyconnex.buyconnex.service.article.SousCategorieService;
import com.buyconnex.buyconnex.vo.article.SousCategoriesVo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/sous-categories")
@CrossOrigin(origins = "*")
public class SousCategorieRestController {

	@Autowired
	SousCategorieService sousCategorieService ;
	
	@GetMapping
	public ResponseEntity<List<SousCategoriesVo>> findAllSousCategories() {
		List<SousCategoriesVo> sousCategorie = sousCategorieService.findAll();
		return ResponseEntity.ok(sousCategorie);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SousCategoriesVo> findSousCategorieById(@PathVariable Long id) {
		SousCategoriesVo sousCategorie = sousCategorieService.findById(id).isPresent() ? sousCategorieService.findById(id).get() : null;
		return sousCategorie != null ? ResponseEntity.ok(sousCategorie) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<SousCategoriesVo> saveSousCategorie(@Valid @RequestBody SousCategoriesVo sousCategoriesVo) {
		SousCategoriesVo sousCategorie = sousCategorieService.saveSousCategorie(sousCategoriesVo);
		return ResponseEntity.status(201).body(sousCategorie);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<SousCategoriesVo> updateSousCategorie(@PathVariable Long id, @Valid @RequestBody SousCategoriesVo sousCategoriesVo) {
		SousCategoriesVo sousCategorie = sousCategorieService.updateSousCategorie(id, sousCategoriesVo);
		return sousCategorie != null ? ResponseEntity.ok(sousCategorie) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdSousCategorie(@PathVariable Long id) {
		sousCategorieService.deleteSousCategorieById(id);
		return ResponseEntity.noContent().build();
	}
}
