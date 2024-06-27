package com.buyconnex.buyconnex.vo.client;

import com.buyconnex.buyconnex.vo.article.ArticlesVo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaniersDetailsVo {

	private Long id;
	private PaniersVo paniersVo;
	private ArticlesVo articlesVo;
}
