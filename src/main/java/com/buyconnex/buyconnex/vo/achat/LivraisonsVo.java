package com.buyconnex.buyconnex.vo.achat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.entity.achat.StatusLivraisons;
import com.buyconnex.buyconnex.entity.client.Adresses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LivraisonsVo {
	private Long id;
	private String numeroLivraison;
	private Date dateLivraisonEstimee;
	private LocalDateTime dateLivraison;
	private String commentaire;
	private StatusLivraisons statusLivraisons;
	private Adresses adresses;
	private Set<Commandes> commandes;
}
