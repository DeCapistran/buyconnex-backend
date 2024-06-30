package com.buyconnex.buyconnex.vo.achat;

import java.time.LocalDateTime;
import java.util.Set;

import com.buyconnex.buyconnex.vo.article.ArticlesVo;
import com.buyconnex.buyconnex.vo.client.ClientsVo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommandesVo {
	private Long id;
	private String numeroCommande;
	private LocalDateTime dateCommande;
	private String codeCoupon;
	private ClientsVo clients;
	private StatusCommandesVo statusCommandes;
	private MoyensLivraisonsVo moyensLivraisons;
	private Set<ArticlesVo> articles;
	private Set<ExpeditionsVo> expeditions;
	private Set<FacturationsVo> facturations;
	private Set<LivraisonsVo> livraisons;
	private Set<CommandesDetailsVo> commandesDetails;
	
}
