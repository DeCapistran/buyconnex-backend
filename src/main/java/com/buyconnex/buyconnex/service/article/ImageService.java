package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.article.Categories;
import com.buyconnex.buyconnex.entity.article.Images;
import com.buyconnex.buyconnex.entity.visuel.Sliders;
import com.buyconnex.buyconnex.repository.article.ImageRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ImageService implements IImageService {

	@Autowired
	ImageRepository imageRepository;
	
	@Override
	public Optional<Images> findById(Long id) {
		return imageRepository.findById(id);
	}

	@Override
	public Images saveImages(Images images) {
		return imageRepository.save(images);
	}

	@Override
	public void deleteImages(Images images) {
		imageRepository.delete(images);
	}

	@Override
	public Images updateImages(Images images) {
		return imageRepository.save(images);
	}

	@Override
	public List<Images> findByArticles(Articles articles) {
		return imageRepository.findByArticles(articles);
	}

	@Override
	public List<Images> findByCategories(Categories categories) {
		return imageRepository.findByCategories(categories);
	}

	@Override
	public List<Images> findByName(String name) {
		return imageRepository.findByName(name);
	}

	@Override
	public List<Images> findBySlider(Sliders sliders) {
		return imageRepository.findBySliders(sliders);
	}

}
