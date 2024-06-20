package com.buyconnex.buyconnex.vo.article;

import java.util.Set;

import com.buyconnex.buyconnex.entity.article.Articles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TagsVo {

	private String nom;
	private String description;
	private Set<Articles> articles;
}
