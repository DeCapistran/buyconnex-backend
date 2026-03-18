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
import jakarta.validation.Valid;
import com.buyconnex.buyconnex.service.achat.FacturationService;
import com.buyconnex.buyconnex.vo.achat.FacturationsVo;



@RestController
@RequestMapping("/api/facturations")
@CrossOrigin(origins = "*")
public class FacturationRestController {

	@Autowired
	FacturationService facturationService;
	
	@GetMapping
	public ResponseEntity<List<FacturationsVo>> findAllFacturations() {
		List<FacturationsVo> facturation = facturationService.findAll();
		return ResponseEntity.ok(facturation);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FacturationsVo> findFacturationById(@PathVariable Long id) {
		FacturationsVo facturation = facturationService.findById(id).isPresent() ? facturationService.findById(id).get() : null;
		return facturation != null ? ResponseEntity.ok(facturation) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<FacturationsVo> saveFacturation(@Valid @RequestBody FacturationsVo facturationsVo) {
		FacturationsVo facturation = facturationService.saveFacturations(facturationsVo);
		return ResponseEntity.status(201).body(facturation);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<FacturationsVo> updateFacturation(@PathVariable Long id, @Valid @RequestBody FacturationsVo facturationsVo) {
		FacturationsVo facturation = facturationService.updateFacturations(id, facturationsVo);
		return facturation != null ? ResponseEntity.ok(facturation) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdFacturation(@PathVariable Long id) {
		facturationService.deleteFacturationsById(id);
		return ResponseEntity.noContent().build();
	}
}
