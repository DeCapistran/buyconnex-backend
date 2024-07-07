package com.buyconnex.buyconnex.controller.achat;

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

import com.buyconnex.buyconnex.service.achat.LivraisonService;
import com.buyconnex.buyconnex.vo.achat.LivraisonsVo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/livraisons")
@CrossOrigin(origins = "*")
public class LivraisonRestController {

	@Autowired
	LivraisonService livraisonService;
	
	@GetMapping
	public ResponseEntity<List<LivraisonsVo>> findAllLivraisons() {
		List<LivraisonsVo> livraison = livraisonService.findAll();
		return ResponseEntity.ok(livraison);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LivraisonsVo> findLivraisonById(@PathVariable Long id) {
		LivraisonsVo livraison = livraisonService.findById(id).isPresent() ? livraisonService.findById(id).get() : null;
		return livraison != null ? ResponseEntity.ok(livraison) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<LivraisonsVo> saveLivraison(@Valid @RequestBody LivraisonsVo livraisonsVo) {
		LivraisonsVo livraison = livraisonService.saveLivraisons(livraisonsVo);
		return ResponseEntity.status(201).body(livraison);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<LivraisonsVo> updateLivraison(@PathVariable Long id, @Valid @RequestBody LivraisonsVo livraisonsVo) {
		LivraisonsVo livraison = livraisonService.updateLivraisons(id, livraisonsVo);
		return livraison != null ? ResponseEntity.ok(livraison) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdLivraison(@PathVariable Long id) {
		livraisonService.deleteLivraisonsById(id);
		return ResponseEntity.noContent().build();
	}
}
