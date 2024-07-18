package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.article.ArticlesVo;
import com.buyconnex.buyconnex.vo.article.BoutiquesVo;
import com.buyconnex.buyconnex.vo.article.ImagesVo;

public interface IBoutiqueService {

	public Optional<BoutiquesVo> findById(Long id);
	public List<BoutiquesVo> findAll();
	public BoutiquesVo saveBoutique(BoutiquesVo boutiquesVo);
	public void deleteBoutique(BoutiquesVo boutiquesVo);
	public void deleteBoutiqueById(Long id);
	public BoutiquesVo updateBoutique(Long id, BoutiquesVo boutiquesVo);
	public List<BoutiquesVo> findByArticle(ArticlesVo articlesVo);
	public List<BoutiquesVo> findByNom(String nom);
	public List<BoutiquesVo> findByImg(String img);
	public List<BoutiquesVo> findByImages(ImagesVo imagesVo);
}
