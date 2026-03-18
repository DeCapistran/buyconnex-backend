package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.article.ArticlesVo;
import com.buyconnex.buyconnex.vo.article.AvisVo;
import com.buyconnex.buyconnex.vo.user.UsersVo;

public interface IAvisService {

	public Optional<AvisVo> findById(Long id);
	public List<AvisVo> findAll();
	public AvisVo saveAvis(AvisVo avisVo);
	public void deleteAvis(AvisVo avisVo);
	public void deleteAvisById(Long id);
	public AvisVo updateAvis(Long id, AvisVo avisVo);
	public List<AvisVo> findByArticles(ArticlesVo articlesVo);
	public List<AvisVo> findByEtoile(int etoile);
	public List<AvisVo> findByUsers(UsersVo usersVo);
}
