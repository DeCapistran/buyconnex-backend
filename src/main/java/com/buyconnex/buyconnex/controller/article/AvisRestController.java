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
import com.buyconnex.buyconnex.service.article.AvisService;
import com.buyconnex.buyconnex.vo.article.ArticlesVo;
import com.buyconnex.buyconnex.vo.article.AvisVo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/avis")
@CrossOrigin(origins = "*")
public class AvisRestController {

	@Autowired
	AvisService avisService;
	
	@Autowired
	ArticleService articleService;
	
	@GetMapping
	public ResponseEntity<List<AvisVo>> findAllAvis() {
		List<AvisVo> avis = avisService.findAll();
		return ResponseEntity.ok(avis);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AvisVo> findAvisById(@PathVariable Long id) {
		AvisVo avis = avisService.findById(id).isPresent() ? avisService.findById(id).get() : null;
		return avis != null ? ResponseEntity.ok(avis) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<AvisVo> saveAvis(@Valid @RequestBody AvisVo avisVo) {
		AvisVo avis = avisService.saveAvis(avisVo);
		return ResponseEntity.status(201).body(avis);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AvisVo> updateAvis(@PathVariable Long id, @Valid @RequestBody AvisVo avisVo) {
		AvisVo avis = avisService.updateAvis(id, avisVo);
		return avis != null ? ResponseEntity.ok(avis) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdAvis(@PathVariable Long id) {
		avisService.deleteAvisById(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/article/{articleId}")
	public ResponseEntity<List<AvisVo>> findAvisByArticleId(@PathVariable Long articleId) {
		ArticlesVo articlesVo = new ArticlesVo();
		articlesVo = articleService.findById(articleId).get();
	    List<AvisVo> avis = avisService.findByArticles(articlesVo);
	    return ResponseEntity.ok(avis);
	}
}
