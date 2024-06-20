package com.buyconnex.buyconnex.mapper.article;

import com.buyconnex.buyconnex.entity.article.Images;
import com.buyconnex.buyconnex.vo.article.ImagesVo;

public class ImageMapper {

	public static ImagesVo toVO(Images images) {
		ImagesVo imagesVo = new ImagesVo();
		imagesVo.setName(images.getName());
		imagesVo.setType(images.getType());
		imagesVo.setImage(images.getImage());
		imagesVo.setArticles(images.getArticles());
		imagesVo.setCategories(images.getCategories());
		imagesVo.setSliders(images.getSliders());
		imagesVo.setCouleurs(images.getCouleurs());
		
		return imagesVo;
	}
	
	public static Images toEntity(ImagesVo imagesVo) {
		Images images = new Images();
		images.setName(imagesVo.getName());
		images.setType(imagesVo.getType());
		images.setImage(imagesVo.getImage());
		images.setArticles(imagesVo.getArticles());
		images.setCategories(imagesVo.getCategories());
		images.setSliders(imagesVo.getSliders());
		images.setCouleurs(imagesVo.getCouleurs());
		
		return images;
	}
}
