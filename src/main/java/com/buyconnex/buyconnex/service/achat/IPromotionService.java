package com.buyconnex.buyconnex.service.achat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.achat.PromotionsVo;

public interface IPromotionService {

	public List<PromotionsVo> findAll();
	public Optional<PromotionsVo> findById(Long id);
	public PromotionsVo savePromotions(String libelle, int pourcentage, Date dateDebut, Date dateFin, String description, List<Long> articlesIds);
	public void deletePromotions(PromotionsVo promotionsVo);
	public void deletePromotionsById(Long id);
	public PromotionsVo updatePromotions(Long id, String libelle, int pourcentage, Date dateDebut, Date dateFin, String description, List<Long> articlesIds);
	public List<PromotionsVo> findByDateFin(Date date);
	public List<PromotionsVo> findByDateDebut(Date date);
	public List<PromotionsVo> findByPourcentage(int pourcentage);
	public List<PromotionsVo> findByLibelle(String libelle);
	public List<PromotionsVo> findByDescription(String description);
}
