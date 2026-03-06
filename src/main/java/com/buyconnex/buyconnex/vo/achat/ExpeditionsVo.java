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
public class ExpeditionsVo {
	private Long id;
	private String commentaire;
	private LocalDateTime dateExpedition;
	private Long idCommande;
}
