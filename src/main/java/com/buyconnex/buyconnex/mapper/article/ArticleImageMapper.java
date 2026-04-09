package com.buyconnex.buyconnex.mapper.article;

import com.buyconnex.buyconnex.entity.article.ArticlesImages;
import com.buyconnex.buyconnex.vo.article.ArticlesImagesVo;

public class ArticleImageMapper {

	public static ArticlesImagesVo toVO(ArticlesImages articlesImages) {
		if(articlesImages == null) return null;
		ArticlesImagesVo articlesImagesVo = new ArticlesImagesVo();
		articlesImagesVo.setId(articlesImages.getArticle_image_id());
		articlesImagesVo.setArticlesVo(ArticleMapper.toVO(articlesImages.getArticles()));
		articlesImagesVo.setImagesVo(ImageMapper.toVO(articlesImages.getImages()));
		articlesImagesVo.setCouleursVo(CouleurMapper.toVO(articlesImages.getCouleurs()));
		
		return articlesImagesVo;
	}
	
	public static ArticlesImages toEntity(ArticlesImagesVo articlesImagesVo) {
		if(articlesImagesVo == null) return null;
		ArticlesImages articlesImages = new ArticlesImages();
		articlesImages.setArticles(ArticleMapper.toEntity(articlesImagesVo.getArticlesVo()));
		articlesImages.setImages(ImageMapper.toEntity(articlesImagesVo.getImagesVo()));
		articlesImages.setCouleurs(CouleurMapper.toEntity(articlesImagesVo.getCouleursVo()));
		
		return articlesImages;
	}
	
	public static void updateEntityfromVo(ArticlesImages articlesImages, ArticlesImagesVo articlesImagesVo) {
		articlesImages.setArticles(ArticleMapper.toEntity(articlesImagesVo.getArticlesVo()));
		articlesImages.setImages(ImageMapper.toEntity(articlesImagesVo.getImagesVo()));
		articlesImages.setCouleurs(CouleurMapper.toEntity(articlesImagesVo.getCouleursVo()));
	}
}
