package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.vo.article.ArticlesVo;
import com.buyconnex.buyconnex.vo.article.TagsArticlesVo;
import com.buyconnex.buyconnex.vo.article.TagsVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TagArticleService implements ITagArticleService {

	@Override
	public Optional<TagsArticlesVo> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<TagsArticlesVo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TagsArticlesVo saveTagsArticles(TagsArticlesVo tagsArticlesVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTagsArticles(TagsArticlesVo tagsArticlesVo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTagsArticlesById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TagsArticlesVo updateTagsArticles(Long id, TagsArticlesVo tagsArticlesVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TagsArticlesVo> findByArticles(ArticlesVo ArticlesVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TagsArticlesVo> findByTags(TagsVo tagsVo) {
		// TODO Auto-generated method stub
		return null;
	}

}
