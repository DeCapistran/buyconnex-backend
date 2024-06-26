package com.buyconnex.buyconnex.vo.achat;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MoyensPaiementsVo {
	private Long id;
	private String moyensPaiements;
	private String description;
	private Set<PaiementsVo> paiements;
}
