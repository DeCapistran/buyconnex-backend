package com.buyconnex.buyconnex.mapper.achat;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.vo.achat.CommandesVo;

public class CommandeMapper {

	public static CommandesVo toVO(Commandes commandes) {
		CommandesVo commandesVo = new CommandesVo();
		commandesVo.setNumeroCommande(commandes.getNumeroCommande());
		commandesVo.setDateCommande(commandes.getDateCommande());
		commandesVo.setCodeCoupon(commandes.getCodeCoupon());
		commandesVo.setClients(commandes.getClients());
		commandesVo.setStatusCommandes(commandes.getStatusCommandes());
		commandesVo.setMoyensLivraisons(commandes.getMoyensLivraisons());
		commandesVo.setArticles(commandes.getArticles());
		commandesVo.setExpeditions(commandes.getExpeditions());
		commandesVo.setFacturations(commandes.getFacturations());
		commandesVo.setLivraisons(commandes.getLivraisons());
		
		return commandesVo;
	}
	
	public static Commandes toEntity(CommandesVo commandesVo) {
		Commandes commandes = new Commandes();
		commandes.setNumeroCommande(commandesVo.getNumeroCommande());
		commandes.setDateCommande(commandesVo.getDateCommande());
		commandes.setCodeCoupon(commandesVo.getCodeCoupon());
		commandes.setClients(commandesVo.getClients());
		commandes.setStatusCommandes(commandesVo.getStatusCommandes());
		commandes.setMoyensLivraisons(commandesVo.getMoyensLivraisons());
		commandes.setArticles(commandesVo.getArticles());
		commandes.setExpeditions(commandesVo.getExpeditions());
		commandes.setFacturations(commandesVo.getFacturations());
		commandes.setLivraisons(commandesVo.getLivraisons());
		
		return commandes;
	}
}
