package com.buyconnex.buyconnex.vo.achat;

import java.time.LocalDateTime;

import com.buyconnex.buyconnex.vo.client.AdresseVo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacturationsVo {
	private Long id;
	private LocalDateTime dateFacturation;
	private String description;
	private CommandesVo commandes;
	private AdresseVo adresses;
}
