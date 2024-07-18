package com.buyconnex.buyconnex.mapper.article;

import java.util.stream.Collectors;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.mapper.achat.CommandeDetailMapper;
import com.buyconnex.buyconnex.mapper.achat.PromotionDetailMapper;
import com.buyconnex.buyconnex.mapper.client.PanierDetailMapper;
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
		articlesVo.setAvis(articles.getAvis().stream().map(AvisMapper::toVO).collect(Collectors.toSet()));
		articlesVo.setArticlesImages(articles.getArticlesImages().stream().map(ArticleImageMapper::toVO).collect(Collectors.toSet()));
		articlesVo.setCommandesDetails(articles.getCommandesDetails().stream().map(CommandeDetailMapper::toVO).collect(Collectors.toSet()));
		articlesVo.setPromotionsDetails(articles.getPromotionsDetails().stream().map(PromotionDetailMapper::toVO).collect(Collectors.toSet()));
		articlesVo.setPaniersDetails(articles.getPaniersDetails().stream().map(PanierDetailMapper::toVo).collect(Collectors.toSet()));
		articlesVo.setTagsArticles(articles.getTagsArticles().stream().map(TagArticleMapper::toVO).collect(Collectors.toSet()));
		
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
		articles.setAvis(articlesVo.getAvis().stream().map(AvisMapper::toEntity).collect(Collectors.toSet()));
		articles.setArticlesImages(articlesVo.getArticlesImages().stream().map(ArticleImageMapper::toEntity).collect(Collectors.toSet()));
		articles.setCommandesDetails(articlesVo.getCommandesDetails().stream().map(CommandeDetailMapper::toEntity).collect(Collectors.toSet()));
		articles.setPromotionsDetails(articlesVo.getPromotionsDetails().stream().map(PromotionDetailMapper::toEntity).collect(Collectors.toSet()));
		articles.setPaniersDetails(articlesVo.getPaniersDetails().stream().map(PanierDetailMapper::toEntity).collect(Collectors.toSet()));
		articles.setTagsArticles(articlesVo.getTagsArticles().stream().map(TagArticleMapper::toEntity).collect(Collectors.toSet()));
		
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
		articles.setAvis(articlesVo.getAvis().stream().map(AvisMapper::toEntity).collect(Collectors.toSet()));
		articles.setArticlesImages(articlesVo.getArticlesImages().stream().map(ArticleImageMapper::toEntity).collect(Collectors.toSet()));
		articles.setCommandesDetails(articlesVo.getCommandesDetails().stream().map(CommandeDetailMapper::toEntity).collect(Collectors.toSet()));
		articles.setPromotionsDetails(articlesVo.getPromotionsDetails().stream().map(PromotionDetailMapper::toEntity).collect(Collectors.toSet()));
		articles.setPaniersDetails(articlesVo.getPaniersDetails().stream().map(PanierDetailMapper::toEntity).collect(Collectors.toSet()));
		articles.setTagsArticles(articlesVo.getTagsArticles().stream().map(TagArticleMapper::toEntity).collect(Collectors.toSet()));
	}
}
