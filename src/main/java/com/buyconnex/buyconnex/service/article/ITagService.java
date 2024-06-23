package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.article.ArticlesVo;
import com.buyconnex.buyconnex.vo.article.TagsVo;

public interface ITagService {

	public Optional<TagsVo> findById(Long id);
	public TagsVo saveTags(TagsVo tagsVo);
	public void deleteTags(TagsVo tagsVo);
	public TagsVo updateTags(Long id, TagsVo tagsVo);
	public List<TagsVo> findByArticles(ArticlesVo articlesVo);
	public List<TagsVo> findByNom(String nom);
}
