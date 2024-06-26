package com.buyconnex.buyconnex.mapper.article;

import java.util.stream.Collectors;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.mapper.achat.CommandeMapper;
import com.buyconnex.buyconnex.mapper.achat.PromotionMapper;
import com.buyconnex.buyconnex.mapper.client.PanierMapper;
import com.buyconnex.buyconnex.vo.article.ArticlesVo;

public class ArticleMapper {

	public static ArticlesVo toVO(Articles articles) {
		ArticlesVo articlesVo = new ArticlesVo();
		articlesVo.setIdArticle(articles.getArticle_id());
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
		articlesVo.setStatusArticles(StatusArticleMapper.toVO(articles.getStatusArticles()));
		articlesVo.setPromotions(articles.getPromotions().stream().map(PromotionMapper::toVo).collect(Collectors.toSet()));
		articlesVo.setTags(articles.getTags().stream().map(TagMapper::toVO).collect(Collectors.toSet()));
		articlesVo.setCommandes(articles.getCommandes().stream().map(CommandeMapper::toVO).collect(Collectors.toSet()));
		articlesVo.setPaniers(articles.getPaniers().stream().map(PanierMapper::toVO).collect(Collectors.toSet()));
		articlesVo.setAvis(articles.getAvis().stream().map(AvisMapper::toVO).collect(Collectors.toSet()));
		articlesVo.setImages(ImageMapper.toVO(articles.getImages()));
		
		return articlesVo;
	}
	
	public static Articles toEntity(ArticlesVo articlesVo) {
		Articles articles = new Articles();
		articles.setArticle_id(articlesVo.getIdArticle());
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
		articles.setStatusArticles(StatusArticleMapper.toEntity(articlesVo.getStatusArticles()));
		articles.setPromotions(articlesVo.getPromotions().stream().map(PromotionMapper::toEntity).collect(Collectors.toSet()));
		articles.setTags(articlesVo.getTags().stream().map(TagMapper::toEntity).collect(Collectors.toSet()));
		articles.setCommandes(articlesVo.getCommandes().stream().map(CommandeMapper::toEntity).collect(Collectors.toSet()));
		articles.setPaniers(articlesVo.getPaniers().stream().map(PanierMapper::toEntity).collect(Collectors.toSet()));
		articles.setAvis(articlesVo.getAvis().stream().map(AvisMapper::toEntity).collect(Collectors.toSet()));
		articles.setImages(ImageMapper.toEntity(articlesVo.getImages()));
		
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
		articles.setStatusArticles(StatusArticleMapper.toEntity(articlesVo.getStatusArticles()));
		articles.setPromotions(articlesVo.getPromotions().stream().map(PromotionMapper::toEntity).collect(Collectors.toSet()));
		articles.setTags(articlesVo.getTags().stream().map(TagMapper::toEntity).collect(Collectors.toSet()));
		articles.setCommandes(articlesVo.getCommandes().stream().map(CommandeMapper::toEntity).collect(Collectors.toSet()));
		articles.setPaniers(articlesVo.getPaniers().stream().map(PanierMapper::toEntity).collect(Collectors.toSet()));
		articles.setAvis(articlesVo.getAvis().stream().map(AvisMapper::toEntity).collect(Collectors.toSet()));
		articles.setImages(ImageMapper.toEntity(articlesVo.getImages()));
	}
}
