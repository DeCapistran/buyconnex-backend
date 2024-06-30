package com.buyconnex.buyconnex.service.client;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.achat.FacturationsVo;
import com.buyconnex.buyconnex.vo.achat.LivraisonsVo;
import com.buyconnex.buyconnex.vo.client.AdresseVo;
import com.buyconnex.buyconnex.vo.client.ClientsVo;
import com.buyconnex.buyconnex.vo.client.PaysVo;
import com.buyconnex.buyconnex.vo.client.VillesVo;

public interface IAdresseService {
	
	public Optional<AdresseVo> findById(Long id);
	public List<AdresseVo> findAll();
	public AdresseVo saveAdresse(AdresseVo adresseVo);
	public void deleteAdresse(AdresseVo adresseVo);
	public void deleteAdresseById(Long id);
	public AdresseVo updateAdresse(Long id, AdresseVo adresseVo);
	public List<AdresseVo> findByFacturations(FacturationsVo facturationsVo);
	public List<AdresseVo> findByLivraisons(LivraisonsVo livraisonsVo);
	public List<AdresseVo> findByPays(PaysVo paysVo);
	public List<AdresseVo> findByVilles(VillesVo villesVo);
	public List<AdresseVo> findByClients(ClientsVo clientsVo);
	
}
