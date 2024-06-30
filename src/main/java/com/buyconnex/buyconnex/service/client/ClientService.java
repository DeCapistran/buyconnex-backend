package com.buyconnex.buyconnex.service.client;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.client.Clients;
import com.buyconnex.buyconnex.mapper.achat.CommandeMapper;
import com.buyconnex.buyconnex.mapper.client.AdresseMapper;
import com.buyconnex.buyconnex.mapper.client.ClientMapper;
import com.buyconnex.buyconnex.mapper.user.UserMapper;
import com.buyconnex.buyconnex.repository.client.ClientRepository;
import com.buyconnex.buyconnex.vo.achat.CommandesVo;
import com.buyconnex.buyconnex.vo.client.AdresseVo;
import com.buyconnex.buyconnex.vo.client.ClientsVo;
import com.buyconnex.buyconnex.vo.user.UsersVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ClientService implements IClientService {

	@Autowired
	ClientRepository clientRepository;
	
	@Override
	public Optional<ClientsVo> findById(Long id) {
		return clientRepository.findById(id).map(ClientMapper::toVO);
	}

	@Override
	public ClientsVo saveClients(ClientsVo clientsVo) {
		Clients clients = ClientMapper.toEntity(clientsVo);
		Clients clientsSave = clientRepository.save(clients);
		return ClientMapper.toVO(clientsSave);
	}

	@Override
	public void deleteClients(ClientsVo clientsVo) {
		Clients clients = ClientMapper.toEntity(clientsVo);
		clientRepository.delete(clients);
	}

	@Override
	public ClientsVo updateClients(Long id, ClientsVo clientsVo) {
		return clientRepository.findById(id).map(client -> {
			ClientMapper.updateEntityFromVO(clientsVo, client);
			Clients clientsUpdated = clientRepository.save(client);
			return ClientMapper.toVO(clientsUpdated);
		}).orElse(null);
	}

	@Override
	public List<ClientsVo> findByadresses(AdresseVo adresseVo) {
		return clientRepository.findByAdresses(AdresseMapper.toEntity(adresseVo)).stream().map(ClientMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<ClientsVo> findByCommandes(CommandesVo commandesVo) {
		return clientRepository.findByCommandes(CommandeMapper.toEntity(commandesVo)).stream().map(ClientMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public Optional<ClientsVo> findByEntreprises(String entreprise) {
		return clientRepository.findByEntreprise(entreprise).map(ClientMapper::toVO);
	}

	@Override
	public List<ClientsVo> findByFirstname(String firstname) {
		return clientRepository.findByFristname(firstname).stream().map(ClientMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<ClientsVo> findByLastname(String lastname) {
		return clientRepository.findByLastname(lastname).stream().map(ClientMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public Optional<ClientsVo> findByUsers(UsersVo usersVo) {
		return clientRepository.findByUsers(UserMapper.toEntity(usersVo)).map(ClientMapper::toVO);
	}

	@Override
	public List<ClientsVo> findAll() {
		return clientRepository.findAll().stream().map(ClientMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public void deleteClientsById(Long id) {
		clientRepository.deleteById(id);
	}

}
