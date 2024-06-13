package com.buyconnex.buyconnex.service.client;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.entity.client.Pays;
import com.buyconnex.buyconnex.entity.client.Villes;

public interface IPaysService {

	public Optional<Pays> findById(Long id);
	public Pays savePays(Pays pays);
	public void deletePays(Pays pays);
	public Pays updatePays(Pays pays);
	public List<Pays> findByPays(String pays);
	public List<Pays> findByVilles(Villes villes);
}
