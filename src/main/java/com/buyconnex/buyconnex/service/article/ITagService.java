package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.article.TagsVo;

public interface ITagService {

	public Optional<TagsVo> findById(Long id);
	public List<TagsVo> findAll();
	public TagsVo saveTags(TagsVo tagsVo);
	public void deleteTags(TagsVo tagsVo);
	public void deleteTagsById(Long id);
	public TagsVo updateTags(Long id, TagsVo tagsVo);
	public List<TagsVo> findByNom(String nom);
	public boolean existsByNomTag(String nom);
	public boolean existsByNomTagAndNotId(String nom, Long id);
}
