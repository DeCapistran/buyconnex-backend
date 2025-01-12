package com.buyconnex.buyconnex.service.achat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.achat.Coupons;
import com.buyconnex.buyconnex.exception.NameException;
import com.buyconnex.buyconnex.mapper.achat.CouponMapper;
import com.buyconnex.buyconnex.repository.achat.CouponRepository;
import com.buyconnex.buyconnex.vo.achat.CouponsVo;

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
	public CouponsVo saveCoupons(String libelle, String code, Date dateDebut, Date dateFin, BigDecimal montantMin, BigDecimal pourcentage) {
		if(existsByCodeCoupon(code)) {
			throw new NameException("Le code existe déjà.");
		} 
		if(existsByLibelleCoupon(libelle)) {
			throw new NameException("Le libellé existe déjà.");
		}
		Coupons coupons = new Coupons();
		coupons.setLibelle(libelle);
		coupons.setCodeCoupon(code);
		coupons.setDateCreation(LocalDateTime.now());
		coupons.setDateDebut(dateDebut);
		coupons.setDateFin(dateFin);
		coupons.setMontantMinimum(montantMin);
		coupons.setPourcentage(pourcentage);
		
		Coupons couponSaved = couponRepository.save(coupons);
		
		CouponsVo couponsVo = new CouponsVo();
		couponsVo.setLibelle(couponSaved.getLibelle());
		couponsVo.setCodeCoupon(couponSaved.getCodeCoupon());
		couponsVo.setDateCreation(couponSaved.getDateCreation());
		couponsVo.setDateDebut(couponSaved.getDateDebut());
		couponsVo.setDateFin(couponSaved.getDateFin());
		couponsVo.setMontantMinimum(couponSaved.getMontantMinimum());
		couponsVo.setPourcentage(couponSaved.getPourcentage());
		
		return couponsVo;
	}

	@Override
	public void deleteCoupons(CouponsVo couponsVo) {
		Coupons coupons = CouponMapper.toEntity(couponsVo);
		couponRepository.delete(coupons);
	}

	@Override
	public CouponsVo updateCoupons(Long id, CouponsVo couponsVo) {
			return couponRepository.findById(id).map(coupon -> {
				// Vérification si le code existe déjà pour un autre coupon
		        if (couponRepository.existsByCodeCouponAndNotId(couponsVo.getCodeCoupon(), id)) {
		            throw new NameException("Le code existe déjà pour un autre coupon.");
		        }
		        if (existsByLibelleCouponAndNotId(couponsVo.getLibelle(), id)) {
		            throw new NameException("Le libellé existe déjà pour un autre coupon.");
		        }
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
	public List<CouponsVo> findAll() {
		return couponRepository.findAll().stream().map(CouponMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public void deleteCouponsById(Long id) {
		couponRepository.deleteById(id);
	}
	
	@Override
	public boolean existsByCodeCoupon(String code) {
	    return couponRepository.existsByCodeCouponIgnoreCase(code);
	}

	@Override
	public boolean existsByCodeCouponAndNotId(String code, Long id) {
		return couponRepository.existsByCodeCouponAndNotId(code, id);
	}

	@Override
	public boolean existsByLibelleCoupon(String libelle) {
		return couponRepository.existsByLibelleCouponIgnoreCase(libelle);
	}

	@Override
	public boolean existsByLibelleCouponAndNotId(String libelle, Long id) {
		return couponRepository.existsByLibelleCouponAndNotId(libelle, id);
	}

}
