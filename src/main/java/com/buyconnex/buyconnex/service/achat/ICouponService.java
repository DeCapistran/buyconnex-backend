package com.buyconnex.buyconnex.service.achat;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.achat.CouponsVo;

public interface ICouponService {

	public Optional<CouponsVo> findById(Long id);
	public List<CouponsVo> findAll();
	public CouponsVo saveCoupons(CouponsVo couponsVo);
	public void deleteCoupons(CouponsVo couponsVo);
	public void deleteCouponsById(Long id);
	public CouponsVo updateCoupons(Long id, CouponsVo couponsVo);
	public CouponsVo findByCodeCoupons(String codeCoupon);
}
