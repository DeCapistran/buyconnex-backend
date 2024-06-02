package com.buyconnex.buyconnex.service.achat;

import java.util.List;

import com.buyconnex.buyconnex.entity.achat.Coupons;
import com.buyconnex.buyconnex.entity.article.SousCategories;

public interface ICouponService {

	public Coupons findById(Long id);
	public Coupons saveCoupons(Coupons coupons);
	public void deleteCoupons(Coupons coupons);
	public Coupons updateCoupons(Coupons coupons);
	public Coupons findByCodeCoupons(String codeCoupon);
	public List<Coupons> findBySousCategories(SousCategories sousCategories);
}
