package com.buyconnex.buyconnex.mapper.article;

import com.buyconnex.buyconnex.entity.article.TagsArticles;
import com.buyconnex.buyconnex.vo.article.TagsArticlesVo;

public class TagArticleMapper {

	public static TagsArticlesVo toVO(TagsArticles tagsArticles) {
		if(tagsArticles == null) return null;
		TagsArticlesVo tagsArticlesVo = new TagsArticlesVo();
		tagsArticlesVo.setArticlesVo(ArticleMapper.toVO(tagsArticles.getArticles()));
		tagsArticlesVo.setTagsVo(TagMapper.toVO(tagsArticles.getTags()));
		
		return tagsArticlesVo;
	}
	
	public static TagsArticles toEntity(TagsArticlesVo tagsArticlesVo) {
		if(tagsArticlesVo == null) return null;
		TagsArticles tagsArticles = new TagsArticles();
		tagsArticles.setArticles(ArticleMapper.toEntity(tagsArticlesVo.getArticlesVo()));
		tagsArticles.setTags(TagMapper.toEntity(tagsArticlesVo.getTagsVo()));
		
		return tagsArticles;
	}
	
	public static void updateEntityfromVo(TagsArticles tagsArticles, TagsArticlesVo tagsArticlesVo) {
		tagsArticles.setArticles(ArticleMapper.toEntity(tagsArticlesVo.getArticlesVo()));
		tagsArticles.setTags(TagMapper.toEntity(tagsArticlesVo.getTagsVo()));
	}
}
