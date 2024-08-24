package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.article.Boutiques;
import com.buyconnex.buyconnex.mapper.article.ArticleMapper;
import com.buyconnex.buyconnex.mapper.article.BoutiqueMapper;
import com.buyconnex.buyconnex.mapper.article.ImageMapper;
import com.buyconnex.buyconnex.repository.article.BoutiqueRepository;
import com.buyconnex.buyconnex.vo.article.ArticlesVo;
import com.buyconnex.buyconnex.vo.article.BoutiquesVo;
import com.buyconnex.buyconnex.vo.article.ImagesVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BoutiqueService implements IBoutiqueService {

	@Autowired
	BoutiqueRepository boutiqueRepository;
	
	@Override
	public Optional<BoutiquesVo> findById(Long id) {
		return boutiqueRepository.findById(id).map(BoutiqueMapper::toVO);
	}

	@Override
	public BoutiquesVo saveBoutique(BoutiquesVo boutiquesVo) {
		Boutiques boutiques = BoutiqueMapper.toEntity(boutiquesVo);
		Boutiques boutiquesSave = boutiqueRepository.save(boutiques);
		return BoutiqueMapper.toVO(boutiquesSave);
	}
	
	@Override
	public void deleteBoutique(BoutiquesVo boutiquesVo) {
		Boutiques boutiques = BoutiqueMapper.toEntity(boutiquesVo);
		boutiqueRepository.delete(boutiques);
	}

	@Override
	public BoutiquesVo updateBoutique(Long id, BoutiquesVo boutiquesVo) {
		return boutiqueRepository.findById(id).map(boutique -> {
			BoutiqueMapper.updateEntityFromVO(boutiquesVo, boutique);
			Boutiques boutiques = boutiqueRepository.save(boutique);
			return BoutiqueMapper.toVO(boutiques);
		}).orElse(null);
	}

	@Override
	public List<BoutiquesVo> findByArticle(ArticlesVo articlesVo) {
		return boutiqueRepository.findByArticles(ArticleMapper.toEntity(articlesVo)).stream().map(BoutiqueMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<BoutiquesVo> findByNom(String nom) {
		return boutiqueRepository.findByNom(nom).stream().map(BoutiqueMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<BoutiquesVo> findAll() {
		return boutiqueRepository.findAll().stream().map(BoutiqueMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public void deleteBoutiqueById(Long id) {
		boutiqueRepository.deleteById(id);
	}

	@Override
	public List<BoutiquesVo> findByImages(ImagesVo imagesVo) {
		return boutiqueRepository.findByImages(ImageMapper.toEntity(imagesVo)).stream().map(BoutiqueMapper::toVO).collect(Collectors.toList());
	}
}
