package com.buyconnex.buyconnex.mapper.achat;

import java.util.stream.Collectors;

import com.buyconnex.buyconnex.entity.achat.Livraisons;
import com.buyconnex.buyconnex.mapper.client.AdresseMapper;
import com.buyconnex.buyconnex.vo.achat.LivraisonsVo;

public class LivraisonMapper {

	public static LivraisonsVo toVO(Livraisons livraisons) {
		LivraisonsVo livraisonsVo = new LivraisonsVo();
		livraisonsVo.setNumeroLivraison(livraisons.getNumeroLivraison());
		livraisonsVo.setDateLivraisonEstimee(livraisons.getDateLivraisonEstimee());
		livraisonsVo.setDateLivraison(livraisons.getDateLivraison());
		livraisonsVo.setCommentaire(livraisons.getCommentaire());
		livraisonsVo.setStatusLivraisons(StatusLivraisonMapper.toVO(livraisons.getStatusLivraisons()));
		livraisonsVo.setAdresses(AdresseMapper.toVO(livraisons.getAdresses()));
		livraisonsVo.setCommandes(livraisons.getCommandes().stream().map(CommandeMapper::toVO).collect(Collectors.toSet()));
		
		return livraisonsVo;
	}
	
	public static Livraisons toEntity(LivraisonsVo livraisonsVo) {
		Livraisons livraisons = new Livraisons();
		livraisons.setNumeroLivraison(livraisonsVo.getNumeroLivraison());
		livraisons.setDateLivraisonEstimee(livraisonsVo.getDateLivraisonEstimee());
		livraisons.setDateLivraison(livraisonsVo.getDateLivraison());
		livraisons.setCommentaire(livraisonsVo.getCommentaire());
		livraisons.setStatusLivraisons(StatusLivraisonMapper.toEntity(livraisonsVo.getStatusLivraisons()));
		livraisons.setAdresses(AdresseMapper.toEntity(livraisonsVo.getAdresses()));
		livraisons.setCommandes(livraisonsVo.getCommandes().stream().map(CommandeMapper::toEntity).collect(Collectors.toSet()));
		
		return livraisons;
	}
	
	public static void updateEntityFromVO(LivraisonsVo livraisonsVo, Livraisons livraisons) {
		
		livraisons.setNumeroLivraison(livraisonsVo.getNumeroLivraison());
		livraisons.setDateLivraisonEstimee(livraisonsVo.getDateLivraisonEstimee());
		livraisons.setDateLivraison(livraisonsVo.getDateLivraison());
		livraisons.setCommentaire(livraisonsVo.getCommentaire());
		livraisons.setStatusLivraisons(StatusLivraisonMapper.toEntity(livraisonsVo.getStatusLivraisons()));
		livraisons.setAdresses(AdresseMapper.toEntity(livraisonsVo.getAdresses()));
		livraisons.setCommandes(livraisonsVo.getCommandes().stream().map(CommandeMapper::toEntity).collect(Collectors.toSet()));
	}
}
