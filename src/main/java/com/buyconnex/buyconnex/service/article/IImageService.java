package com.buyconnex.buyconnex.service.article;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.buyconnex.buyconnex.vo.article.ArticlesVo;
import com.buyconnex.buyconnex.vo.article.CategoriesVo;
import com.buyconnex.buyconnex.vo.article.ImagesVo;
import com.buyconnex.buyconnex.vo.visuel.SlidersVo;

public interface IImageService {

	public Optional<ImagesVo> findById(Long id);
	public List<ImagesVo> findAll();
	public ImagesVo saveImages(ImagesVo imagesVo);
	public void deleteImages(ImagesVo imagesVo);
	public void deleteImagesById(Long id);
	public ImagesVo updateImages(Long id, ImagesVo imagesVo);
	public List<ImagesVo> findByArticles(ArticlesVo articlesVo);
	public List<ImagesVo> findByCategories(CategoriesVo categoriesVo);
	public List<ImagesVo> findByName(String name);
	public List<ImagesVo> findBySlider(SlidersVo slidersVo);
	public ImagesVo uploadImage(MultipartFile file) throws IOException;
	public ImagesVo getImageDetail(Long id) throws IOException;
	public ResponseEntity<byte[]> getImage(Long id) throws IOException;
	//public ImagesVo uploadImageArticle(MultipartFile file, Long id) throws IOException;
	
}
	