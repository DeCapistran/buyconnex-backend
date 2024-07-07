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

import com.buyconnex.buyconnex.service.client.ClientService;
import com.buyconnex.buyconnex.vo.client.ClientsVo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/client")
@CrossOrigin(origins = "*")
public class ClientRestController {
	
	@Autowired
	ClientService clientService;
	
	@GetMapping
	public ResponseEntity<List<ClientsVo>> findAllClients() {
		List<ClientsVo> client = clientService.findAll();
		return ResponseEntity.ok(client);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClientsVo> findClientById(@PathVariable Long id) {
		ClientsVo client = clientService.findById(id).isPresent() ? clientService.findById(id).get() : null;
		return client != null ? ResponseEntity.ok(client) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<ClientsVo> saveClient(@Valid @RequestBody ClientsVo clientsVo) {
		ClientsVo client = clientService.saveClients(clientsVo);
		return ResponseEntity.status(201).body(client);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ClientsVo> updateClient(@PathVariable Long id, @Valid @RequestBody ClientsVo clientsVo) {
		ClientsVo client = clientService.updateClients(id, clientsVo);
		return client != null ? ResponseEntity.ok(client) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdClient(@PathVariable Long id) {
		clientService.deleteClientsById(id);
		return ResponseEntity.noContent().build();
	}
}
