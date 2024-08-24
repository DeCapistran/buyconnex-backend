package com.buyconnex.buyconnex.mapper.article;

import com.buyconnex.buyconnex.entity.article.Boutiques;
import com.buyconnex.buyconnex.entity.article.Images;
import com.buyconnex.buyconnex.vo.article.BoutiquesVo;
import com.buyconnex.buyconnex.vo.article.ImagesVo;

public class BoutiqueMapper {

	public static BoutiquesVo toVO(Boutiques boutiques) {
		BoutiquesVo boutiquesVo = new BoutiquesVo();
		boutiquesVo.setId(boutiques.getBoutique_id());
		boutiquesVo.setNom(boutiques.getNom());
		boutiquesVo.setEmail(boutiques.getEmail());
		boutiquesVo.setTelephone(boutiques.getTelephone());
		
		Images images = boutiques.getImages();
	    if (images != null) {
	        ImagesVo imageVo = new ImagesVo();
	        imageVo.setId(images.getImage_id());
	        imageVo.setName(images.getName());
	        imageVo.setUrl(images.getUrl());
	        imageVo.setType(images.getType());
	        boutiquesVo.setImages(imageVo);
	    }
		
		return boutiquesVo;
	}
	
	public static Boutiques toEntity(BoutiquesVo boutiquesVo) {
		Boutiques boutiques = new Boutiques();
		boutiques.setBoutique_id(boutiquesVo.getId());
		boutiques.setNom(boutiquesVo.getNom());
		boutiques.setEmail(boutiquesVo.getEmail());
		boutiques.setTelephone(boutiquesVo.getTelephone());
		
		ImagesVo imagesVo = boutiquesVo.getImages();
	    if (imagesVo != null) {
	        Images image = new Images();
	        image.setImage_id(imagesVo.getId());
	        image.setName(imagesVo.getName());
	        image.setUrl(imagesVo.getUrl());
	        image.setType(imagesVo.getType());
	        boutiques.setImages(image);
	    }
		
		return boutiques;
	}
	
	public static void updateEntityFromVO(BoutiquesVo boutiquesVo, Boutiques boutiques) {
		
		boutiques.setNom(boutiquesVo.getNom());
		boutiques.setNom(boutiquesVo.getNom());
		boutiques.setEmail(boutiquesVo.getEmail());
		boutiques.setTelephone(boutiquesVo.getTelephone());
		
		ImagesVo imagesVo = boutiquesVo.getImages();
	    if (imagesVo != null) {
	        Images image = new Images();
	        image.setImage_id(imagesVo.getId());
	        image.setName(imagesVo.getName());
	        image.setUrl(imagesVo.getUrl());
	        image.setType(imagesVo.getType());
	        boutiques.setImages(image);
	    }
	}
}
