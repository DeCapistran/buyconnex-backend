package com.buyconnex.buyconnex.repository.article;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.article.Avis;
import com.buyconnex.buyconnex.entity.user.Users;



public interface AvisRepository extends JpaRepository<Avis, Long> {

	List<Avis> findByArticles(Articles articles);
	List<Avis> findByEtoile(int etoile);
	List<Avis> findByUsers(Users users);
}
