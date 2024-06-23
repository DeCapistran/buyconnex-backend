package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.achat.CouponsVo;
import com.buyconnex.buyconnex.vo.article.CategoriesVo;
import com.buyconnex.buyconnex.vo.article.SousCategoriesVo;

public interface ISousCategorieService {

	public Optional<SousCategoriesVo> findById(Long id);
	public SousCategoriesVo saveSousCategorie(SousCategoriesVo sousCategoriesVo);
	public void deleteSousCategorie(SousCategoriesVo sousCategoriesVo);
	public SousCategoriesVo updateSousCategorie(Long id, SousCategoriesVo sousCategoriesVo);
	public List<SousCategoriesVo> findByCategories(CategoriesVo categoriesVo);
	public List<SousCategoriesVo> findByCoupons(CouponsVo couponsVo);
	public List<SousCategoriesVo> findByLibelle(String libelle);
}
