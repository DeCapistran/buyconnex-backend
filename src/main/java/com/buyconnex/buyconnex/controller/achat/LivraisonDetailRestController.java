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

import com.buyconnex.buyconnex.service.achat.LivraisonDetailService;
import com.buyconnex.buyconnex.vo.achat.LivraisonsDetailsVo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/livraisons-details")
@CrossOrigin(origins = "*")
public class LivraisonDetailRestController {

	@Autowired
	LivraisonDetailService livraisonsDetailService;
	
	@GetMapping
	public ResponseEntity<List<LivraisonsDetailsVo>> findAllLivraisonsDetailss() {
		List<LivraisonsDetailsVo> livraisonsDetail = livraisonsDetailService.findAll();
		return ResponseEntity.ok(livraisonsDetail);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LivraisonsDetailsVo> findLivraisonsDetailsById(@PathVariable Long id) {
		LivraisonsDetailsVo livraisonsDetail = livraisonsDetailService.findById(id).isPresent() ? livraisonsDetailService.findById(id).get() : null;
		return livraisonsDetail != null ? ResponseEntity.ok(livraisonsDetail) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<LivraisonsDetailsVo> saveLivraisonsDetails(@Valid @RequestBody LivraisonsDetailsVo livraisonsDetailsVo) {
		LivraisonsDetailsVo livraisonsDetail = livraisonsDetailService.saveLivraisonsDetails(livraisonsDetailsVo);
		return ResponseEntity.status(201).body(livraisonsDetail);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<LivraisonsDetailsVo> updateLivraisonsDetails(@PathVariable Long id, @Valid @RequestBody LivraisonsDetailsVo livraisonsDetailsVo) {
		LivraisonsDetailsVo livraisonsDetail = livraisonsDetailService.updateLivraisonsDetails(id, livraisonsDetailsVo);
		return livraisonsDetail != null ? ResponseEntity.ok(livraisonsDetail) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdLivraisonsDetails(@PathVariable Long id) {
		livraisonsDetailService.deleteLivraisonsDetailsById(id);
		return ResponseEntity.noContent().build();
	}
}
