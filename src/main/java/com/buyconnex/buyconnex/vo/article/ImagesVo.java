package com.buyconnex.buyconnex.vo.article;

import java.util.Set;

import com.buyconnex.buyconnex.vo.visuel.SlidersVo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImagesVo {
	private Long id;
	private String name;
	private String type;
	private byte[] image;
	private Set<ArticlesVo> articles;
	private CategoriesVo categories;
	private SlidersVo sliders;
	private Set<CouleursVo> couleurs;
	private Set<CouleursImagesVo> couleursImages;
}
