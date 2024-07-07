package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.vo.article.ArticlesImagesVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ArticleImageService implements IArticleImageService{

	@Override
	public Optional<ArticlesImagesVo> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<ArticlesImagesVo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticlesImagesVo> findByCouleurs(ArticlesImagesVo articlesImagesVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticlesImagesVo> findByImages(ArticlesImagesVo articlesImagesVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticlesImagesVo saveArticlesImages(ArticlesImagesVo articlesImagesVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteArticlesImages(ArticlesImagesVo articlesImagesVo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteArticlesImagesById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArticlesImagesVo updateArticlesImages(Long id, ArticlesImagesVo articlesImagesVo) {
		// TODO Auto-generated method stub
		return null;
	}

}
