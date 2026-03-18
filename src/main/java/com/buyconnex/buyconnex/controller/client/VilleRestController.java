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

import com.buyconnex.buyconnex.service.client.VilleService;
import com.buyconnex.buyconnex.vo.client.VillesVo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/villes")
@CrossOrigin(origins = "*")
public class VilleRestController {

	@Autowired
	VilleService villeService;
	
	@GetMapping
	public ResponseEntity<List<VillesVo>> findAllVilles() {
		List<VillesVo> ville = villeService.findAll();
		return ResponseEntity.ok(ville);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<VillesVo> findVilleById(@PathVariable Long id) {
		VillesVo ville = villeService.findById(id).isPresent() ? villeService.findById(id).get() : null;
		return ville != null ? ResponseEntity.ok(ville) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<VillesVo> saveVille(@Valid @RequestBody VillesVo villesVo) {
		VillesVo ville = villeService.saveVilles(villesVo);
		return ResponseEntity.status(201).body(ville);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<VillesVo> updateVille(@PathVariable Long id, @Valid @RequestBody VillesVo villesVo) {
		VillesVo ville = villeService.updateVilles(id, villesVo);
		return ville != null ? ResponseEntity.ok(ville) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdVille(@PathVariable Long id) {
		villeService.deleteVillesByid(id);
		return ResponseEntity.noContent().build();
	}
}
