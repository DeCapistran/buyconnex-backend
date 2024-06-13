package com.buyconnex.buyconnex.service.achat;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.achat.Coupons;
import com.buyconnex.buyconnex.entity.article.SousCategories;
import com.buyconnex.buyconnex.repository.achat.CouponRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CouponService implements ICouponService {

	@Autowired
	CouponRepository couponRepository;
	
	@Override
	public Optional<Coupons> findById(Long id) {
		return couponRepository.findById(id);
	}

	@Override
	public Coupons saveCoupons(Coupons coupons) {
		return couponRepository.save(coupons);
	}

	@Override
	public void deleteCoupons(Coupons coupons) {
		couponRepository.delete(coupons);
	}

	@Override
	public Coupons updateCoupons(Coupons coupons) {
		return couponRepository.save(coupons);
	}

	@Override
	public Coupons findByCodeCoupons(String codeCoupon) {
		return couponRepository.findByCodeCoupon(codeCoupon);
	}

	@Override
	public List<Coupons> findBySousCategories(SousCategories sousCategories) {
		return couponRepository.findBySousCategories(sousCategories);
	}

}
