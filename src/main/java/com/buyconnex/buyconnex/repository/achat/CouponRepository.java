package com.buyconnex.buyconnex.repository.achat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.buyconnex.buyconnex.entity.achat.Coupons;



public interface CouponRepository extends JpaRepository<Coupons, Long> {
  
	Coupons findByCodeCoupon(String code);
	
	@Query("SELECT COUNT(c) > 0 FROM Coupons c WHERE LOWER(c.codeCoupon) = LOWER(:code) AND c.coupon_id != :id")
    boolean existsByCodeCouponAndNotId(@Param("code") String code, @Param("id") Long id);
	
	@Query("SELECT COUNT(c) > 0 FROM Coupons c WHERE LOWER(c.libelle) = LOWER(:libelle) AND c.coupon_id != :id")
    boolean existsByLibelleCouponAndNotId(@Param("libelle") String libelle, @Param("id") Long id);
	
	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN TRUE ELSE FALSE END FROM Coupons c WHERE LOWER(c.libelle) = LOWER(:libelle)")
	boolean existsByLibelleCouponIgnoreCase(@Param("libelle") String libelle);
	
	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN TRUE ELSE FALSE END FROM Coupons c WHERE LOWER(c.codeCoupon) = LOWER(:code)")
	boolean existsByCodeCouponIgnoreCase(@Param("code") String code);


}
