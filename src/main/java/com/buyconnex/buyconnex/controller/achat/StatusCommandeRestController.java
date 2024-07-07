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

import com.buyconnex.buyconnex.service.achat.StatusCommandeService;
import com.buyconnex.buyconnex.vo.achat.StatusCommandesVo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/status-commandes")
@CrossOrigin(origins = "*")
public class StatusCommandeRestController {

	@Autowired
	StatusCommandeService statusCommandeService;
	
	@GetMapping
	public ResponseEntity<List<StatusCommandesVo>> findAllStatusCommandes() {
		List<StatusCommandesVo> statusCommande = statusCommandeService.findAll();
		return ResponseEntity.ok(statusCommande);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StatusCommandesVo> findStatusCommandeById(@PathVariable Long id) {
		StatusCommandesVo statusCommande = statusCommandeService.findById(id).isPresent() ? statusCommandeService.findById(id).get() : null;
		return statusCommande != null ? ResponseEntity.ok(statusCommande) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<StatusCommandesVo> saveStatusCommande(@Valid @RequestBody StatusCommandesVo statusCommandesVo) {
		StatusCommandesVo statusCommande = statusCommandeService.saveStatusCommandes(statusCommandesVo);
		return ResponseEntity.status(201).body(statusCommande);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<StatusCommandesVo> updateStatusCommande(@PathVariable Long id, @Valid @RequestBody StatusCommandesVo statusCommandesVo) {
		StatusCommandesVo statusCommande = statusCommandeService.updateStatusCommandes(id, statusCommandesVo);
		return statusCommande != null ? ResponseEntity.ok(statusCommande) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdStatusCommande(@PathVariable Long id) {
		statusCommandeService.deleteStatusCommandesById(id);
		return ResponseEntity.noContent().build();
	}
}
