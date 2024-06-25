package com.buyconnex.buyconnex.vo.article;

import java.time.LocalDateTime;
import java.util.Set;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.entity.achat.Promotions;
import com.buyconnex.buyconnex.entity.article.Avis;
import com.buyconnex.buyconnex.entity.article.Boutiques;
import com.buyconnex.buyconnex.entity.article.Categories;
import com.buyconnex.buyconnex.entity.article.Images;
import com.buyconnex.buyconnex.entity.article.Marques;
import com.buyconnex.buyconnex.entity.article.StatusArticles;
import com.buyconnex.buyconnex.entity.article.Tags;
import com.buyconnex.buyconnex.entity.client.Paniers;

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
	private Categories categories;
	private Marques marques;
	private Boutiques boutiques;
	private StatusArticles statusArticles;
	private Set<Promotions> promotions;
	private Set<Tags> tags;
	private Set<Commandes> commandes;
	private Set<Paniers> paniers;
	private Set<Avis> avis;
	private Images images;
}
