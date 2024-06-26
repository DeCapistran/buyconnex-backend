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
public class TagsVo {
	private Long id;
	private String nom;
	private String description;
	private Set<ArticlesVo> articles;
}
