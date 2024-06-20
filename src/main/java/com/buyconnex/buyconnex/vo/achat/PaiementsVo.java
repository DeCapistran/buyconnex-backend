package com.buyconnex.buyconnex.vo.achat;

import java.util.Date;

import com.buyconnex.buyconnex.entity.achat.MoyensLivraisons;
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

	private Date datePaiement;
	private Long montant;
	private MoyensPaiements moyensPaiements;
	private StatusPaiements statusPaiements;
}
