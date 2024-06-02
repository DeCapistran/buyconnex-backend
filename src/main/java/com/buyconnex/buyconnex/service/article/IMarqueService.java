package com.buyconnex.buyconnex.service.article;

import java.util.List;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.article.Marques;

public interface IMarqueService {

	public Marques findById(Long id);
	public Marques saveMarques(Marques marques);
	public void deleteMarques(Marques marques);
	public Marques updateMarques(Marques marques);
	public List<Marques> findByArticles(Articles articles);
	public List<Marques> findByImg(String img);
	public List<Marques> findByLibelle(String libelle);
}
