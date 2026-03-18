package com.buyconnex.buyconnex.controller.visuel;

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

import com.buyconnex.buyconnex.service.visuel.FooterService;
import com.buyconnex.buyconnex.vo.visuel.FootersVo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/footers")
@CrossOrigin(origins = "*")
public class FooterRestController {

	@Autowired
	FooterService footerService;
	
	@GetMapping
	public ResponseEntity<List<FootersVo>> findAllFooters() {
		List<FootersVo> footer = footerService.findAll();
		return ResponseEntity.ok(footer);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FootersVo> findFooterById(@PathVariable Long id) {
		FootersVo footer = footerService.findById(id).isPresent() ? footerService.findById(id).get() : null;
		return footer != null ? ResponseEntity.ok(footer) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<FootersVo> saveFooter(@Valid @RequestBody FootersVo footersVo) {
		FootersVo footer = footerService.saveFooters(footersVo);
		return ResponseEntity.status(201).body(footer);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<FootersVo> updateFooter(@PathVariable Long id, @Valid @RequestBody FootersVo footersVo) {
		FootersVo footer = footerService.updateFooters(id, footersVo);
		return footer != null ? ResponseEntity.ok(footer) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdFooter(@PathVariable Long id) {
		footerService.deleteFootersById(id);
		return ResponseEntity.noContent().build();
	}
}
