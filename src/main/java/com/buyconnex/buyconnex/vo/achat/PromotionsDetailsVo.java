package com.buyconnex.buyconnex.vo.achat;

import com.buyconnex.buyconnex.vo.article.ArticlesVo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PromotionsDetailsVo {

	private Long id;
	private PromotionsVo promotionsVo;
	private ArticlesVo articlesVo;
}
