package com.buyconnex.buyconnex.mapper.achat;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.entity.achat.CommandesDetails;
import com.buyconnex.buyconnex.mapper.article.ArticleMapper;
import com.buyconnex.buyconnex.vo.achat.CommandesDetailsVo;

public class CommandeDetailMapper {

	public static CommandesDetailsVo toVO(CommandesDetails commandesDetails) {
		if(commandesDetails == null) return null;
		CommandesDetailsVo commandesDetailsVo = new CommandesDetailsVo();
		commandesDetailsVo.setArticlesVo(ArticleMapper.toVO(commandesDetails.getArticles()));
		commandesDetailsVo.setIdCommande(commandesDetails.getCommandes() != null ? commandesDetails.getCommandes().getCommande_id() : null);
		commandesDetailsVo.setQuantite(commandesDetails.getQuantite());
		
		return commandesDetailsVo;
	}
	
	public static CommandesDetails toEntity(CommandesDetailsVo commandesDetailsVo) {
		if(commandesDetailsVo == null) return null;
		CommandesDetails commandesDetails = new CommandesDetails();
		commandesDetails.setArticles(ArticleMapper.toEntity(commandesDetailsVo.getArticlesVo()));
		commandesDetails.setQuantite(commandesDetailsVo.getQuantite());
		if (commandesDetailsVo.getIdCommande() != null) {
	        Commandes cmd = new Commandes();
	        cmd.setCommande_id(commandesDetailsVo.getIdCommande());
	        commandesDetails.setCommandes(cmd);
	    } else {
	        commandesDetails.setCommandes(null);
	    }
		
		return commandesDetails;
	}
	
	public static void updateEntityFromVo(CommandesDetails commandesDetails, CommandesDetailsVo commandesDetailsVo) {
		commandesDetails.setArticles(ArticleMapper.toEntity(commandesDetailsVo.getArticlesVo()));
		commandesDetails.setQuantite(commandesDetailsVo.getQuantite());
		if (commandesDetailsVo.getIdCommande() != null) {
	        Commandes cmd = new Commandes();
	        cmd.setCommande_id(commandesDetailsVo.getIdCommande());
	        commandesDetails.setCommandes(cmd);
	    } else {
	        commandesDetails.setCommandes(null);
	    }
	}
}
