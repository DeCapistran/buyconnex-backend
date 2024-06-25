package com.buyconnex.buyconnex.vo.visuel;

import com.buyconnex.buyconnex.entity.article.Images;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SlidersVo {
	private Long id;
	private String title;
	private Images images;
}
