package com.buyconnex.buyconnex.controller.other;

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

import com.buyconnex.buyconnex.service.other.NewsletterService;
import com.buyconnex.buyconnex.vo.other.NewslettersVo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/newsletters")
@CrossOrigin(origins = "*")
public class NewsletterRestController {

	@Autowired
	NewsletterService newsletterService;
	
	@GetMapping
	public ResponseEntity<List<NewslettersVo>> findAllNewsletters() {
		List<NewslettersVo> newsletter = newsletterService.findAll();
		return ResponseEntity.ok(newsletter);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<NewslettersVo> findNewsletterById(@PathVariable Long id) {
		NewslettersVo newsletter = newsletterService.findById(id).isPresent() ? newsletterService.findById(id).get() : null;
		return newsletter != null ? ResponseEntity.ok(newsletter) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<NewslettersVo> saveNewsletter(@Valid @RequestBody NewslettersVo newslettersVo) {
		NewslettersVo newsletter = newsletterService.saveNewsletters(newslettersVo);
		return ResponseEntity.status(201).body(newsletter);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<NewslettersVo> updateNewsletter(@PathVariable Long id, @Valid @RequestBody NewslettersVo newslettersVo) {
		NewslettersVo newsletter = newsletterService.updateNewsletters(id, newslettersVo);
		return newsletter != null ? ResponseEntity.ok(newsletter) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdNewsletter(@PathVariable Long id) {
		newsletterService.deleteNewslettersById(id);
		return ResponseEntity.noContent().build();
	}
}
