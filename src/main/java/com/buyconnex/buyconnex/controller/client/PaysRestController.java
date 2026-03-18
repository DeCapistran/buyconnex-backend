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

import com.buyconnex.buyconnex.service.client.PaysService;
import com.buyconnex.buyconnex.vo.client.PaysVo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pays")
@CrossOrigin(origins = "*")
public class PaysRestController {

	@Autowired
	PaysService paysService;
	
	@GetMapping
	public ResponseEntity<List<PaysVo>> findAllPayss() {
		List<PaysVo> pays = paysService.findAll();
		return ResponseEntity.ok(pays);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PaysVo> findPaysById(@PathVariable Long id) {
		PaysVo pays = paysService.findById(id).isPresent() ? paysService.findById(id).get() : null;
		return pays != null ? ResponseEntity.ok(pays) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<PaysVo> savePays(@Valid @RequestBody PaysVo payssVo) {
		PaysVo pays = paysService.savePays(payssVo);
		return ResponseEntity.status(201).body(pays);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PaysVo> updatePays(@PathVariable Long id, @Valid @RequestBody PaysVo payssVo) {
		PaysVo pays = paysService.updatePays(id, payssVo);
		return pays != null ? ResponseEntity.ok(pays) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdPays(@PathVariable Long id) {
		paysService.deletePaysById(id);
		return ResponseEntity.noContent().build();
	}
}
