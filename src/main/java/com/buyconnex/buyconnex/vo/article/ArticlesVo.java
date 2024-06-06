package com.buyconnex.buyconnex.vo.article;

import java.util.Date;

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

	private String sku;
	private String imgPath;
	private String title; 
	private Long prix;
	private int quantite;
	private String description;
	private String composition;
	private Date dateAjout;
	private Categories categories;
	private Marques marques;
	private Boutiques boutiques;
	private StatusArticles statusArticles;
	private Promotions promotions;
	private Tags tags;
	private Commandes commandes;
	private Paniers paniers;
	private Avis avis;
	private Images images;
}
