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

import com.buyconnex.buyconnex.service.article.TagArticleService;
import com.buyconnex.buyconnex.vo.article.TagsArticlesVo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tags-articles")
@CrossOrigin(origins = "*")
public class TagArticleRestController {

	@Autowired
	TagArticleService tagArticleService;
	
	@GetMapping
	public ResponseEntity<List<TagsArticlesVo>> findAllTagArticles() {
		List<TagsArticlesVo> tagArticle = tagArticleService.findAll();
		return ResponseEntity.ok(tagArticle);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TagsArticlesVo> findTagArticleById(@PathVariable Long id) {
		TagsArticlesVo tagArticle = tagArticleService.findById(id).isPresent() ? tagArticleService.findById(id).get() : null;
		return tagArticle != null ? ResponseEntity.ok(tagArticle) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<TagsArticlesVo> saveTagArticle(@Valid @RequestBody TagsArticlesVo tagArticlesVo) {
		TagsArticlesVo tagArticle = tagArticleService.saveTagsArticles(tagArticlesVo);
		return ResponseEntity.status(201).body(tagArticle);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TagsArticlesVo> updateTagArticle(@PathVariable Long id, @Valid @RequestBody TagsArticlesVo tagArticlesVo) {
		TagsArticlesVo tagArticle = tagArticleService.updateTagsArticles(id, tagArticlesVo);
		return tagArticle != null ? ResponseEntity.ok(tagArticle) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdTagArticle(@PathVariable Long id) {
		tagArticleService.deleteTagsArticlesById(id);
		return ResponseEntity.noContent().build();
	}
}
