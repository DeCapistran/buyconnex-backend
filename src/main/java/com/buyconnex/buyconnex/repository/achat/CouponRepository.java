package com.buyconnex.buyconnex.repository.achat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.achat.Coupons;
import com.buyconnex.buyconnex.entity.article.SousCategories;



public interface CouponRepository extends JpaRepository<Coupons, Long> {
  
	Coupons findByCodeCoupon(String code);
	List<Coupons> findBySousCategories(SousCategories sousCategories);
	//boolean existByCodeCoupon(String code);
}
