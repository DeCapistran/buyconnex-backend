package com.buyconnex.buyconnex.vo.article;

import java.util.Set;

import com.buyconnex.buyconnex.entity.article.ArticlesImages;
import com.buyconnex.buyconnex.entity.article.Boutiques;
import com.buyconnex.buyconnex.entity.article.Categories;
import com.buyconnex.buyconnex.entity.article.Images;
import com.buyconnex.buyconnex.entity.visuel.Sliders;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImagesVo {
	private Long id;
	private String name;
	private String type;
	private String url;
	private byte[] image;
}
