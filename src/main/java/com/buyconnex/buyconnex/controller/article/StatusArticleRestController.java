package com.buyconnex.buyconnex.controller.article;

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

import com.buyconnex.buyconnex.service.article.StatusArticleService;
import com.buyconnex.buyconnex.vo.article.StatusArticlesVo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/status-articles")
@CrossOrigin(origins = "*")
public class StatusArticleRestController {

	@Autowired
	StatusArticleService statusArticleService;
	
	@GetMapping
	public ResponseEntity<List<StatusArticlesVo>> findAllStatusArticles() {
		List<StatusArticlesVo> StatusArticle = statusArticleService.findAll();
		return ResponseEntity.ok(StatusArticle);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StatusArticlesVo> findStatusArticleById(@PathVariable Long id) {
		StatusArticlesVo statusArticle = statusArticleService.findById(id).isPresent() ? statusArticleService.findById(id).get() : null;
		return statusArticle != null ? ResponseEntity.ok(statusArticle) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<StatusArticlesVo> saveStatusArticle(@Valid @RequestBody StatusArticlesVo statusArticlesVo) {
		StatusArticlesVo statusArticle = statusArticleService.saveStatusArticles(statusArticlesVo);
		return ResponseEntity.status(201).body(statusArticle);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<StatusArticlesVo> updateStatusArticle(@PathVariable Long id, @Valid @RequestBody StatusArticlesVo statusArticlesVo) {
		StatusArticlesVo statusArticle = statusArticleService.updateStatusArticles(id, statusArticlesVo);
		return statusArticle != null ? ResponseEntity.ok(statusArticle) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdStatusArticle(@PathVariable Long id) {
		statusArticleService.deleteStatusArticlesById(id);
		return ResponseEntity.noContent().build();
	}
}
