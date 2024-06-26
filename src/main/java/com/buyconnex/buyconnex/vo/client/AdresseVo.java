package com.buyconnex.buyconnex.vo.client;

import com.buyconnex.buyconnex.vo.achat.FacturationsVo;
import com.buyconnex.buyconnex.vo.achat.LivraisonsVo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdresseVo {
	private Long id;
	private PaysVo pays;
	private VillesVo villes;
	private CommunesVo communes;
	private String adresse1;
	private String adresse2;
	private int codePostal;
	private String description;
	private ClientsVo clients;
	private FacturationsVo facturations;
	private LivraisonsVo livraisons;
}
