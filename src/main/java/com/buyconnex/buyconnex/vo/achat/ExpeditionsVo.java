package com.buyconnex.buyconnex.vo.achat;

import java.util.Date;

import com.buyconnex.buyconnex.entity.achat.Commandes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExpeditionsVo {

	private String commentaire;
	private Date dateExpedition;
	private Commandes commandes;
}
