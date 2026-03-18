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

import com.buyconnex.buyconnex.service.achat.CommandeService;
import com.buyconnex.buyconnex.vo.achat.CommandesVo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/commandes")
@CrossOrigin(origins = "*")
public class CommandeRestController {

	@Autowired
	CommandeService commandeService;
	
	@GetMapping
	public ResponseEntity<List<CommandesVo>> findAllCommandes() {
		List<CommandesVo> commande = commandeService.findAll();
		return ResponseEntity.ok(commande);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CommandesVo> findCommandeById(@PathVariable Long id) {
		CommandesVo commande = commandeService.findById(id).isPresent() ? commandeService.findById(id).get() : null;
		return commande != null ? ResponseEntity.ok(commande) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<CommandesVo> saveCommande(@Valid @RequestBody CommandesVo commandesVo) {
		CommandesVo commande = commandeService.saveCommandes(commandesVo);
		return ResponseEntity.status(201).body(commande);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CommandesVo> updateCommande(@PathVariable Long id, @Valid @RequestBody CommandesVo commandesVo) {
		CommandesVo commande = commandeService.updateCommandes(id, commandesVo);
		return commande != null ? ResponseEntity.ok(commande) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdCommande(@PathVariable Long id) {
		commandeService.deleteCommandesById(id);
		return ResponseEntity.noContent().build();
	}
}
