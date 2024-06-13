package com.buyconnex.buyconnex.service.client;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.client.Paniers;
import com.buyconnex.buyconnex.entity.user.Users;

public interface IPanierService {

	public Optional<Paniers> findById(Long id);
	public Paniers savePaniers(Paniers paniers);
	public void deletePaniers(Paniers paniers);
	public Paniers updatePaniers(Paniers paniers);
	public List<Paniers> findByArticles(Articles articles);
	public List<Paniers> findBydatePaniers(Date date);
	public List<Paniers> findByUsers(Users users);
}
