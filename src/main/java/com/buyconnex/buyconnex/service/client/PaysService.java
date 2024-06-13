package com.buyconnex.buyconnex.service.client;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.client.Pays;
import com.buyconnex.buyconnex.entity.client.Villes;
import com.buyconnex.buyconnex.repository.client.PaysRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PaysService implements IPaysService {

	@Autowired
	PaysRepository paysRepository;
	
	@Override
	public Optional<Pays> findById(Long id) {
		return paysRepository.findById(id);
	}

	@Override
	public Pays savePays(Pays pays) {
		return paysRepository.save(pays);
	}

	@Override
	public void deletePays(Pays pays) {
		paysRepository.delete(pays);
	}

	@Override
	public Pays updatePays(Pays pays) {
		return paysRepository.save(pays);
	}

	@Override
	public List<Pays> findByPays(String pays) {
		return paysRepository.findByPays(pays);
	}

	@Override
	public List<Pays> findByVilles(Villes villes) {
		return paysRepository.findByVilles(villes);
	}

}
