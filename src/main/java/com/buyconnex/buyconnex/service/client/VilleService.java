package com.buyconnex.buyconnex.service.client;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.client.Communes;
import com.buyconnex.buyconnex.entity.client.Pays;
import com.buyconnex.buyconnex.entity.client.Villes;
import com.buyconnex.buyconnex.repository.client.VilleRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class VilleService implements IVilleService {

	VilleRepository villeRepository;
	
	@Override
	public Optional<Villes> findById(Long id) {
		return villeRepository.findById(id);
	}

	@Override
	public Villes saveVilles(Villes villes) {
		return villeRepository.save(villes);
	}

	@Override
	public void deleteVilles(Villes villes) {
		villeRepository.delete(villes);
	}

	@Override
	public Villes updateVilles(Villes villes) {
		return villeRepository.save(villes);
	}

	@Override
	public List<Villes> findByCommunes(Communes communes) {
		return villeRepository.findByCommunes(communes);
	}

	@Override
	public List<Villes> findByPays(Pays pays) {
		return villeRepository.findByPays(pays);
	}

	@Override
	public List<Villes> findByVilles(String ville) {
		return villeRepository.findByVille(ville);
	}

}
