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

import com.buyconnex.buyconnex.service.article.ArticleService;
import com.buyconnex.buyconnex.vo.article.ArticlesImagesVo;
import com.buyconnex.buyconnex.vo.article.ArticlesVo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/articles")
@CrossOrigin(origins = "*")
public class ArticleRestController {

	@Autowired
	ArticleService articleService;
	
	@GetMapping
	public ResponseEntity<List<ArticlesVo>> findAllArticles() {
		List<ArticlesVo> articles = articleService.findAll();
		return ResponseEntity.ok(articles);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ArticlesVo> findArticleById(@PathVariable Long id) {
		ArticlesVo articles = articleService.findById(id).isPresent() ? articleService.findById(id).get() : null;
		return articles != null ? ResponseEntity.ok(articles) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<ArticlesVo> saveArticle(@Valid @RequestBody ArticlesVo articlesVo) {
		ArticlesVo articles = articleService.saveArticle(articlesVo);
		return ResponseEntity.status(201).body(articles);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ArticlesVo> updateArticle(@PathVariable Long id, @Valid @RequestBody ArticlesVo articlesVo) {
		ArticlesVo articles = articleService.updateArticles(id, articlesVo);
		return articles != null ? ResponseEntity.ok(articles) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdArticle(@PathVariable Long id) {
		articleService.deleteArticlesById(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/promotion/{id}")
	public ResponseEntity<List<ArticlesVo>> findArticlesByPromotionId(@PathVariable Long id) {
		List<ArticlesVo> articles = articleService.findByPromotionId(id);
		return ResponseEntity.ok(articles);
	}

	@GetMapping("/{id}/images")
	public ResponseEntity<List<ArticlesImagesVo>> findImagesByArticleId(@PathVariable Long id) {
		return articleService.getImagesByArticleId(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	/*@GetMapping
	public ResponseEntity<List<ArticlesVo>> findByBoutique(@PathVariable BoutiquesVo boutiquesVo) {
		List<ArticlesVo> articles = articleService.findByBoutique(boutiquesVo);
		return ResponseEntity.ok(articles);
	}*/
}
