package com.buyconnex.buyconnex.service.client;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.mapper.client.PanierDetailMapper;
import com.buyconnex.buyconnex.repository.client.PanierDetailRepository;
import com.buyconnex.buyconnex.vo.article.ArticlesVo;
import com.buyconnex.buyconnex.vo.client.PaniersDetailsVo;
import com.buyconnex.buyconnex.vo.client.PaniersVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PanierDetailService implements IPanierDetailService {

	@Autowired
	PanierDetailRepository panierDetailRepository;
	
	@Override
	public Optional<PaniersDetailsVo> findById(Long id) {
		return panierDetailRepository.findById(id).map(PanierDetailMapper::toVo);
	}

	@Override
	public PaniersDetailsVo savePaniersDetails(PaniersDetailsVo paniersDetailsVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePaniersDetails(PaniersDetailsVo paniersDetailsVo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PaniersDetailsVo updatePaniersDetails(Long id, PaniersDetailsVo paniersDetailsVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaniersDetailsVo> findByPaniers(PaniersVo paniersVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaniersDetailsVo> findByArticles(ArticlesVo articlesVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaniersDetailsVo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletepaniersDetailsById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
