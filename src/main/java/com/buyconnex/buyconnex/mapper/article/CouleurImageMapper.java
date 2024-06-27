package com.buyconnex.buyconnex.mapper.article;

import com.buyconnex.buyconnex.entity.article.CouleursImages;
import com.buyconnex.buyconnex.vo.article.CouleursImagesVo;

public class CouleurImageMapper {

	public static CouleursImagesVo toVO(CouleursImages couleursImages) {
		CouleursImagesVo couleursImagesVo = new CouleursImagesVo();
		couleursImagesVo.setCouleursVo(CouleurMapper.toVO(couleursImages.getCouleurs()));
		couleursImagesVo.setImagesVo(ImageMapper.toVO(couleursImages.getImages()));
		
		return couleursImagesVo;
	}
	
	public static CouleursImages toEntity(CouleursImagesVo couleursImagesVo) {
		CouleursImages couleursImages = new CouleursImages();
		couleursImages.setCouleurs(CouleurMapper.toEntity(couleursImagesVo.getCouleursVo()));
		couleursImages.setImages(ImageMapper.toEntity(couleursImagesVo.getImagesVo()));
		
		return couleursImages;
	}
	
	public static void updateEntityfromVo(CouleursImages couleursImages, CouleursImagesVo couleursImagesVo) {
		couleursImages.setCouleurs(CouleurMapper.toEntity(couleursImagesVo.getCouleursVo()));
		couleursImages.setImages(ImageMapper.toEntity(couleursImagesVo.getImagesVo()));
	}
}
