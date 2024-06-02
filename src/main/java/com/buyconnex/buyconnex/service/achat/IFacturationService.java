package com.buyconnex.buyconnex.service.achat;

import java.util.Date;
import java.util.List;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.entity.achat.Facturations;

public interface IFacturationService {

	public Facturations findById(Long id);
	public Facturations saveFacturations(Facturations facturations);
	public void deleteFacturations(Facturations facturations);
	public Facturations updateFacturations(Facturations facturations);
	public List<Facturations> findByDateFacturation(Date date);
	public List<Facturations> findByCommandes(Commandes commandes);
}
