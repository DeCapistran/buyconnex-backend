package com.buyconnex.buyconnex.service.achat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.achat.CouponsVo;

public interface ICouponService {

	public Optional<CouponsVo> findById(Long id);
	public List<CouponsVo> findAll();
	public CouponsVo saveCoupons(String libelle, String code, Date dateDebut, Date dateFin, BigDecimal montantMin, BigDecimal pourcentage);
	public void deleteCoupons(CouponsVo couponsVo);
	public void deleteCouponsById(Long id);
	public CouponsVo updateCoupons(Long id, CouponsVo couponsVo);
	public CouponsVo findByCodeCoupons(String codeCoupon);
	public boolean existsByCodeCoupon(String code);
	public boolean existsByCodeCouponAndNotId(String code, Long id);
	public boolean existsByLibelleCoupon(String libelle);
	public boolean existsByLibelleCouponAndNotId(String libelle, Long id);
}
