package com.buyconnex.buyconnex.vo.article;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImagesVo {
	private Long id;
	private String name;
	private String type;
	private String url;
	private byte[] image;
	private CouleursVo couleur;
}
