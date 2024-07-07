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

import com.buyconnex.buyconnex.service.achat.PromotionDetailService;
import com.buyconnex.buyconnex.vo.achat.PromotionsDetailsVo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/promotions-details")
@CrossOrigin(origins = "*")
public class PromotionDetailRestController {

	@Autowired
	PromotionDetailService promotionsDetailService;
	
	@GetMapping
	public ResponseEntity<List<PromotionsDetailsVo>> findAllPromotionsDetails() {
		List<PromotionsDetailsVo> promotionsDetail = promotionsDetailService.findAll();
		return ResponseEntity.ok(promotionsDetail);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PromotionsDetailsVo> findPromotionsDetailById(@PathVariable Long id) {
		PromotionsDetailsVo promotionsDetail = promotionsDetailService.findById(id).isPresent() ? promotionsDetailService.findById(id).get() : null;
		return promotionsDetail != null ? ResponseEntity.ok(promotionsDetail) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<PromotionsDetailsVo> savePromotionsDetail(@Valid @RequestBody PromotionsDetailsVo promotionsDetailsVo) {
		PromotionsDetailsVo promotionsDetail = promotionsDetailService.savePromotionsDetails(promotionsDetailsVo);
		return ResponseEntity.status(201).body(promotionsDetail);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PromotionsDetailsVo> updatePromotionsDetail(@PathVariable Long id, @Valid @RequestBody PromotionsDetailsVo promotionsDetailsVo) {
		PromotionsDetailsVo promotionsDetail = promotionsDetailService.updatePromotionsDetails(id, promotionsDetailsVo);
		return promotionsDetail != null ? ResponseEntity.ok(promotionsDetail) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdPromotionsDetail(@PathVariable Long id) {
		promotionsDetailService.deletePromotionDetailsById(id);
		return ResponseEntity.noContent().build();
	}
}
