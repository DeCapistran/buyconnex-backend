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

import com.buyconnex.buyconnex.service.achat.StatusLivraisonService;
import com.buyconnex.buyconnex.vo.achat.StatusLivraisonsVo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/status-livraisons")
@CrossOrigin(origins = "*")
public class StatusLivraisonRestController {

	@Autowired
	StatusLivraisonService statusLivraisonService;
	
	@GetMapping
	public ResponseEntity<List<StatusLivraisonsVo>> findAllStatusLivraisons() {
		List<StatusLivraisonsVo> statusLivraison = statusLivraisonService.findAll();
		return ResponseEntity.ok(statusLivraison);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StatusLivraisonsVo> findStatusLivraisonById(@PathVariable Long id) {
		StatusLivraisonsVo statusLivraison = statusLivraisonService.findById(id).isPresent() ? statusLivraisonService.findById(id).get() : null;
		return statusLivraison != null ? ResponseEntity.ok(statusLivraison) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<StatusLivraisonsVo> saveStatusLivraison(@Valid @RequestBody StatusLivraisonsVo statusLivraisonsVo) {
		StatusLivraisonsVo statusLivraison = statusLivraisonService.saveStatusLivraisons(statusLivraisonsVo);
		return ResponseEntity.status(201).body(statusLivraison);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<StatusLivraisonsVo> updateStatusLivraison(@PathVariable Long id, @Valid @RequestBody StatusLivraisonsVo statusLivraisonsVo) {
		StatusLivraisonsVo statusLivraison = statusLivraisonService.updateStatusLivraisons(id, statusLivraisonsVo);
		return statusLivraison != null ? ResponseEntity.ok(statusLivraison) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdStatusLivraison(@PathVariable Long id) {
		statusLivraisonService.deleteStatusLivraisonsById(id);
		return ResponseEntity.noContent().build();
	}
}
