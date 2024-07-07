package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.article.ArticlesImagesVo;
import com.buyconnex.buyconnex.vo.article.ArticlesVo;
import com.buyconnex.buyconnex.vo.article.ImagesVo;

public interface IArticleImageService {

	public Optional<ArticlesImagesVo> findById(Long id);
	public List<ArticlesImagesVo> findAll();
	public ArticlesImagesVo saveArticlesImages(ArticlesImagesVo articlesImagesVo);
	public void deleteArticlesImages(ArticlesImagesVo articlesImagesVo);
	public void deleteArticlesImagesById(Long id);
	public ArticlesImagesVo updateArticlesImages(Long id, ArticlesImagesVo articlesImagesVo);
	public List<ArticlesImagesVo> findByCouleurs(ArticlesVo articlesVo);
	public List<ArticlesImagesVo> findByImages(ImagesVo imagesVo);
}
