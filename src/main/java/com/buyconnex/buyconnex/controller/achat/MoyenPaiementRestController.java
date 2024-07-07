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

import com.buyconnex.buyconnex.service.achat.MoyenPaiementService;
import com.buyconnex.buyconnex.vo.achat.MoyensPaiementsVo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/moyens-paiements")
@CrossOrigin(origins = "*")
public class MoyenPaiementRestController {

	@Autowired
	MoyenPaiementService moyensPaiementService;
	
	@GetMapping
	public ResponseEntity<List<MoyensPaiementsVo>> findAllMoyensPaiements() {
		List<MoyensPaiementsVo> moyensPaiement = moyensPaiementService.findAll();
		return ResponseEntity.ok(moyensPaiement);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MoyensPaiementsVo> findMoyensPaiementById(@PathVariable Long id) {
		MoyensPaiementsVo moyensPaiement = moyensPaiementService.findById(id).isPresent() ? moyensPaiementService.findById(id).get() : null;
		return moyensPaiement != null ? ResponseEntity.ok(moyensPaiement) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<MoyensPaiementsVo> saveMoyensPaiement(@Valid @RequestBody MoyensPaiementsVo moyensPaiementsVo) {
		MoyensPaiementsVo moyensPaiement = moyensPaiementService.saveMoyensPaiements(moyensPaiementsVo);
		return ResponseEntity.status(201).body(moyensPaiement);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<MoyensPaiementsVo> updateMoyensPaiement(@PathVariable Long id, @Valid @RequestBody MoyensPaiementsVo moyensPaiementsVo) {
		MoyensPaiementsVo moyensPaiement = moyensPaiementService.updateMoyensPaiements(id, moyensPaiementsVo);
		return moyensPaiement != null ? ResponseEntity.ok(moyensPaiement) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdMoyensPaiement(@PathVariable Long id) {
		moyensPaiementService.deleteMoyensPaiementsById(id);
		return ResponseEntity.noContent().build();
	}
}
