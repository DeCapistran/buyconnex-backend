package com.buyconnex.buyconnex.vo.article;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoutiquesVo {
	private Long id;
	private String nom;
	private String email;
	private String telephone;
	private ImagesVo images;
}
