package com.buyconnex.buyconnex.vo.article;

import java.util.Set;

import com.buyconnex.buyconnex.entity.article.Images;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CouleursVo {

	private String couleur;
	private String codeCouleur;
	private Set<Images> images;
}
