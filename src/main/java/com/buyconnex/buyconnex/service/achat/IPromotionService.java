package com.buyconnex.buyconnex.service.achat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.achat.PromotionsVo;

public interface IPromotionService {

	public List<PromotionsVo> findAll();
	public Optional<PromotionsVo> findById(Long id);
	public PromotionsVo savePromotions(PromotionsVo promotionsVo);
	public void deletePromotions(PromotionsVo promotionsVo);
	public void deletePromotionsById(Long id);
	public PromotionsVo updatePromotions(Long id, PromotionsVo promotionsVo);
	public List<PromotionsVo> findByDateFin(Date date);
	public List<PromotionsVo> findByDateDebut(Date date);
	public List<PromotionsVo> findByPourcentage(int pourcentage);
	public List<PromotionsVo> findByLibelle(String libelle);
	public List<PromotionsVo> findByDescription(String description);
}
