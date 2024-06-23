package com.buyconnex.buyconnex.service.client;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.achat.CommandesVo;
import com.buyconnex.buyconnex.vo.client.AdresseVo;
import com.buyconnex.buyconnex.vo.client.ClientsVo;
import com.buyconnex.buyconnex.vo.user.UsersVo;

public interface IClientService {

	public Optional<ClientsVo> findById(Long id);
	public ClientsVo saveClients(ClientsVo clientsVo);
	public void deleteClients(ClientsVo clientsVo);
	public ClientsVo updateClients(Long id, ClientsVo clientsVo);
	public List<ClientsVo> findByadresses(AdresseVo adresseVo);
	public List<ClientsVo> findByCommandes(CommandesVo commandesVo);
	public Optional<ClientsVo> findByEntreprises(String entreprise);
	public List<ClientsVo> findByFirstname(String firstname);
	public List<ClientsVo> findByLastname(String lastname);
	public Optional<ClientsVo> findByUsers(UsersVo usersVo);
}
