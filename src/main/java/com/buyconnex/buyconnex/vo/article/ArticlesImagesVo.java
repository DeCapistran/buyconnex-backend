package com.buyconnex.buyconnex.vo.article;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticlesImagesVo {

	private Long id;
	private ArticlesVo articlesVo;
	private ImagesVo imagesVo;
}
