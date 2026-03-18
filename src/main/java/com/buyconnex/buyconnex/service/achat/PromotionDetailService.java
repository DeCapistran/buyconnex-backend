package com.buyconnex.buyconnex.service.achat;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.mapper.achat.PromotionDetailMapper;
import com.buyconnex.buyconnex.repository.achat.PromotionDetailRepository;
import com.buyconnex.buyconnex.vo.achat.PromotionsDetailsVo;
import com.buyconnex.buyconnex.vo.achat.PromotionsVo;
import com.buyconnex.buyconnex.vo.article.ArticlesVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PromotionDetailService implements IPromotionDetailService {

	@Autowired
	PromotionDetailRepository promotionDetailRepository;
	
	@Override
	public Optional<PromotionsDetailsVo> findById(Long id) {
		return promotionDetailRepository.findById(id).map(PromotionDetailMapper::toVO);
	}

	@Override
	public PromotionsDetailsVo savePromotionsDetails(PromotionsDetailsVo promotionsDetailsVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePromotionsDetails(PromotionsDetailsVo promotionsDetailsVo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PromotionsDetailsVo updatePromotionsDetails(Long id, PromotionsDetailsVo promotionsDetailsVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PromotionsDetailsVo> findByPromotions(PromotionsVo promotionsVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PromotionsDetailsVo> findByArticles(ArticlesVo articlesVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PromotionsDetailsVo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePromotionDetailsById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
