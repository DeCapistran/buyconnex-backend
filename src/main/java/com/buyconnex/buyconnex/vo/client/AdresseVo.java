package com.buyconnex.buyconnex.vo.client;

import com.buyconnex.buyconnex.entity.achat.Facturations;
import com.buyconnex.buyconnex.entity.achat.Livraisons;
import com.buyconnex.buyconnex.entity.client.Clients;
import com.buyconnex.buyconnex.entity.client.Communes;
import com.buyconnex.buyconnex.entity.client.Pays;
import com.buyconnex.buyconnex.entity.client.Villes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdresseVo {

	private Pays pays;
	private Villes villes;
	private Communes communes;
	private String adresse1;
	private String adresse2;
	private int codePostal;
	private String description;
	private Clients clients;
	private Facturations facturations;
	private Livraisons livraisons;
}
