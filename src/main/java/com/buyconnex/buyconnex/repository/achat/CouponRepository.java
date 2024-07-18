package com.buyconnex.buyconnex.repository.achat;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.achat.Coupons;



public interface CouponRepository extends JpaRepository<Coupons, Long> {
  
	Coupons findByCodeCoupon(String code);
	//boolean existByCodeCoupon(String code);
}
