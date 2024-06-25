package com.buyconnex.buyconnex.vo.achat;

import java.time.LocalDateTime;

import com.buyconnex.buyconnex.entity.achat.MoyensPaiements;
import com.buyconnex.buyconnex.entity.achat.StatusPaiements;

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
	private MoyensPaiements moyensPaiements;
	private StatusPaiements statusPaiements;
}
