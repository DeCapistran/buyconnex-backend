package com.buyconnex.buyconnex.mapper.article;

import java.util.stream.Collectors;

import com.buyconnex.buyconnex.entity.article.Images;
import com.buyconnex.buyconnex.mapper.visuel.SliderMapper;
import com.buyconnex.buyconnex.vo.article.ImagesVo;

public class ImageMapper {

	public static ImagesVo toVO(Images images) {
		ImagesVo imagesVo = new ImagesVo();
		imagesVo.setName(images.getName());
		imagesVo.setType(images.getType());
		imagesVo.setImage(images.getImage());
		imagesVo.setArticles(images.getArticles().stream().map(ArticleMapper::toVO).collect(Collectors.toSet()));
		imagesVo.setCategories(CategorieMapper.toVO(images.getCategories()));
		imagesVo.setSliders(SliderMapper.toVO(images.getSliders()));
		
		return imagesVo;
	}
	
	public static Images toEntity(ImagesVo imagesVo) {
		Images images = new Images();
		images.setName(imagesVo.getName());
		images.setType(imagesVo.getType());
		images.setImage(imagesVo.getImage());
		images.setArticles(imagesVo.getArticles().stream().map(ArticleMapper::toEntity).collect(Collectors.toSet()));
		images.setCategories(CategorieMapper.toEntity(imagesVo.getCategories()));
		images.setSliders(SliderMapper.toEntity(imagesVo.getSliders()));
		
		return images;
	}
	
	public static void updateEntityFromVO(ImagesVo imagesVo, Images images) {
		
		images.setName(imagesVo.getName());
		images.setType(imagesVo.getType());
		images.setImage(imagesVo.getImage());
		images.setArticles(imagesVo.getArticles().stream().map(ArticleMapper::toEntity).collect(Collectors.toSet()));
		images.setCategories(CategorieMapper.toEntity(imagesVo.getCategories()));
		images.setSliders(SliderMapper.toEntity(imagesVo.getSliders()));
		
	}
}
