package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.vo.article.CouleursImagesVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CouleurImageService implements ICouleurImageService{

	@Override
	public Optional<CouleursImagesVo> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<CouleursImagesVo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CouleursImagesVo saveCouleursImages(CouleursImagesVo couleursImagesVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCouleursImages(CouleursImagesVo couleursImagesVo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCouleursImagesById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CouleursImagesVo updateCouleursImages(Long id, CouleursImagesVo couleursImagesVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CouleursImagesVo> findByCouleurs(CouleursImagesVo couleursImagesVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CouleursImagesVo> findByImages(CouleursImagesVo couleursImagesVo) {
		// TODO Auto-generated method stub
		return null;
	}

}
