package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.article.SousCategories;
import com.buyconnex.buyconnex.mapper.achat.CouponMapper;
import com.buyconnex.buyconnex.mapper.article.CategorieMapper;
import com.buyconnex.buyconnex.mapper.article.SousCategorieMapper;
import com.buyconnex.buyconnex.repository.article.SousCategorieRepository;
import com.buyconnex.buyconnex.vo.achat.CouponsVo;
import com.buyconnex.buyconnex.vo.article.CategoriesVo;
import com.buyconnex.buyconnex.vo.article.SousCategoriesVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SousCategorieService implements ISousCategorieService{

	@Autowired
	SousCategorieRepository sousCategorieRepository;
	
	@Override
	public Optional<SousCategoriesVo> findById(Long id) {
		return sousCategorieRepository.findById(id).map(SousCategorieMapper::toVO);
	}

	@Override
	public SousCategoriesVo saveSousCategorie(SousCategoriesVo sousCategoriesVo) {
		SousCategories sousCategories = SousCategorieMapper.toEntity(sousCategoriesVo);
		SousCategories sousCategoriesSave = sousCategorieRepository.save(sousCategories);
		return SousCategorieMapper.toVO(sousCategoriesSave);
	}

	@Override
	public void deleteSousCategorie(SousCategoriesVo sousCategoriesVo) {
		SousCategories sousCategories = SousCategorieMapper.toEntity(sousCategoriesVo);
		sousCategorieRepository.delete(sousCategories);
	}

	@Override
	public SousCategoriesVo updateSousCategorie(Long id, SousCategoriesVo sousCategoriesVo) {
		return sousCategorieRepository.findById(id).map(sousCategorie -> {
			SousCategorieMapper.updetEntityFromVO(sousCategoriesVo, sousCategorie);
			SousCategories sousCategoriesUpdated = sousCategorieRepository.save(sousCategorie);
			return SousCategorieMapper.toVO(sousCategoriesUpdated);
		}).orElse(null);
	}

	@Override
	public List<SousCategoriesVo> findByCategories(CategoriesVo categoriesVo) {
		return sousCategorieRepository.findByCategories(CategorieMapper.toEntity(categoriesVo)).stream().map(SousCategorieMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<SousCategoriesVo> findByCoupons(CouponsVo couponsVo) {
		return sousCategorieRepository.findByCoupons(CouponMapper.toEntity(couponsVo)).stream().map(SousCategorieMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<SousCategoriesVo> findByLibelle(String libelle) {
		return sousCategorieRepository.findByLibelle(libelle).stream().map(SousCategorieMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<SousCategoriesVo> findAll() {
		return sousCategorieRepository.findAll().stream().map(SousCategorieMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public void deleteSousCategorieById(Long id) {
		sousCategorieRepository.deleteById(id);
	}

}
