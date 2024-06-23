package com.buyconnex.buyconnex.service.achat;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.achat.CouponsVo;
import com.buyconnex.buyconnex.vo.article.SousCategoriesVo;

public interface ICouponService {

	public Optional<CouponsVo> findById(Long id);
	public CouponsVo saveCoupons(CouponsVo couponsVo);
	public void deleteCoupons(CouponsVo couponsVo);
	public CouponsVo updateCoupons(Long id, CouponsVo couponsVo);
	public CouponsVo findByCodeCoupons(String codeCoupon);
	public List<CouponsVo> findBySousCategories(SousCategoriesVo sousCategoriesVo);
}
