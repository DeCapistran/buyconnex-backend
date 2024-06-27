package com.buyconnex.buyconnex.vo.achat;

import java.time.LocalDateTime;
import java.util.Date;

import com.buyconnex.buyconnex.vo.client.AdresseVo;

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
	private StatusLivraisonsVo statusLivraisons;
	private AdresseVo adresses;
	private CommandesVo commandes;
}
