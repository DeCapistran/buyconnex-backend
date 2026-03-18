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

import com.buyconnex.buyconnex.service.article.CategorieService;
import com.buyconnex.buyconnex.vo.article.CategoriesVo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*")
public class CategorieRestController {

	@Autowired
	CategorieService categorieService;
	
	@GetMapping
	public ResponseEntity<List<CategoriesVo>> findAllCategorie() {
		List<CategoriesVo> categorie = categorieService.findAll();
		return ResponseEntity.ok(categorie);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriesVo> findCategoriesById(@PathVariable Long id) {
		CategoriesVo categorie = categorieService.findById(id).isPresent() ? categorieService.findById(id).get() : null;
		return categorie != null ? ResponseEntity.ok(categorie) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<CategoriesVo> saveCategorie(@Valid @RequestBody CategoriesVo categoriesVo) {
		CategoriesVo categorie = categorieService.saveCategorie(categoriesVo);
		return ResponseEntity.status(201).body(categorie);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoriesVo> updateCategorie(@PathVariable Long id, @Valid @RequestBody CategoriesVo categoriesVo) {
		CategoriesVo categorie = categorieService.updateCategorie(id, categoriesVo);
		return categorie != null ? ResponseEntity.ok(categorie) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdcategorie(@PathVariable Long id) {
		categorieService.deleteCategorieById(id);
		return ResponseEntity.noContent().build();
	}
}
