package com.buyconnex.buyconnex.mapper.achat;

import com.buyconnex.buyconnex.entity.achat.Livraisons;
import com.buyconnex.buyconnex.vo.achat.LivraisonsVo;

public class LivraisonMapper {

	public static LivraisonsVo toVO(Livraisons livraisons) {
		LivraisonsVo livraisonsVo = new LivraisonsVo();
		livraisonsVo.setNumeroLivraison(livraisons.getNumeroLivraison());
		livraisonsVo.setDateLivraisonEstimee(livraisons.getDateLivraisonEstimee());
		livraisonsVo.setDateLivraison(livraisons.getDateLivraison());
		livraisonsVo.setCommentaire(livraisons.getCommentaire());
		livraisonsVo.setStatusLivraisons(livraisons.getStatusLivraisons());
		livraisonsVo.setAdresses(livraisons.getAdresses());
		livraisonsVo.setCommandes(livraisons.getCommandes());
		
		return livraisonsVo;
	}
	
	public static Livraisons toEntity(LivraisonsVo livraisonsVo) {
		Livraisons livraisons = new Livraisons();
		livraisons.setNumeroLivraison(livraisonsVo.getNumeroLivraison());
		livraisons.setDateLivraisonEstimee(livraisonsVo.getDateLivraisonEstimee());
		livraisons.setDateLivraison(livraisonsVo.getDateLivraison());
		livraisons.setCommentaire(livraisonsVo.getCommentaire());
		livraisons.setStatusLivraisons(livraisonsVo.getStatusLivraisons());
		livraisons.setAdresses(livraisonsVo.getAdresses());
		livraisons.setCommandes(livraisonsVo.getCommandes());
		
		return livraisons;
	}
}
