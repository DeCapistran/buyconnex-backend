package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.article.ArticlesVo;
import com.buyconnex.buyconnex.vo.article.CategoriesVo;
import com.buyconnex.buyconnex.vo.article.ImagesVo;
import com.buyconnex.buyconnex.vo.visuel.SlidersVo;

public interface IImageService {

	public Optional<ImagesVo> findById(Long id);
	public ImagesVo saveImages(ImagesVo imagesVo);
	public void deleteImages(ImagesVo imagesVo);
	public ImagesVo updateImages(Long id, ImagesVo imagesVo);
	public List<ImagesVo> findByArticles(ArticlesVo articlesVo);
	public List<ImagesVo> findByCategories(CategoriesVo categoriesVo);
	public List<ImagesVo> findByName(String name);
	public List<ImagesVo> findBySlider(SlidersVo slidersVo);
}
