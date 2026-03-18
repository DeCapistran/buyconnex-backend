package com.buyconnex.buyconnex.vo.client;

import java.util.Set;

import com.buyconnex.buyconnex.vo.achat.CommandesVo;
import com.buyconnex.buyconnex.vo.user.UsersVo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientsVo {
	private Long id;
	private String firstname;
	private String lastname;
	private String entreprise;
	private String genre;
	private String facebook;
	private String instagram;
	private String telephone1;
	private String telephone2;
	private AdresseVo adresses;
	private UsersVo users;
	private Set<CommandesVo> commandes;
}
