package com.buyconnex.buyconnex.service.article;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.article.ArticlesImages;
import com.buyconnex.buyconnex.entity.article.Images;
import com.buyconnex.buyconnex.mapper.article.ArticleImageMapper;
import com.buyconnex.buyconnex.mapper.article.BoutiqueMapper;
import com.buyconnex.buyconnex.mapper.article.CategorieMapper;
import com.buyconnex.buyconnex.mapper.article.ImageMapper;
import com.buyconnex.buyconnex.mapper.visuel.SliderMapper;
import com.buyconnex.buyconnex.repository.article.ArticleImageRepository;
import com.buyconnex.buyconnex.repository.article.ImageRepository;
import com.buyconnex.buyconnex.vo.article.ArticlesImagesVo;
import com.buyconnex.buyconnex.vo.article.BoutiquesVo;
import com.buyconnex.buyconnex.vo.article.CategoriesVo;
import com.buyconnex.buyconnex.vo.article.ImagesVo;
import com.buyconnex.buyconnex.vo.visuel.SlidersVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ImageService implements IImageService {

	@Autowired
	ImageRepository imageRepository;
	
	@Autowired
	ArticleImageRepository articleImageRepository;
	
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
	
	@Override
	public ImagesVo getImageDetail(Long id) throws IOException {
		final Optional<Images> dbImage = imageRepository.findById(id);
		return ImageMapper.toVO(Images.builder().image_id(dbImage.get().getImage_id()).name(dbImage.get().getName()).type(dbImage.get().getType()).image(dbImage.get().getImage()).build());
	}
	
	@Override
	public ResponseEntity<byte[]> getImage(Long id) throws IOException {
		final Optional<Images> dbImage = imageRepository.findById(id);
		return ResponseEntity.ok().contentType(MediaType.valueOf(dbImage.get().getType())).body(dbImage.get().getImage());
	}

	@Override
	public List<ImagesVo> findAll() {
		return imageRepository.findAll().stream().map(ImageMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public void deleteImagesById(Long id) {
		imageRepository.deleteById(id);
	}
	
	@Override
	public List<ArticlesImagesVo> uploadImageArticle(List<MultipartFile> files, Long id) throws IOException {
		
		List<ArticlesImagesVo> saveImage = new ArrayList<>();
		Articles articles = new Articles();
		articles.setArticle_id(id);
		
		for (MultipartFile file : files) {
            Images image = Images.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(file.getBytes())
                .build();
            
            Images savedImages = imageRepository.save(image);
            
            ArticlesImages articlesImages = new ArticlesImages();
            articlesImages.setArticles(articles);
            articlesImages.setImages(savedImages);
            
            saveImage.add(ArticleImageMapper.toVO(articleImageRepository.save(articlesImages)));
        }
		return saveImage;
	}

	@Override
	public List<ImagesVo> uploadImage(List<MultipartFile> files) throws IOException {
		List<ImagesVo> saveImages = new ArrayList<>();
		
		for (MultipartFile file : files) {
            Images image = Images.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(file.getBytes())
                .build();
            
            saveImages.add(ImageMapper.toVO(imageRepository.save(image)));
        }
		return saveImages;
	}

	@Override
	public List<ImagesVo> findByBoutique(BoutiquesVo boutiquesVo) {
		return imageRepository.findByBoutiques(BoutiqueMapper.toEntity(boutiquesVo)).stream().map(ImageMapper::toVO).collect(Collectors.toList());
	}

}
