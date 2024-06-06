package com.buyconnex.buyconnex.vo.client;

import java.util.Date;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.user.Users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaniersVo {

	private Date datePanier;
	private Users users;
	private Articles articles;
}
