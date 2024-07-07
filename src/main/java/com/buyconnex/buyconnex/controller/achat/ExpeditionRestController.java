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

import com.buyconnex.buyconnex.service.achat.ExpeditionService;
import com.buyconnex.buyconnex.vo.achat.ExpeditionsVo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/expeditions")
@CrossOrigin(origins = "*")
public class ExpeditionRestController {

	@Autowired
	ExpeditionService expeditionService;
	
	@GetMapping
	public ResponseEntity<List<ExpeditionsVo>> findAllExpeditions() {
		List<ExpeditionsVo> expedition = expeditionService.findAll();
		return ResponseEntity.ok(expedition);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ExpeditionsVo> findExpeditionById(@PathVariable Long id) {
		ExpeditionsVo expedition = expeditionService.findById(id).isPresent() ? expeditionService.findById(id).get() : null;
		return expedition != null ? ResponseEntity.ok(expedition) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<ExpeditionsVo> saveExpedition(@Valid @RequestBody ExpeditionsVo expeditionsVo) {
		ExpeditionsVo expedition = expeditionService.saveExpeditions(expeditionsVo);
		return ResponseEntity.status(201).body(expedition);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ExpeditionsVo> updateExpedition(@PathVariable Long id, @Valid @RequestBody ExpeditionsVo expeditionsVo) {
		ExpeditionsVo expedition = expeditionService.updateExpeditions(id, expeditionsVo);
		return expedition != null ? ResponseEntity.ok(expedition) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdExpedition(@PathVariable Long id) {
		expeditionService.deleteExpeditionsById(id);
		return ResponseEntity.noContent().build();
	}
}
