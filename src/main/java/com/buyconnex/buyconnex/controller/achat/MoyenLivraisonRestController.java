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

import com.buyconnex.buyconnex.service.achat.MoyenLivraisonService;
import com.buyconnex.buyconnex.vo.achat.MoyensLivraisonsVo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/moyens-livraisons")
@CrossOrigin(origins = "*")
public class MoyenLivraisonRestController {

	@Autowired
	MoyenLivraisonService moyensLivraisonService;
	
	@GetMapping
	public ResponseEntity<List<MoyensLivraisonsVo>> findAllMoyensLivraisons() {
		List<MoyensLivraisonsVo> moyensLivraison = moyensLivraisonService.findAll();
		return ResponseEntity.ok(moyensLivraison);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MoyensLivraisonsVo> findMoyensLivraisonById(@PathVariable Long id) {
		MoyensLivraisonsVo moyensLivraison = moyensLivraisonService.findById(id).isPresent() ? moyensLivraisonService.findById(id).get() : null;
		return moyensLivraison != null ? ResponseEntity.ok(moyensLivraison) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<MoyensLivraisonsVo> saveMoyensLivraison(@Valid @RequestBody MoyensLivraisonsVo moyensLivraisonsVo) {
		MoyensLivraisonsVo moyensLivraison = moyensLivraisonService.saveMoyensLivraisons(moyensLivraisonsVo);
		return ResponseEntity.status(201).body(moyensLivraison);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<MoyensLivraisonsVo> updateMoyensLivraison(@PathVariable Long id, @Valid @RequestBody MoyensLivraisonsVo moyensLivraisonsVo) {
		MoyensLivraisonsVo moyensLivraison = moyensLivraisonService.updateMoyensLivraisons(id, moyensLivraisonsVo);
		return moyensLivraison != null ? ResponseEntity.ok(moyensLivraison) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdMoyensLivraison(@PathVariable Long id) {
		moyensLivraisonService.deleteMoyensLivraisonsById(id);
		return ResponseEntity.noContent().build();
	}
}
