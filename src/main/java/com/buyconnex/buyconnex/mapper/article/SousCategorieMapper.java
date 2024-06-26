package com.buyconnex.buyconnex.mapper.article;

import java.util.stream.Collectors;

import com.buyconnex.buyconnex.entity.article.SousCategories;
import com.buyconnex.buyconnex.mapper.achat.CouponMapper;
import com.buyconnex.buyconnex.vo.article.SousCategoriesVo;

public class SousCategorieMapper {

	public static SousCategoriesVo toVO(SousCategories sousCategories) {
		SousCategoriesVo sousCategoriesVo = new SousCategoriesVo();
		sousCategoriesVo.setLibelle(sousCategories.getLibelle());
		sousCategoriesVo.setCategories(CategorieMapper.toVO(sousCategories.getCategories()));
		sousCategoriesVo.setCoupons(sousCategories.getCoupons().stream().map(CouponMapper::toVO).collect(Collectors.toSet()));
		
		return sousCategoriesVo;
	}
	
	public static SousCategories toEntity(SousCategoriesVo sousCategoriesVo) {
		SousCategories sousCategories = new SousCategories();
		sousCategories.setLibelle(sousCategoriesVo.getLibelle());
		sousCategories.setCategories(CategorieMapper.toEntity(sousCategoriesVo.getCategories()));
		sousCategories.setCoupons(sousCategoriesVo.getCoupons().stream().map(CouponMapper::toEntity).collect(Collectors.toSet()));
		
		return sousCategories;
	}
	
	public static void updetEntityFromVO(SousCategoriesVo sousCategoriesVo, SousCategories sousCategories) {
		
		sousCategories.setLibelle(sousCategoriesVo.getLibelle());
		sousCategories.setCategories(CategorieMapper.toEntity(sousCategoriesVo.getCategories()));
		sousCategories.setCoupons(sousCategoriesVo.getCoupons().stream().map(CouponMapper::toEntity).collect(Collectors.toSet()));
		
	}
}
