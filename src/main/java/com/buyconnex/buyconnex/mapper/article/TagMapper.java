package com.buyconnex.buyconnex.mapper.article;

import java.util.stream.Collectors;

import com.buyconnex.buyconnex.entity.article.Tags;
import com.buyconnex.buyconnex.vo.article.TagsVo;

public class TagMapper {

	public static TagsVo toVO(Tags tags) {
		TagsVo tagsVo = new TagsVo();
		tagsVo.setTagsArticles(tags.getTagsArticles().stream().map(TagArticleMapper::toVO).collect(Collectors.toSet()));
		tagsVo.setDescription(tags.getDescription());
		tagsVo.setNom(tags.getNom());
		
		return tagsVo;
	}
	
	public static Tags toEntity(TagsVo tagsVo) {
		Tags tags = new Tags();
		tags.setTagsArticles(tagsVo.getTagsArticles().stream().map(TagArticleMapper::toEntity).collect(Collectors.toSet()));
		tags.setDescription(tagsVo.getDescription());
		tags.setNom(tagsVo.getNom());
		
		return tags;
	}
	
	public static void updateEntityFromVO(TagsVo tagsVo, Tags tags) {
		
		tags.setTagsArticles(tagsVo.getTagsArticles().stream().map(TagArticleMapper::toEntity).collect(Collectors.toSet()));
		tags.setDescription(tagsVo.getDescription());
		tags.setNom(tagsVo.getNom());
	}
}
