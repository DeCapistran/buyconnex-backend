package com.buyconnex.buyconnex.mapper.achat;

import com.buyconnex.buyconnex.entity.achat.Coupons;
import com.buyconnex.buyconnex.mapper.article.SousCategorieMapper;
import com.buyconnex.buyconnex.vo.achat.CouponsVo;

public class CouponMapper {

	public static CouponsVo toVO(Coupons coupons) {
		
		CouponsVo couponsVo = new CouponsVo();
		couponsVo.setLibelle(coupons.getLibelle());
		couponsVo.setLogo(coupons.getLogo());
		couponsVo.setCodeCoupon(coupons.getCodeCoupon());
		couponsVo.setDateCreation(coupons.getDateCreation());
		couponsVo.setDateDebut(coupons.getDateDebut());
		couponsVo.setDateFin(coupons.getDateFin());
		couponsVo.setPourcentage(coupons.getPourcentage());
		couponsVo.setMontantMinimum(coupons.getMontantMinimum());
		couponsVo.setSousCategories(SousCategorieMapper.toVO(coupons.getSousCategories()));
		
		return couponsVo;
	}
	
	public static Coupons toEntity(CouponsVo couponsVo) {
		
		Coupons coupons = new Coupons();
		coupons.setLibelle(couponsVo.getLibelle());
		coupons.setLogo(couponsVo.getLogo());
		coupons.setCodeCoupon(couponsVo.getCodeCoupon());
		coupons.setDateCreation(couponsVo.getDateCreation());
		coupons.setDateDebut(couponsVo.getDateDebut());
		coupons.setDateFin(couponsVo.getDateFin());
		coupons.setPourcentage(couponsVo.getPourcentage());
		coupons.setMontantMinimum(couponsVo.getMontantMinimum());
		coupons.setSousCategories(SousCategorieMapper.toEntity(couponsVo.getSousCategories()));
		
		return coupons;
	}
	
	public static void updateEntityFromVO(CouponsVo couponsVo, Coupons coupons) {
		
		coupons.setLibelle(couponsVo.getLibelle());
		coupons.setLogo(couponsVo.getLogo());
		coupons.setCodeCoupon(couponsVo.getCodeCoupon());
		coupons.setDateCreation(couponsVo.getDateCreation());
		coupons.setDateDebut(couponsVo.getDateDebut());
		coupons.setDateFin(couponsVo.getDateFin());
		coupons.setPourcentage(couponsVo.getPourcentage());
		coupons.setMontantMinimum(couponsVo.getMontantMinimum());
		coupons.setSousCategories(SousCategorieMapper.toEntity(couponsVo.getSousCategories()));
	}
}
