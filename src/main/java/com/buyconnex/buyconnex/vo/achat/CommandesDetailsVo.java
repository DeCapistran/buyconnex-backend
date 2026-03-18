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
public class CommandesDetailsVo {

	private Long id;
	private Long idCommande;
	private ArticlesVo articlesVo;
	private int quantite;
}
