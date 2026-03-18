package com.buyconnex.buyconnex.service.article;

import java.util.Optional;
import java.util.List;

import com.buyconnex.buyconnex.vo.article.ArticlesVo;
import com.buyconnex.buyconnex.vo.article.TagsArticlesVo;
import com.buyconnex.buyconnex.vo.article.TagsVo;

public interface ITagArticleService {

	public Optional<TagsArticlesVo> findById(Long id);
	public List <TagsArticlesVo> findAll();
	public TagsArticlesVo saveTagsArticles(TagsArticlesVo tagsArticlesVo);
	public void deleteTagsArticles(TagsArticlesVo tagsArticlesVo);
	public void deleteTagsArticlesById(Long id);
	public TagsArticlesVo updateTagsArticles(Long id, TagsArticlesVo tagsArticlesVo);
	public List<TagsArticlesVo> findByArticles(ArticlesVo ArticlesVo);
	public List<TagsArticlesVo> findByTags(TagsVo tagsVo);
}
