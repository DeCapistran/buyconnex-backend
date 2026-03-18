package com.buyconnex.buyconnex.repository.achat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.entity.achat.CommandesDetails;
import com.buyconnex.buyconnex.entity.article.Articles;



public interface CommandeDetailRepository extends JpaRepository<CommandesDetails, Long> {

	List<CommandesDetails> findByCommandes(Commandes commandes);
	List<CommandesDetails> findByArticles(Articles articles);
}
