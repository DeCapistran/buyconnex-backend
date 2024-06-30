package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.article.Categories;
import com.buyconnex.buyconnex.mapper.article.ArticleMapper;
import com.buyconnex.buyconnex.mapper.article.CategorieMapper;
import com.buyconnex.buyconnex.mapper.article.ImageMapper;
import com.buyconnex.buyconnex.mapper.article.SousCategorieMapper;
import com.buyconnex.buyconnex.repository.article.CategorieRepository;
import com.buyconnex.buyconnex.vo.article.ArticlesVo;
import com.buyconnex.buyconnex.vo.article.CategoriesVo;
import com.buyconnex.buyconnex.vo.article.ImagesVo;
import com.buyconnex.buyconnex.vo.article.SousCategoriesVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategorieService implements ICategorieService{

	CategorieRepository categorieRepository;
	
	@Override
	public Optional<CategoriesVo> findById(Long id) {
		return categorieRepository.findById(id).map(CategorieMapper::toVO);
	}

	@Override
	public CategoriesVo saveCategorie(CategoriesVo categoriesVo) {
		Categories categories = CategorieMapper.toEntity(categoriesVo);
		Categories categoriesSave = categorieRepository.save(categories);
		return CategorieMapper.toVO(categoriesSave);
	}

	@Override
	public void deleteCategorie(CategoriesVo categoriesVo) {
		Categories categories = CategorieMapper.toEntity(categoriesVo);
		categorieRepository.delete(categories);
	}

	@Override
	public CategoriesVo updateCategorie(Long id, CategoriesVo categoriesVo) {
		return categorieRepository.findById(id).map(categorie -> {
			CategorieMapper.updateEntityFromVO(categoriesVo, categorie);
			Categories categoriesUpdated = categorieRepository.save(categorie);
			return CategorieMapper.toVO(categoriesUpdated);
		}).orElse(null);
	}

	@Override
	public List<CategoriesVo> findByArticles(ArticlesVo articlesVo) {
		return categorieRepository.findByArticles(ArticleMapper.toEntity(articlesVo)).stream().map(CategorieMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<CategoriesVo> findByImages(ImagesVo imagesVo) {
		return categorieRepository.findByImages(ImageMapper.toEntity(imagesVo)).stream().map(CategorieMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<CategoriesVo> findByLibelle(String libelle) {
		return categorieRepository.findByLibelle(libelle).stream().map(CategorieMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<CategoriesVo> findBySousCategories(SousCategoriesVo sousCategoriesVo) {
		return categorieRepository.findBySousCategorie(SousCategorieMapper.toEntity(sousCategoriesVo)).stream().map(CategorieMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<CategoriesVo> findAll() {
		return categorieRepository.findAll().stream().map(CategorieMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public void deleteCategorieById(Long id) {
		categorieRepository.deleteById(id);
	}

}
