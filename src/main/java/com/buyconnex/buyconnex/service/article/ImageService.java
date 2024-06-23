package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.article.Images;
import com.buyconnex.buyconnex.mapper.article.ArticleMapper;
import com.buyconnex.buyconnex.mapper.article.CategorieMapper;
import com.buyconnex.buyconnex.mapper.article.ImageMapper;
import com.buyconnex.buyconnex.mapper.visuel.SliderMapper;
import com.buyconnex.buyconnex.repository.article.ImageRepository;
import com.buyconnex.buyconnex.vo.article.ArticlesVo;
import com.buyconnex.buyconnex.vo.article.CategoriesVo;
import com.buyconnex.buyconnex.vo.article.ImagesVo;
import com.buyconnex.buyconnex.vo.visuel.SlidersVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ImageService implements IImageService {

	@Autowired
	ImageRepository imageRepository;
	
	@Override
	public Optional<ImagesVo> findById(Long id) {
		return imageRepository.findById(id).map(ImageMapper::toVO);
	}

	@Override
	public ImagesVo saveImages(ImagesVo imagesVo) {
		Images images = ImageMapper.toEntity(imagesVo);
		Images imagesSave = imageRepository.save(images);
		return ImageMapper.toVO(imagesSave);
	}

	@Override
	public void deleteImages(ImagesVo imagesVo) {
		Images images = ImageMapper.toEntity(imagesVo);
		imageRepository.delete(images);
	}

	@Override
	public ImagesVo updateImages(Long id, ImagesVo imagesVo) {
		return imageRepository.findById(id).map(image -> {
			ImageMapper.updateEntityFromVO(imagesVo, image);
			Images imagesUpdated = imageRepository.save(image);
			return ImageMapper.toVO(imagesUpdated);
		}).orElse(null);
	}

	@Override
	public List<ImagesVo> findByArticles(ArticlesVo articlesVo) {
		return imageRepository.findByArticles(ArticleMapper.toEntity(articlesVo)).stream().map(ImageMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<ImagesVo> findByCategories(CategoriesVo categoriesVo) {
		return imageRepository.findByCategories(CategorieMapper.toEntity(categoriesVo)).stream().map(ImageMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<ImagesVo> findByName(String name) {
		return imageRepository.findByName(name).stream().map(ImageMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<ImagesVo> findBySlider(SlidersVo slidersVo) {
		return imageRepository.findBySliders(SliderMapper.toEntity(slidersVo)).stream().map(ImageMapper::toVO).collect(Collectors.toList());
	}

}
