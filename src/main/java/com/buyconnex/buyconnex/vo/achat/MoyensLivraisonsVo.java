package com.buyconnex.buyconnex.vo.achat;

import com.buyconnex.buyconnex.entity.achat.Commandes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MoyensLivraisonsVo {

	private String moyenLivraisons;
	private String description;
	private Commandes commandes;
}
