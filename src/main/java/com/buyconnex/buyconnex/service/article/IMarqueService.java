package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.article.ArticlesVo;
import com.buyconnex.buyconnex.vo.article.MarquesVo;

public interface IMarqueService {

	public Optional<MarquesVo> findById(Long id);
	public MarquesVo saveMarques(MarquesVo marquesVo);
	public void deleteMarques(MarquesVo marquesVo);
	public MarquesVo updateMarques(Long id, MarquesVo marquesVo);
	public List<MarquesVo> findByArticles(ArticlesVo articlesVo);
	public List<MarquesVo> findByImg(String img);
	public List<MarquesVo> findByLibelle(String libelle);
}
