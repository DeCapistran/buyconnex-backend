package com.buyconnex.buyconnex.mapper.article;

import com.buyconnex.buyconnex.entity.article.Images;
import com.buyconnex.buyconnex.vo.article.ImagesVo;

public class ImageMapper {
	public static ImagesVo toVO(Images image) {
        if (image == null) {
            return null;
        }
        return ImagesVo.builder()
                       .name(image.getName())
                       .type(image.getType())
                       .image(image.getImage())
                       .url(image.getUrl())
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
                     .build();
    }
}
