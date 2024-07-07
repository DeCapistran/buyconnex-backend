package com.buyconnex.buyconnex.controller.achat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buyconnex.buyconnex.service.achat.CouponService;
import com.buyconnex.buyconnex.vo.achat.CouponsVo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/coupons")
@CrossOrigin(origins = "*")
public class CouponRestController {

	@Autowired
	CouponService couponService;
	
	@GetMapping
	public ResponseEntity<List<CouponsVo>> findAllCoupons() {
		List<CouponsVo> coupon = couponService.findAll();
		return ResponseEntity.ok(coupon);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CouponsVo> findCouponById(@PathVariable Long id) {
		CouponsVo coupon = couponService.findById(id).isPresent() ? couponService.findById(id).get() : null;
		return coupon != null ? ResponseEntity.ok(coupon) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<CouponsVo> saveCoupon(@Valid @RequestBody CouponsVo couponsVo) {
		CouponsVo coupon = couponService.saveCoupons(couponsVo);
		return ResponseEntity.status(201).body(coupon);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CouponsVo> updateCoupon(@PathVariable Long id, @Valid @RequestBody CouponsVo couponsVo) {
		CouponsVo coupon = couponService.updateCoupons(id, couponsVo);
		return coupon != null ? ResponseEntity.ok(coupon) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdCoupon(@PathVariable Long id) {
		couponService.deleteCouponsById(id);
		return ResponseEntity.noContent().build();
	}
}
