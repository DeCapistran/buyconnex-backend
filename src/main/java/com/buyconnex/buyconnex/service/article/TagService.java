package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.article.Tags;
import com.buyconnex.buyconnex.exception.NameException;
import com.buyconnex.buyconnex.mapper.article.TagMapper;
import com.buyconnex.buyconnex.repository.article.TagRepository;
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
		// Vérification si le libelle existe déjà
	    if (existsByNomTag(tagsVo.getNom())) {
	        throw new NameException("Le libelle du tag existe déjà.");
	    }
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
			if (existsByNomTagAndNotId(tagsVo.getNom(), id)) {
	            throw new NameException("Le libellé existe déjà pour un autre coupon.");
	        }
			TagMapper.updateEntityFromVO(tagsVo, tag);
			Tags tagsUpdated = tagRepository.save(tag);
			return TagMapper.toVO(tagsUpdated);
		}).orElse(null);
	}
	
	@Override
	public List<TagsVo> findByNom(String nom) {
		return tagRepository.findByNom(nom).stream().map(TagMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<TagsVo> findAll() {
		return tagRepository.findAll().stream().map(TagMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public void deleteTagsById(Long id) {
		tagRepository.deleteById(id);
	}

	@Override
	public boolean existsByNomTag(String nom) {
		return tagRepository.existsByNomTagIgnoreCase(nom);
	}

	@Override
	public boolean existsByNomTagAndNotId(String nom, Long id) {
		return tagRepository.existsByNomTagAndNotId(nom, id);
	}

}
