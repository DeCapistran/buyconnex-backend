package com.buyconnex.buyconnex.vo.article;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CouleursVo {
	private Long id;
	private String couleur;
	private String codeCouleur;
	private Set<ImagesVo> images;
	private Set<CouleursImagesVo> couleursImages;
}
