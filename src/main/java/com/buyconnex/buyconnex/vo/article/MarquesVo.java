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
public class MarquesVo {
	private Long id;
	private String libelle;
	private String img;
	private Set<ArticlesVo> articles;
}
