package com.buyconnex.buyconnex.controller.achat;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.buyconnex.buyconnex.service.achat.PromotionService;
import com.buyconnex.buyconnex.vo.achat.PromotionsVo;

@RestController
@RequestMapping("/api/promotions")
@CrossOrigin(origins = "*")
public class PromotionRestController {

	@Autowired
	PromotionService promotionService;
	
	@GetMapping
	public ResponseEntity<List<PromotionsVo>> findAllPromotions() {
		List<PromotionsVo> promotion = promotionService.findAll();
		return ResponseEntity.ok(promotion);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PromotionsVo> findPromotionById(@PathVariable Long id) {
		PromotionsVo promotion = promotionService.findById(id).isPresent() ? promotionService.findById(id).get() : null;
		return promotion != null ? ResponseEntity.ok(promotion) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<PromotionsVo> savePromotion(
			@RequestParam("libelle") String libelle,
			@RequestParam("pourcentage") int pourcentage,
			@RequestParam("dateDebut") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut,
			@RequestParam("dateFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin,
			@RequestParam("description") String description,
			@RequestParam(value = "articlesIds", required = false) List<Long> articlesIds) {
		PromotionsVo promotion = promotionService.savePromotions(libelle, pourcentage, dateDebut, dateFin, description, articlesIds);
		return ResponseEntity.status(201).body(promotion);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PromotionsVo> updatePromotion(
			@PathVariable Long id,
			@RequestParam("libelle") String libelle,
			@RequestParam("pourcentage") int pourcentage,
			@RequestParam("dateDebut") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut,
			@RequestParam("dateFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin,
			@RequestParam("description") String description,
			@RequestParam(value = "articlesIds", required = false) List<Long> articlesIds) {
		PromotionsVo promotion = promotionService.updatePromotions(id, libelle, pourcentage, dateDebut, dateFin, description, articlesIds);
		return promotion != null ? ResponseEntity.ok(promotion) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdPromotion(@PathVariable Long id) {
		promotionService.deletePromotionsById(id);
		return ResponseEntity.noContent().build();
	}
}
