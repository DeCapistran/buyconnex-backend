package com.buyconnex.buyconnex.service.achat;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.achat.Coupons;
import com.buyconnex.buyconnex.mapper.achat.CouponMapper;
import com.buyconnex.buyconnex.mapper.article.SousCategorieMapper;
import com.buyconnex.buyconnex.repository.achat.CouponRepository;
import com.buyconnex.buyconnex.vo.achat.CouponsVo;
import com.buyconnex.buyconnex.vo.article.SousCategoriesVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CouponService implements ICouponService {

	@Autowired
	CouponRepository couponRepository;
	
	@Override
	public Optional<CouponsVo> findById(Long id) {
		return couponRepository.findById(id).map(CouponMapper::toVO);
	}

	@Override
	public CouponsVo saveCoupons(CouponsVo couponsVo) {
		Coupons coupons = CouponMapper.toEntity(couponsVo);
		Coupons couponsSave = couponRepository.save(coupons);
		return CouponMapper.toVO(couponsSave);
	}

	@Override
	public void deleteCoupons(CouponsVo couponsVo) {
		Coupons coupons = CouponMapper.toEntity(couponsVo);
		couponRepository.delete(coupons);
	}

	@Override
	public CouponsVo updateCoupons(Long id, CouponsVo couponsVo) {
		return couponRepository.findById(id).map(coupon -> {
			CouponMapper.updateEntityFromVO(couponsVo, coupon);
			Coupons couponUpdated = couponRepository.save(coupon);
			return CouponMapper.toVO(couponUpdated);
		}).orElse(null);
	}

	@Override
	public CouponsVo findByCodeCoupons(String codeCoupon) {
		return CouponMapper.toVO(couponRepository.findByCodeCoupon(codeCoupon));
	}

	@Override
	public List<CouponsVo> findBySousCategories(SousCategoriesVo sousCategoriesVo) {
		
		return couponRepository.findBySousCategories(SousCategorieMapper.toEntity(sousCategoriesVo)).stream().map(CouponMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<CouponsVo> findAll() {
		return couponRepository.findAll().stream().map(CouponMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public void deletCouponsById(Long id) {
		couponRepository.deleteById(id);
	}

}
