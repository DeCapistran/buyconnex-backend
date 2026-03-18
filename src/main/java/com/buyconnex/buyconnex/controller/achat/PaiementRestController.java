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

import com.buyconnex.buyconnex.service.achat.PaiementService;
import com.buyconnex.buyconnex.vo.achat.PaiementsVo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/paiements")
@CrossOrigin(origins = "*")
public class PaiementRestController {

	@Autowired
	PaiementService paiementService;
	
	@GetMapping
	public ResponseEntity<List<PaiementsVo>> findAllPaiements() {
		List<PaiementsVo> paiement = paiementService.findAll();
		return ResponseEntity.ok(paiement);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PaiementsVo> findPaiementById(@PathVariable Long id) {
		PaiementsVo paiement = paiementService.findById(id).isPresent() ? paiementService.findById(id).get() : null;
		return paiement != null ? ResponseEntity.ok(paiement) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<PaiementsVo> savePaiement(@Valid @RequestBody PaiementsVo paiementsVo) {
		PaiementsVo paiement = paiementService.savePaiements(paiementsVo);
		return ResponseEntity.status(201).body(paiement);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PaiementsVo> updatePaiement(@PathVariable Long id, @Valid @RequestBody PaiementsVo paiementsVo) {
		PaiementsVo paiement = paiementService.updatePaiements(id, paiementsVo);
		return paiement != null ? ResponseEntity.ok(paiement) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdPaiement(@PathVariable Long id) {
		paiementService.deletePaiementsById(id);
		return ResponseEntity.noContent().build();
	}
}
