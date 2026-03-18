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

import com.buyconnex.buyconnex.service.achat.CommandeDetailService;
import com.buyconnex.buyconnex.vo.achat.CommandesDetailsVo;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/commandes-details")
@CrossOrigin(origins = "*")
public class CommandeDetailRestController {

	@Autowired
	CommandeDetailService commandesDetailService;
	
	@GetMapping
	public ResponseEntity<List<CommandesDetailsVo>> findAllCommandesDetails() {
		List<CommandesDetailsVo> commandesDetail = commandesDetailService.findAll();
		return ResponseEntity.ok(commandesDetail);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CommandesDetailsVo> findCommandesDetailById(@PathVariable Long id) {
		CommandesDetailsVo commandesDetail = commandesDetailService.findById(id).isPresent() ? commandesDetailService.findById(id).get() : null;
		return commandesDetail != null ? ResponseEntity.ok(commandesDetail) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<CommandesDetailsVo> saveCommandesDetail(@Valid @RequestBody CommandesDetailsVo commandesDetailsVo) {
		CommandesDetailsVo commandesDetail = commandesDetailService.saveCommandesDetails(commandesDetailsVo);
		return ResponseEntity.status(201).body(commandesDetail);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CommandesDetailsVo> updateCommandesDetail(@PathVariable Long id, @Valid @RequestBody CommandesDetailsVo commandesDetailsVo) {
		CommandesDetailsVo commandesDetail = commandesDetailService.updateCommandesdetails(id, commandesDetailsVo);
		return commandesDetail != null ? ResponseEntity.ok(commandesDetail) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdCommandesDetail(@PathVariable Long id) {
		commandesDetailService.deleteCommandesDetailsById(id);
		return ResponseEntity.noContent().build();
	}
}
