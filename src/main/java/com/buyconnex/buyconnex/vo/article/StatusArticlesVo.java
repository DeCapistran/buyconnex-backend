package com.buyconnex.buyconnex.vo.article;

import com.buyconnex.buyconnex.entity.article.Articles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatusArticlesVo {

	private String status;
	private String description;
	private Articles articles;
}
