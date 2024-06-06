package com.buyconnex.buyconnex.vo.achat;

import java.util.Date;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.entity.client.Adresses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacturationsVo {

	private Date dateFacturation;
	private String description;
	private Commandes commandes;
	private Adresses adresses;
}
