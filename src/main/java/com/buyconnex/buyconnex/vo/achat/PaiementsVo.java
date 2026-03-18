package com.buyconnex.buyconnex.vo.achat;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaiementsVo {
	private Long id;
	private LocalDateTime datePaiement;
	private Long montant;
	private MoyensPaiementsVo moyensPaiements;
	private StatusPaiementsVo statusPaiements;
}
