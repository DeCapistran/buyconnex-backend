package com.buyconnex.buyconnex.vo.client;

import java.util.Set;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.entity.client.Adresses;
import com.buyconnex.buyconnex.entity.user.Users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientsVo {

	private String firstname;
	private String lastname;
	private String entreprise;
	private String genre;
	private String facebook;
	private String instagram;
	private String telephone1;
	private String telephone2;
	private Adresses adresses;
	private Users users;
	private Set<Commandes> commandes;
}
