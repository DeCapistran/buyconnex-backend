package com.buyconnex.buyconnex.mapper.achat;

import java.util.stream.Collectors;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.mapper.article.ArticleMapper;
import com.buyconnex.buyconnex.mapper.client.ClientMapper;
import com.buyconnex.buyconnex.vo.achat.CommandesVo;

public class CommandeMapper {

	public static CommandesVo toVO(Commandes commandes) {
		CommandesVo commandesVo = new CommandesVo();
		commandesVo.setNumeroCommande(commandes.getNumeroCommande());
		commandesVo.setDateCommande(commandes.getDateCommande());
		commandesVo.setCodeCoupon(commandes.getCodeCoupon());
		commandesVo.setClients(ClientMapper.toVO(commandes.getClients()));
		commandesVo.setStatusCommandes(StatusCommandeMapper.toVO(commandes.getStatusCommandes()));
		commandesVo.setMoyensLivraisons(MoyenLivraisonMapper.toVO(commandes.getMoyensLivraisons()));
		commandesVo.setArticles(commandes.getArticles().stream().map(ArticleMapper::toVO).collect(Collectors.toSet()));
		commandesVo.setExpeditions(commandes.getExpeditions().stream().map(ExpeditionMapper::toVO).collect(Collectors.toSet()));
		commandesVo.setFacturations(commandes.getFacturations().stream().map(FacturationMapper::toVO).collect(Collectors.toSet()));
		commandesVo.setLivraisons(commandes.getLivraisons().stream().map(LivraisonMapper::toVO).collect(Collectors.toSet()));
		
		return commandesVo;
	}
	
	public static Commandes toEntity(CommandesVo commandesVo) {
		Commandes commandes = new Commandes();
		commandes.setNumeroCommande(commandesVo.getNumeroCommande());
		commandes.setDateCommande(commandesVo.getDateCommande());
		commandes.setCodeCoupon(commandesVo.getCodeCoupon());
		commandes.setClients(ClientMapper.toEntity(commandesVo.getClients()));
		commandes.setStatusCommandes(StatusCommandeMapper.toEntity(commandesVo.getStatusCommandes()));
		commandes.setMoyensLivraisons(MoyenLivraisonMapper.toEntity(commandesVo.getMoyensLivraisons()));
		commandes.setArticles(commandesVo.getArticles().stream().map(ArticleMapper::toEntity).collect(Collectors.toSet()));
		commandes.setExpeditions(commandesVo.getExpeditions().stream().map(ExpeditionMapper::toEntity).collect(Collectors.toSet()));
		commandes.setFacturations(commandesVo.getFacturations().stream().map(FacturationMapper::toEntity).collect(Collectors.toSet()));
		commandes.setLivraisons(commandesVo.getLivraisons().stream().map(LivraisonMapper::toEntity).collect(Collectors.toSet()));
		
		return commandes;
	}
	
	public static void updateEntityFromVO(CommandesVo commandesVo, Commandes commandes) {
		commandes.setNumeroCommande(commandesVo.getNumeroCommande());
		commandes.setDateCommande(commandesVo.getDateCommande());
		commandes.setCodeCoupon(commandesVo.getCodeCoupon());
		commandes.setClients(ClientMapper.toEntity(commandesVo.getClients()));
		commandes.setStatusCommandes(StatusCommandeMapper.toEntity(commandesVo.getStatusCommandes()));
		commandes.setMoyensLivraisons(MoyenLivraisonMapper.toEntity(commandesVo.getMoyensLivraisons()));
		commandes.setArticles(commandesVo.getArticles().stream().map(ArticleMapper::toEntity).collect(Collectors.toSet()));
		commandes.setExpeditions(commandesVo.getExpeditions().stream().map(ExpeditionMapper::toEntity).collect(Collectors.toSet()));
		commandes.setFacturations(commandesVo.getFacturations().stream().map(FacturationMapper::toEntity).collect(Collectors.toSet()));
		commandes.setLivraisons(commandesVo.getLivraisons().stream().map(LivraisonMapper::toEntity).collect(Collectors.toSet()));
		
	}
}
