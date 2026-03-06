package com.buyconnex.buyconnex.mapper.article;

import com.buyconnex.buyconnex.entity.article.Tags;
import com.buyconnex.buyconnex.vo.article.TagsVo;

public class TagMapper {

	public static TagsVo toVO(Tags tags) {
		if(tags == null) return null;
		TagsVo tagsVo = new TagsVo();
		tagsVo.setId(tags.getTags_id());
		tagsVo.setDescription(tags.getDescription());
		tagsVo.setNom(tags.getNom());
		
		return tagsVo;
	}
	
	public static Tags toEntity(TagsVo tagsVo) {
		if(tagsVo == null) return null;
		Tags tags = new Tags();
		tags.setTags_id(tagsVo.getId());
		tags.setDescription(tagsVo.getDescription());
		tags.setNom(tagsVo.getNom());
		
		return tags;
	}
	
	public static void updateEntityFromVO(TagsVo tagsVo, Tags tags) {
		tags.setDescription(tagsVo.getDescription());
		tags.setNom(tagsVo.getNom());
	}
}
