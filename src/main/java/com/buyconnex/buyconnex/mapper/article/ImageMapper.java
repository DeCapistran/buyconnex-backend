package com.buyconnex.buyconnex.mapper.article;

import com.buyconnex.buyconnex.entity.article.Images;
import com.buyconnex.buyconnex.vo.article.ImagesVo;

public class ImageMapper {
	public static ImagesVo toVO(Images image) {
        if (image == null) {
            return null;
        }
        return ImagesVo.builder()
                       .id(image.getImage_id())
                       .name(image.getName())
                       .type(image.getType())
                       .image(image.getImage())
                       .url(image.getUrl())
                       .couleur(CouleurMapper.toVO(image.getCouleurs()))
                       .build();
    }

    public static Images toEntity(ImagesVo imagesVo) {
        if (imagesVo == null) {
            return null;
        }
        return Images.builder()
                     .name(imagesVo.getName())
                     .type(imagesVo.getType())
                     .image(imagesVo.getImage())
                     .url(imagesVo.getUrl())
                     .couleurs(CouleurMapper.toEntity(imagesVo.getCouleur()))
                     .build();
    }
}
