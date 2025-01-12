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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.buyconnex.buyconnex.service.article.TagService;
import com.buyconnex.buyconnex.vo.article.TagsVo;

@RestController
@RequestMapping("/api/tags")
@CrossOrigin(origins = "*")
public class TagRestController {

	@Autowired
	TagService tagService;
	
	@GetMapping
	public ResponseEntity<List<TagsVo>> findAllTags() {
		List<TagsVo> tag = tagService.findAll();
		return ResponseEntity.ok(tag);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TagsVo> findTagById(@PathVariable Long id) {
		TagsVo tag = tagService.findById(id).isPresent() ? tagService.findById(id).get() : null;
		return tag != null ? ResponseEntity.ok(tag) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<TagsVo> saveTag(@RequestParam("nom") String nom, @RequestParam("description") String description) {
		TagsVo tagsVo = new TagsVo();
		tagsVo.setDescription(description);
		tagsVo.setNom(nom);
		TagsVo tag = tagService.saveTags(tagsVo);
		return ResponseEntity.status(201).body(tag);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TagsVo> updateTag(@RequestParam("id") Long id, @RequestParam("nom") String nom, @RequestParam("description") String description) {
		TagsVo tagsVo = new TagsVo();
		tagsVo.setDescription(description);
		tagsVo.setNom(nom);
		TagsVo tag = tagService.updateTags(id, tagsVo);
		return tag != null ? ResponseEntity.ok(tag) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdTag(@PathVariable Long id) {
		tagService.deleteTagsById(id);
		return ResponseEntity.noContent().build();
	}
}
