package com.buyconnex.buyconnex.service.article;

import java.util.List;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.article.Avis;
import com.buyconnex.buyconnex.entity.user.Users;

public interface IAvisService {

	public Avis findById(Long id);
	public Avis saveAvis(Avis avis);
	public void deleteAvis(Avis avis);
	public Avis updateAvis(Avis avis);
	public List<Avis> findByArticles(Articles articles);
	public List<Avis> findByEtoile(int etoile);
	public List<Avis> findByUsers(Users users);
}
