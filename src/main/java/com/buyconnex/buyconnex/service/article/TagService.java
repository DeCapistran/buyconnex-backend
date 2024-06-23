package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.article.Tags;
import com.buyconnex.buyconnex.mapper.article.ArticleMapper;
import com.buyconnex.buyconnex.mapper.article.TagMapper;
import com.buyconnex.buyconnex.repository.article.TagRepository;
import com.buyconnex.buyconnex.vo.article.ArticlesVo;
import com.buyconnex.buyconnex.vo.article.TagsVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TagService implements ITagService {

	@Autowired
	TagRepository tagRepository;
	
	@Override
	public Optional<TagsVo> findById(Long id) {
		return tagRepository.findById(id).map(TagMapper::toVO);
	}

	@Override
	public TagsVo saveTags(TagsVo tagsVo) {
		Tags tags = TagMapper.toEntity(tagsVo);
		Tags tagsSave = tagRepository.save(tags);
		return TagMapper.toVO(tagsSave);
	}

	@Override
	public void deleteTags(TagsVo tagsVo) {
		Tags tags = TagMapper.toEntity(tagsVo);
		tagRepository.delete(tags);
	}

	@Override
	public TagsVo updateTags(Long id, TagsVo tagsVo) {
		return tagRepository.findById(id).map(tag -> {
			TagMapper.updateEntityFromVO(tagsVo, tag);
			Tags tagsUpdated = tagRepository.save(tag);
			return TagMapper.toVO(tagsUpdated);
		}).orElse(null);
	}

	@Override
	public List<TagsVo> findByArticles(ArticlesVo articlesVo) {
		return tagRepository.findByArticles(ArticleMapper.toEntity(articlesVo)).stream().map(TagMapper::toVO).collect(Collectors.toList());
	}
	
	@Override
	public List<TagsVo> findByNom(String nom) {
		return tagRepository.findByNom(nom).stream().map(TagMapper::toVO).collect(Collectors.toList());
	}

}
