package com.buyconnex.buyconnex.controller.client;

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

import com.buyconnex.buyconnex.service.client.PanierService;
import com.buyconnex.buyconnex.vo.client.PaniersVo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/paniers")
@CrossOrigin(origins = "*")
public class PanierRestController {

	@Autowired
	PanierService panierService;
	
	@GetMapping
	public ResponseEntity<List<PaniersVo>> findAllPaniers() {
		List<PaniersVo> panier = panierService.findAll();
		return ResponseEntity.ok(panier);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PaniersVo> findPanierById(@PathVariable Long id) {
		PaniersVo panier = panierService.findById(id).isPresent() ? panierService.findById(id).get() : null;
		return panier != null ? ResponseEntity.ok(panier) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<PaniersVo> savePanier(@Valid @RequestBody PaniersVo paniersVo) {
		PaniersVo panier = panierService.savePaniers(paniersVo);
		return ResponseEntity.status(201).body(panier);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PaniersVo> updatePanier(@PathVariable Long id, @Valid @RequestBody PaniersVo paniersVo) {
		PaniersVo panier = panierService.updatePaniers(id, paniersVo);
		return panier != null ? ResponseEntity.ok(panier) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdPanier(@PathVariable Long id) {
		panierService.deletePaniersById(id);
		return ResponseEntity.noContent().build();
	}
}
