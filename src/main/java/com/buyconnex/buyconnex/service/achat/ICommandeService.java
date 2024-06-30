package com.buyconnex.buyconnex.service.achat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.achat.CommandesVo;
import com.buyconnex.buyconnex.vo.achat.MoyensLivraisonsVo;
import com.buyconnex.buyconnex.vo.achat.StatusCommandesVo;
import com.buyconnex.buyconnex.vo.client.ClientsVo;

public interface ICommandeService {

	public Optional<CommandesVo> findById(Long id);
	public List<CommandesVo> findAll();
	public CommandesVo saveCommandes(CommandesVo commandesVo);
	public void deleteCommandes(CommandesVo commandesVo);
	public void deleteCommandesById(Long id);
	public CommandesVo updateCommandes(Long id, CommandesVo commandesVo);
	public CommandesVo findByNumeroCommande(String numeroCommande);
	public List<CommandesVo> findByClients(ClientsVo clients);
	public List<CommandesVo> findByDateCommande(Date date);
	public List<CommandesVo> findByStatusCommandes(StatusCommandesVo statusCommandes);
	public List<CommandesVo> findBymoyensLivraisons(MoyensLivraisonsVo moyensLivraisons);
}
