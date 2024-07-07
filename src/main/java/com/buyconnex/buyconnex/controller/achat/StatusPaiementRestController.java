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

import com.buyconnex.buyconnex.service.achat.StatusPaiementService;
import com.buyconnex.buyconnex.vo.achat.StatusPaiementsVo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/status-paiements")
@CrossOrigin(origins = "*")
public class StatusPaiementRestController {

	@Autowired
	StatusPaiementService statusPaiementService;
	
	@GetMapping
	public ResponseEntity<List<StatusPaiementsVo>> findAllStatusPaiements() {
		List<StatusPaiementsVo> statusPaiement = statusPaiementService.findAll();
		return ResponseEntity.ok(statusPaiement);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StatusPaiementsVo> findStatusPaiementById(@PathVariable Long id) {
		StatusPaiementsVo statusPaiement = statusPaiementService.findById(id).isPresent() ? statusPaiementService.findById(id).get() : null;
		return statusPaiement != null ? ResponseEntity.ok(statusPaiement) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<StatusPaiementsVo> saveStatusPaiement(@Valid @RequestBody StatusPaiementsVo statusPaiementsVo) {
		StatusPaiementsVo statusPaiement = statusPaiementService.saveStatusPaiements(statusPaiementsVo);
		return ResponseEntity.status(201).body(statusPaiement);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<StatusPaiementsVo> updateStatusPaiement(@PathVariable Long id, @Valid @RequestBody StatusPaiementsVo statusPaiementsVo) {
		StatusPaiementsVo statusPaiement = statusPaiementService.updateStatusPaiements(id, statusPaiementsVo);
		return statusPaiement != null ? ResponseEntity.ok(statusPaiement) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdStatusPaiement(@PathVariable Long id) {
		statusPaiementService.deleteStatusPaiementsById(id);
		return ResponseEntity.noContent().build();
	}
}
