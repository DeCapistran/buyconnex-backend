package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.article.Tags;
import com.buyconnex.buyconnex.repository.article.TagRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TagService implements ITagService {

	@Autowired
	TagRepository tagRepository;
	
	@Override
	public Optional<Tags> findById(Long id) {
		return tagRepository.findById(id);
	}

	@Override
	public Tags saveTags(Tags tags) {
		return tagRepository.save(tags);
	}

	@Override
	public void deleteTags(Tags tags) {
		tagRepository.delete(tags);
	}

	@Override
	public Tags updateTags(Tags tags) {
		return tagRepository.save(tags);
	}

	@Override
	public List<Tags> findByArticles(Articles articles) {
		return tagRepository.findByArticles(articles);
	}
	
	@Override
	public List<Tags> findByNom(String nom) {
		return tagRepository.findByNom(nom);
	}

}
