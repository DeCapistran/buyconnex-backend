package com.buyconnex.buyconnex.vo.article;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticlesVo {
	private Long id;
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
	private ImagesVo images;
	private TagsVo tags;
	private AvisVo avis;
}
