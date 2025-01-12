package com.buyconnex.buyconnex.controller.achat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.buyconnex.buyconnex.service.achat.CouponService;
import com.buyconnex.buyconnex.vo.achat.CouponsVo;

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
	public ResponseEntity<CouponsVo> saveCoupon(@RequestParam("libelle") String libelle, @RequestParam("codeCoupon") String codeCoupon, @RequestParam("dateDebut") Date dateDebut,
												@RequestParam("dateFin") Date dateFin, @RequestParam("montantMinimum") BigDecimal montantMin, @RequestParam("pourcentage") BigDecimal pourcentage) {
		CouponsVo coupon = couponService.saveCoupons(libelle, codeCoupon, dateDebut, dateFin, montantMin, pourcentage);
		return ResponseEntity.status(201).body(coupon);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CouponsVo> updateCoupon(@RequestParam("id") Long id, @RequestParam("libelle") String libelle, @RequestParam("codeCoupon") String codeCoupon, @RequestParam("dateDebut") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut,
			@RequestParam("dateFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin, @RequestParam("montantMinimum") BigDecimal montantMin, @RequestParam("pourcentage") BigDecimal pourcentage) {
		CouponsVo couponsVo = new CouponsVo();
		couponsVo.setLibelle(libelle);
		couponsVo.setCodeCoupon(codeCoupon);
		couponsVo.setDateDebut(dateDebut);
		couponsVo.setDateFin(dateFin);
		couponsVo.setMontantMinimum(montantMin);
		couponsVo.setPourcentage(pourcentage);
		couponsVo.setDateCreation(LocalDateTime.now());
		CouponsVo coupon = couponService.updateCoupons(id, couponsVo);
		return coupon != null ? ResponseEntity.ok(coupon) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdCoupon(@PathVariable Long id) {
		couponService.deleteCouponsById(id);
		return ResponseEntity.noContent().build();
	}
}
