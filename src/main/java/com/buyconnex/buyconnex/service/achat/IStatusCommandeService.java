package com.buyconnex.buyconnex.service.achat;

import java.util.List;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.entity.achat.StatusCommandes;

public interface IStatusCommandeService {

	public StatusCommandes findById(Long id);
	public StatusCommandes saveStatusCommandes(StatusCommandes statusCommandes);
	public void deleteStatusCommandes(StatusCommandes statusCommandes);
	public StatusCommandes updateStatusCommandes(StatusCommandes statusCommandes);
	public List<StatusCommandes> findByCommandes(Commandes commandes);
	public List<StatusCommandes> findByStatus(String status);
}
