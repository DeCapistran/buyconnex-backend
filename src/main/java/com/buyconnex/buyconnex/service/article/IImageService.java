package com.buyconnex.buyconnex.service.article;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.buyconnex.buyconnex.entity.article.Boutiques;
import com.buyconnex.buyconnex.vo.article.ArticlesImagesVo;
import com.buyconnex.buyconnex.vo.article.BoutiquesVo;
import com.buyconnex.buyconnex.vo.article.CategoriesVo;
import com.buyconnex.buyconnex.vo.article.ImagesVo;
import com.buyconnex.buyconnex.vo.visuel.SlidersVo;

public interface IImageService {

	public Optional<ImagesVo> findById(Long id);
	public List<ImagesVo> findAll();
	public ImagesVo saveImages(ImagesVo imagesVo);
	public void deleteImages(ImagesVo imagesVo);
	public void deleteImagesById(Long id);
	public List<ImagesVo> findByCategories(CategoriesVo categoriesVo);
	public List<ImagesVo> findByBoutique(BoutiquesVo boutiquesVo);
	public List<ImagesVo> findByName(String name);
	public List<ImagesVo> findBySlider(SlidersVo slidersVo);
	public List<ImagesVo> uploadImage(List<MultipartFile> file) throws IOException;
	public ImagesVo uploadImageSingle(MultipartFile file) throws IOException;
	public ImagesVo getImageDetail(Long id) throws IOException;
	public ResponseEntity<byte[]> getImage(Long id) throws IOException;
	public List<ArticlesImagesVo>uploadImageArticle(List<MultipartFile> file, Long id) throws IOException;
	public ImagesVo uploadImageBoutique(MultipartFile file, Boutiques boutiques) throws IOException;
	public BoutiquesVo uploadImageBoutique(MultipartFile file, String nom, String email, String telephone) throws IOException;
	public BoutiquesVo updateImageBoutique(Long id, MultipartFile file, String nom, String email, String telephone) throws IOException;
	public boolean deleteBoutique(Long boutiqueId) throws IOException;
}
	