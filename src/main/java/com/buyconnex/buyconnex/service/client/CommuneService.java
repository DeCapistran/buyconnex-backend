package com.buyconnex.buyconnex.service.client;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.client.Communes;
import com.buyconnex.buyconnex.entity.client.Villes;
import com.buyconnex.buyconnex.repository.client.CommuneRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CommuneService implements ICommuneService {

	CommuneRepository communeRepository;
	
	@Override
	public Optional<Communes> findById(Long id) {
		return communeRepository.findById(id);
	}

	@Override
	public Communes saveCommunes(Communes communes) {
		return communeRepository.save(communes);
	}

	@Override
	public void deleteCommunes(Communes communes) {
		communeRepository.delete(communes);
	}

	@Override
	public Communes updateCommunes(Communes communes) {
		return communeRepository.save(communes);
	}

	@Override
	public List<Communes> findByCommune(String commune) {
		return communeRepository.findByCommune(commune);
	}

	@Override
	public List<Communes> findByVilles(Villes villes) {
		return communeRepository.findByVilles(villes);
	}

}
