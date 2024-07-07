package com.buyconnex.buyconnex.vo.article;

import java.time.LocalDateTime;
import java.util.Set;

import com.buyconnex.buyconnex.vo.achat.CommandesDetailsVo;
import com.buyconnex.buyconnex.vo.achat.CommandesVo;
import com.buyconnex.buyconnex.vo.achat.PromotionsDetailsVo;
import com.buyconnex.buyconnex.vo.achat.PromotionsVo;
import com.buyconnex.buyconnex.vo.client.PaniersDetailsVo;
import com.buyconnex.buyconnex.vo.client.PaniersVo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticlesVo {
	private Long idArticle;
	private String sku;
	private String imgPath;
	private String title; 
	private Long prix;
	private int quantite;
	private String description;
	private String composition;
	private LocalDateTime dateAjout;
	private CategoriesVo categories;
	private MarquesVo marques;
	private BoutiquesVo boutiques;
	private StatusArticlesVo statusArticles;
	private Set<PromotionsVo> promotions;
	private Set<TagsVo> tags;
	private Set<CommandesVo> commandes;
	private Set<PaniersVo> paniers;
	private Set<AvisVo> avis;
	private ImagesVo images;
	private Set<CommandesDetailsVo> commandesDetails;
	private Set<PromotionsDetailsVo> promotionsDetails;
	private Set<PaniersDetailsVo> paniersDetails;
	private Set<ArticlesImagesVo> articlesImages;
	private Set<TagsArticlesVo> tagsArticles;
}
