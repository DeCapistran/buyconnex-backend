package com.buyconnex.buyconnex.mapper.article;

import com.buyconnex.buyconnex.entity.article.Categories;
import com.buyconnex.buyconnex.entity.article.Images;
import com.buyconnex.buyconnex.vo.article.CategoriesVo;
import com.buyconnex.buyconnex.vo.article.ImagesVo;

public class CategorieMapper {

	public static CategoriesVo toVO(Categories categories) {
		CategoriesVo categoriesVo = new CategoriesVo();
		categoriesVo.setId(categories.getCategorie_id());
		categoriesVo.setLibelle(categories.getLibelle());
		Images images = categories.getImages();
	    if (images != null) {
	        ImagesVo imageVo = new ImagesVo();
	        imageVo.setId(images.getImage_id());
	        imageVo.setName(images.getName());
	        imageVo.setUrl(images.getUrl());
	        imageVo.setType(images.getType());
	        categoriesVo.setImages(imageVo);
	    }
		
		return categoriesVo;
	}
	
	public static Categories toEntity(CategoriesVo categoriesVo) {
		Categories categories = new Categories();
		categories.setCategorie_id(categoriesVo.getId());
		categories.setLibelle(categoriesVo.getLibelle());
		ImagesVo imagesVo = categoriesVo.getImages();
	    if (imagesVo != null) {
	        Images image = new Images();
	        image.setImage_id(imagesVo.getId());
	        image.setName(imagesVo.getName());
	        image.setUrl(imagesVo.getUrl());
	        image.setType(imagesVo.getType());
	        categories.setImages(image);
	    }
	    
		return categories;
	}
	
	public static void updateEntityFromVO(CategoriesVo categoriesVo, Categories categories) {
		categories.setCategorie_id(categoriesVo.getId());
		categories.setLibelle(categoriesVo.getLibelle());
		ImagesVo imagesVo = categoriesVo.getImages();
	    if (imagesVo != null) {
	        Images image = new Images();
	        image.setImage_id(imagesVo.getId());
	        image.setName(imagesVo.getName());
	        image.setUrl(imagesVo.getUrl());
	        image.setType(imagesVo.getType());
	        categories.setImages(image);
	    }
	}
}
