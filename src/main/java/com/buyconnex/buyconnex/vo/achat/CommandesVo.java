package com.buyconnex.buyconnex.vo.achat;

import java.util.Date;
import java.util.Set;

import com.buyconnex.buyconnex.entity.achat.Expeditions;
import com.buyconnex.buyconnex.entity.achat.Facturations;
import com.buyconnex.buyconnex.entity.achat.Livraisons;
import com.buyconnex.buyconnex.entity.achat.MoyensLivraisons;
import com.buyconnex.buyconnex.entity.achat.StatusCommandes;
import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.client.Clients;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommandesVo {
	
	private String numeroCommande;
	private Date dateCommande;
	private String codeCoupon;
	private Clients clients;
	private StatusCommandes statusCommandes;
	private MoyensLivraisons moyensLivraisons;
	private Set<Articles> articles;
	private Set<Expeditions> expeditions;
	private Set<Facturations> facturations;
	private Set<Livraisons> livraisons;
	
}
