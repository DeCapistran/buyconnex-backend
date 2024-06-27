package com.buyconnex.buyconnex.service.client;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.article.ArticlesVo;
import com.buyconnex.buyconnex.vo.client.PaniersDetailsVo;
import com.buyconnex.buyconnex.vo.client.PaniersVo;

public interface IPanierDetailService {

	public Optional<PaniersDetailsVo> findById(Long id);
	public PaniersDetailsVo savePaniersDetails(PaniersDetailsVo paniersDetailsVo);
	public void deletePaniersDetails(PaniersDetailsVo paniersDetailsVo);
	public PaniersDetailsVo updatePaniersDetails(PaniersDetailsVo paniersDetailsVo);
	public List<PaniersDetailsVo> findByPaniers(PaniersVo paniersVo);
	public List<PaniersDetailsVo> findByArticles(ArticlesVo articlesVo);
}
