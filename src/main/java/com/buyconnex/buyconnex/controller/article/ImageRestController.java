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

import com.buyconnex.buyconnex.service.article.ImageService;
import com.buyconnex.buyconnex.vo.article.ImagesVo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/images")
@CrossOrigin(origins = "*")
public class ImageRestController {

	@Autowired
	ImageService imageService;
	
	@GetMapping
	public ResponseEntity<List<ImagesVo>> findAllImages() {
		List<ImagesVo> image = imageService.findAll();
		return ResponseEntity.ok(image);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ImagesVo> findImageById(@PathVariable Long id) {
		ImagesVo image = imageService.findById(id).isPresent() ? imageService.findById(id).get() : null;
		return image != null ? ResponseEntity.ok(image) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<ImagesVo> saveImage(@Valid @RequestBody ImagesVo imagesVo) {
		ImagesVo image = imageService.saveImages(imagesVo);
		return ResponseEntity.status(201).body(image);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ImagesVo> updateImage(@PathVariable Long id, @Valid @RequestBody ImagesVo imagesVo) {
		ImagesVo image = imageService.updateImages(id, imagesVo);
		return image != null ? ResponseEntity.ok(image) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdImage(@PathVariable Long id) {
		imageService.deleteImagesById(id);
		return ResponseEntity.noContent().build();
	}
}
