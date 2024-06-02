package com.buyconnex.buyconnex.service.article;

import java.util.List;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.article.Boutiques;

public interface IBoutiqueService {

	public Boutiques findById(Long id);
	public Boutiques saveBoutique(Boutiques boutiques);
	public void deleteBoutique(Boutiques boutiques);
	public Boutiques updateBoutique(Boutiques boutiques);
	public List<Boutiques> findByArticle(Articles articles);
	public List<Boutiques> findByNom(String nom);
	public List<Boutiques> findByimg(String img);
}
