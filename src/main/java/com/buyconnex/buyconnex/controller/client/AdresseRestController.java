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

import com.buyconnex.buyconnex.service.client.AdresseService;
import com.buyconnex.buyconnex.vo.client.AdresseVo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/adresses")
@CrossOrigin(origins = "*")
public class AdresseRestController {

	@Autowired
	AdresseService adresseService;
	
	@GetMapping
	public ResponseEntity<List<AdresseVo>> findAllAdresses() {
		List<AdresseVo> adresse = adresseService.findAll();
		return ResponseEntity.ok(adresse);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AdresseVo> findAdresseById(@PathVariable Long id) {
		AdresseVo adresse = adresseService.findById(id).isPresent() ? adresseService.findById(id).get() : null;
		return adresse != null ? ResponseEntity.ok(adresse) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<AdresseVo> saveAdresse(@Valid @RequestBody AdresseVo adressesVo) {
		AdresseVo adresse = adresseService.saveAdresse(adressesVo);
		return ResponseEntity.status(201).body(adresse);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AdresseVo> updateAdresse(@PathVariable Long id, @Valid @RequestBody AdresseVo adressesVo) {
		AdresseVo adresse = adresseService.updateAdresse(id, adressesVo);
		return adresse != null ? ResponseEntity.ok(adresse) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdAdresse(@PathVariable Long id) {
		adresseService.deleteAdresseById(id);
		return ResponseEntity.noContent().build();
	}
}
