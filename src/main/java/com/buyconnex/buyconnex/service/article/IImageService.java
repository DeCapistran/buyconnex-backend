package com.buyconnex.buyconnex.service.article;

import java.util.List;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.article.Categories;
import com.buyconnex.buyconnex.entity.article.Images;
import com.buyconnex.buyconnex.entity.visuel.Sliders;

public interface IImageService {

	public Images findById(Long id);
	public Images saveImages(Images images);
	public void deleteImages(Images images);
	public Images updateImages(Images images);
	public List<Images> findByArticles(Articles articles);
	public List<Images> findByCategories(Categories categories);
	public List<Images> findByName(String name);
	public List<Images> findBySlider(Sliders sliders);
}
