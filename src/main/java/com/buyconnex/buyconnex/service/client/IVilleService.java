package com.buyconnex.buyconnex.service.client;

import java.util.List;

import com.buyconnex.buyconnex.entity.client.Communes;
import com.buyconnex.buyconnex.entity.client.Pays;
import com.buyconnex.buyconnex.entity.client.Villes;

public interface IVilleService {

	public Villes findById(Long id);
	public Villes saveVilles(Villes villes);
	public void deleteVilles(Villes villes);
	public Villes updateVilles(Villes villes);
	public List<Villes> findByCommunes(Communes communes);
	public List<Villes> findByPays(Pays pays);
	public List<Villes> findByVilles(String ville);
}
