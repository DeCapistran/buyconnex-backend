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

import com.buyconnex.buyconnex.service.client.CommuneService;
import com.buyconnex.buyconnex.vo.client.CommunesVo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/communes")
@CrossOrigin(origins = "*")
public class CommuneRestController {

	@Autowired
	CommuneService communeService;
	
	@GetMapping
	public ResponseEntity<List<CommunesVo>> findAllCommunes() {
		List<CommunesVo> commune = communeService.findAll();
		return ResponseEntity.ok(commune);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CommunesVo> findCommuneById(@PathVariable Long id) {
		CommunesVo commune = communeService.findById(id).isPresent() ? communeService.findById(id).get() : null;
		return commune != null ? ResponseEntity.ok(commune) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<CommunesVo> saveCommune(@Valid @RequestBody CommunesVo communesVo) {
		CommunesVo commune = communeService.saveCommunes(communesVo);
		return ResponseEntity.status(201).body(commune);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CommunesVo> updateCommune(@PathVariable Long id, @Valid @RequestBody CommunesVo communesVo) {
		CommunesVo commune = communeService.updateCommunes(id, communesVo);
		return commune != null ? ResponseEntity.ok(commune) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdCommune(@PathVariable Long id) {
		communeService.deleteCommunesById(id);
		return ResponseEntity.noContent().build();
	}
}
