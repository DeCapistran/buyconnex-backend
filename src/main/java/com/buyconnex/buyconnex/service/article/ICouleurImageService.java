package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.article.CouleursImagesVo;

public interface ICouleurImageService {

	public Optional<CouleursImagesVo> findById(Long id);
	public CouleursImagesVo saveCouleursImages(CouleursImagesVo couleursImagesVo);
	public void deleteCouleursImages(CouleursImagesVo couleursImagesVo);
	public CouleursImagesVo updateCouleursImages(Long id, CouleursImagesVo couleursImagesVo);
	public List<CouleursImagesVo> findByCouleurs(CouleursImagesVo couleursImagesVo);
	public List<CouleursImagesVo> findByImages(CouleursImagesVo couleursImagesVo);
}
