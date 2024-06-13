package com.buyconnex.buyconnex.service.client;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.entity.client.Communes;
import com.buyconnex.buyconnex.entity.client.Villes;

public interface ICommuneService {

	public Optional<Communes> findById(Long id);
	public Communes saveCommunes(Communes communes);
	public void deleteCommunes(Communes communes);
	public Communes updateCommunes(Communes communes);
	public List<Communes> findByCommune(String commune);
	public List<Communes> findByVilles(Villes villes);
}
