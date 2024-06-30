package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.article.Marques;
import com.buyconnex.buyconnex.mapper.article.ArticleMapper;
import com.buyconnex.buyconnex.mapper.article.MarqueMapper;
import com.buyconnex.buyconnex.repository.article.MarqueRepository;
import com.buyconnex.buyconnex.vo.article.ArticlesVo;
import com.buyconnex.buyconnex.vo.article.MarquesVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MarqueService implements IMarqueService {

	@Autowired
	MarqueRepository marqueRepository;
	
	@Override
	public Optional<MarquesVo> findById(Long id) {
		return marqueRepository.findById(id).map(MarqueMapper::toVO);
	}

	@Override
	public MarquesVo saveMarques(MarquesVo marquesVo) {
		Marques marques = MarqueMapper.toEntity(marquesVo);
		Marques marquesSave = marqueRepository.save(marques);
		return MarqueMapper.toVO(marquesSave);
	}

	@Override
	public void deleteMarques(MarquesVo marquesVo) {
		Marques marques = MarqueMapper.toEntity(marquesVo);
		marqueRepository.delete(marques);
	}

	@Override
	public MarquesVo updateMarques(Long id, MarquesVo marquesVo) {
		return marqueRepository.findById(id).map(marque -> {
			MarqueMapper.updateEntityFromVO(marquesVo, marque);
			Marques marquesUpdated = marqueRepository.save(marque);
			return MarqueMapper.toVO(marquesUpdated);
		}).orElse(null);
	}

	@Override
	public List<MarquesVo> findByArticles(ArticlesVo articlesVo) {
		return marqueRepository.findByArticles(ArticleMapper.toEntity(articlesVo)).stream().map(MarqueMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<MarquesVo> findByImg(String img) {
		return marqueRepository.findByImg(img).stream().map(MarqueMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<MarquesVo> findByLibelle(String libelle) {
		return marqueRepository.findByLibelle(libelle).stream().map(MarqueMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<MarquesVo> findAll() {
		return marqueRepository.findAll().stream().map(MarqueMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public void deleteMarquesById(Long id) {
		marqueRepository.deleteById(id);
	}

}
