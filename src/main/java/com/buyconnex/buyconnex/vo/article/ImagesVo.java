package com.buyconnex.buyconnex.vo.article;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.article.Categories;
import com.buyconnex.buyconnex.entity.article.Couleurs;
import com.buyconnex.buyconnex.entity.visuel.Sliders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImagesVo {

	private String name;
	private String type;
	private byte[] image;
	private Articles articles;
	private Categories categories;
	private Sliders sliders;
	private Couleurs couleurs;
}
