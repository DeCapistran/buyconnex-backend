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

import com.buyconnex.buyconnex.service.client.PanierDetailService;
import com.buyconnex.buyconnex.vo.client.PaniersDetailsVo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/paniers-details")
@CrossOrigin(origins = "*")
public class PanierDetailRestController {

	@Autowired
	PanierDetailService panierDetailService;
	
	@GetMapping
	public ResponseEntity<List<PaniersDetailsVo>> findAllPanierDetails() {
		List<PaniersDetailsVo> panierDetail = panierDetailService.findAll();
		return ResponseEntity.ok(panierDetail);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PaniersDetailsVo> findPanierDetailById(@PathVariable Long id) {
		PaniersDetailsVo panierDetail = panierDetailService.findById(id).isPresent() ? panierDetailService.findById(id).get() : null;
		return panierDetail != null ? ResponseEntity.ok(panierDetail) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<PaniersDetailsVo> savePanierDetail(@Valid @RequestBody PaniersDetailsVo panierDetailsVo) {
		PaniersDetailsVo panierDetail = panierDetailService.savePaniersDetails(panierDetailsVo);
		return ResponseEntity.status(201).body(panierDetail);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PaniersDetailsVo> updatePanierDetail(@PathVariable Long id, @Valid @RequestBody PaniersDetailsVo panierDetailsVo) {
		PaniersDetailsVo panierDetail = panierDetailService.updatePaniersDetails(id, panierDetailsVo);
		return panierDetail != null ? ResponseEntity.ok(panierDetail) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdPanierDetail(@PathVariable Long id) {
		panierDetailService.deletepaniersDetailsById(id);
		return ResponseEntity.noContent().build();
	}
}
