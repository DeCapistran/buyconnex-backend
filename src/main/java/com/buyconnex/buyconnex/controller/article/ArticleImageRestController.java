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

import com.buyconnex.buyconnex.service.article.ArticleImageService;
import com.buyconnex.buyconnex.vo.article.ArticlesImagesVo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/articles-images")
@CrossOrigin(origins = "*")
public class ArticleImageRestController {

	@Autowired
	ArticleImageService articleImageService;
	
	@GetMapping
	public ResponseEntity<List<ArticlesImagesVo>> findAllArticleImages() {
		List<ArticlesImagesVo> articleImage = articleImageService.findAll();
		return ResponseEntity.ok(articleImage);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ArticlesImagesVo> findArticleImageById(@PathVariable Long id) {
		ArticlesImagesVo articleImage = articleImageService.findById(id).isPresent() ? articleImageService.findById(id).get() : null;
		return articleImage != null ? ResponseEntity.ok(articleImage) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<ArticlesImagesVo> saveArticleImage(@Valid @RequestBody ArticlesImagesVo articleImagesVo) {
		ArticlesImagesVo articleImage = articleImageService.saveArticlesImages(articleImagesVo);
		return ResponseEntity.status(201).body(articleImage);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ArticlesImagesVo> updateArticleImage(@PathVariable Long id, @Valid @RequestBody ArticlesImagesVo articleImagesVo) {
		ArticlesImagesVo articleImage = articleImageService.updateArticlesImages(id, articleImagesVo);
		return articleImage != null ? ResponseEntity.ok(articleImage) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdArticleImage(@PathVariable Long id) {
		articleImageService.deleteArticlesImagesById(id);
		return ResponseEntity.noContent().build();
	}
}
