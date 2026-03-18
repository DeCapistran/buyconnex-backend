package com.buyconnex.buyconnex.controller.visuel;

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

import com.buyconnex.buyconnex.service.visuel.SliderService;
import com.buyconnex.buyconnex.vo.visuel.SlidersVo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/sliders")
@CrossOrigin(origins = "*")
public class SliderRestController {

	@Autowired
	SliderService sliderService;
	
	@GetMapping
	public ResponseEntity<List<SlidersVo>> findAllSliders() {
		List<SlidersVo> slider = sliderService.findAll();
		return ResponseEntity.ok(slider);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SlidersVo> findSliderById(@PathVariable Long id) {
		SlidersVo slider = sliderService.findById(id).isPresent() ? sliderService.findById(id).get() : null;
		return slider != null ? ResponseEntity.ok(slider) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<SlidersVo> saveSlider(@Valid @RequestBody SlidersVo slidersVo) {
		SlidersVo slider = sliderService.saveSliders(slidersVo);
		return ResponseEntity.status(201).body(slider);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<SlidersVo> updateSlider(@PathVariable Long id, @Valid @RequestBody SlidersVo slidersVo) {
		SlidersVo slider = sliderService.updateSliders(id, slidersVo);
		return slider != null ? ResponseEntity.ok(slider) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdSlider(@PathVariable Long id) {
		sliderService.deleteSlidersById(id);
		return ResponseEntity.noContent().build();
	}
}
