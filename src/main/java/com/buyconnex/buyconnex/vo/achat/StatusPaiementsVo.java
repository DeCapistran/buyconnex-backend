package com.buyconnex.buyconnex.vo.achat;

import com.buyconnex.buyconnex.entity.achat.Paiements;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatusPaiementsVo {

	private String status;
	private String description;
	private Paiements paiements;
}
