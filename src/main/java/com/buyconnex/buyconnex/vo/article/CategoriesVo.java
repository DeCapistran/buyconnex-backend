package com.buyconnex.buyconnex.vo.article;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriesVo {
	private Long id;
	private String libelle;
	private ImagesVo images;
}
