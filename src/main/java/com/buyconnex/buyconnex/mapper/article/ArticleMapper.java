package com.buyconnex.buyconnex.mapper.article;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.article.Images;
import com.buyconnex.buyconnex.vo.article.ArticlesVo;
import com.buyconnex.buyconnex.vo.article.ImagesVo;

public class ArticleMapper {

	public static ArticlesVo toVO(Articles articles) {
		if(articles == null) return null;
		ArticlesVo articlesVo = new ArticlesVo();
		articlesVo.setId(articles.getArticle_id());
		articlesVo.setSku(articles.getSku());
		articlesVo.setImgPath(articles.getImgPath());
		articlesVo.setTitle(articles.getTitle());
		articlesVo.setPrix(articles.getPrix());
		articlesVo.setQuantite(articles.getQuantite());
		articlesVo.setDescription(articles.getDescription());
		articlesVo.setComposition(articles.getComposition());
		articlesVo.setDateAjout(articles.getDateAjout());
		articlesVo.setCategories(CategorieMapper.toVO(articles.getCategories()));
		articlesVo.setMarques(MarqueMapper.toVO(articles.getMarques()));
		articlesVo.setBoutiques(BoutiqueMapper.toVO(articles.getBoutiques()));
		articlesVo.setTags(TagMapper.toVO(articles.getTags()));
		articlesVo.setStatusArticles(StatusArticleMapper.toVO(articles.getStatusArticles()));
		Images images = articles.getImages();
	    if (images != null) {
	        ImagesVo imageVo = new ImagesVo();
	        imageVo.setId(images.getImage_id());
	        imageVo.setName(images.getName());
	        imageVo.setUrl(images.getUrl());
	        imageVo.setType(images.getType());
	        articlesVo.setImages(imageVo);
	    }
	    
		return articlesVo;
	}
	
	public static Articles toEntity(ArticlesVo articlesVo) {
		if(articlesVo == null) return null;
		Articles articles = new Articles();
		articles.setArticle_id(articlesVo.getId());
		articles.setSku(articlesVo.getSku());
		articles.setImgPath(articlesVo.getImgPath());
		articles.setTitle(articlesVo.getTitle());
		articles.setPrix(articlesVo.getPrix());
		articles.setQuantite(articlesVo.getQuantite());
		articles.setDescription(articlesVo.getDescription());
		articles.setComposition(articlesVo.getComposition());
		articles.setDateAjout(articlesVo.getDateAjout());
		articles.setCategories(CategorieMapper.toEntity(articlesVo.getCategories()));
		articles.setMarques(MarqueMapper.toEntity(articlesVo.getMarques()));
		articles.setBoutiques(BoutiqueMapper.toEntity(articlesVo.getBoutiques()));
		articles.setTags(TagMapper.toEntity(articlesVo.getTags()));
		articles.setStatusArticles(StatusArticleMapper.toEntity(articlesVo.getStatusArticles()));
		ImagesVo imagesVo = articlesVo.getImages();
	    if (imagesVo != null) {
	        Images image = new Images();
	        image.setImage_id(imagesVo.getId());
	        image.setName(imagesVo.getName());
	        image.setUrl(imagesVo.getUrl());
	        image.setType(imagesVo.getType());
	        articles.setImages(image);
	    }
	    
		return articles;
	}
	
	public static void updateEntityFromVO(ArticlesVo articlesVo, Articles articles) {
		
		articles.setSku(articlesVo.getSku());
		articles.setImgPath(articlesVo.getImgPath());
		articles.setTitle(articlesVo.getTitle());
		articles.setPrix(articlesVo.getPrix());
		articles.setQuantite(articlesVo.getQuantite());
		articles.setDescription(articlesVo.getDescription());
		articles.setComposition(articlesVo.getComposition());
		articles.setDateAjout(articlesVo.getDateAjout());
		articles.setCategories(CategorieMapper.toEntity(articlesVo.getCategories()));
		articles.setMarques(MarqueMapper.toEntity(articlesVo.getMarques()));
		articles.setBoutiques(BoutiqueMapper.toEntity(articlesVo.getBoutiques()));
		articles.setTags(TagMapper.toEntity(articlesVo.getTags()));
		articles.setStatusArticles(StatusArticleMapper.toEntity(articlesVo.getStatusArticles()));
		ImagesVo imagesVo = articlesVo.getImages();
	    if (imagesVo != null) {
	        Images image = new Images();
	        image.setImage_id(imagesVo.getId());
	        image.setName(imagesVo.getName());
	        image.setUrl(imagesVo.getUrl());
	        image.setType(imagesVo.getType());
	        articles.setImages(image);
	    }
	    
	}
	
	public static ArticlesVo toVO_Simple(Articles article) {
	    if (article == null) return null;

	    ArticlesVo articleVo = new ArticlesVo();
	    articleVo.setId(article.getArticle_id());
	    articleVo.setTitle(article.getTitle());
	    articleVo.setDescription(article.getDescription());
	    articleVo.setQuantite(22);
	    Images images = article.getImages();
	    if (images != null) {
	        ImagesVo imageVo = new ImagesVo();
	        imageVo.setId(images.getImage_id());
	        imageVo.setName(images.getName());
	        imageVo.setUrl(images.getUrl());
	        imageVo.setType(images.getType());
	        articleVo.setImages(imageVo);
	    }
	    

	    // casser la récursion
	    articleVo.setAvis(null);

	    return articleVo;
	}
}
