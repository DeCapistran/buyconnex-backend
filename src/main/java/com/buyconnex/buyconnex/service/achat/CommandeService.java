package com.buyconnex.buyconnex.service.achat;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.mapper.achat.CommandeMapper;
import com.buyconnex.buyconnex.mapper.achat.MoyenLivraisonMapper;
import com.buyconnex.buyconnex.mapper.achat.StatusCommandeMapper;
import com.buyconnex.buyconnex.mapper.client.ClientMapper;
import com.buyconnex.buyconnex.repository.achat.CommandeRepository;
import com.buyconnex.buyconnex.vo.achat.CommandesVo;
import com.buyconnex.buyconnex.vo.achat.MoyensLivraisonsVo;
import com.buyconnex.buyconnex.vo.achat.StatusCommandesVo;
import com.buyconnex.buyconnex.vo.article.ArticlesVo;
import com.buyconnex.buyconnex.vo.client.ClientsVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CommandeService implements ICommandeService {
	
	@Autowired
	CommandeRepository commandeRepository;

	@Override
	public Optional<CommandesVo> findById(Long id) {
		return commandeRepository.findById(id).map(CommandeMapper::toVO);
	}
	
	@Override
	public CommandesVo saveCommandes(CommandesVo commandesVo) {
		Commandes commandes = CommandeMapper.toEntity(commandesVo);
		Commandes commandeSave = commandeRepository.save(commandes);
		return CommandeMapper.toVO(commandeSave);
	}
	
	@Override
	public void deleteCommandes(CommandesVo commandesVo) {
		Commandes commandes = CommandeMapper.toEntity(commandesVo);
		commandeRepository.delete(commandes);
	}
	
	@Override
	public CommandesVo updateCommandes(Long id, CommandesVo commandesVo) {
		return commandeRepository.findById(id).map(commande -> {
			CommandeMapper.updateEntityFromVO(commandesVo, commande);
			Commandes commandeUpdated = commandeRepository.save(commande);
			return CommandeMapper.toVO(commandeUpdated);
		}).orElse(null);
	}

	@Override
	public CommandesVo findByNumeroCommande(String numeroCommande) {
		return CommandeMapper.toVO(commandeRepository.findByNumeroCommande(numeroCommande));
	}

	@Override
	public List<CommandesVo> findByClients(ClientsVo clientsVo) {
		return commandeRepository.findByClients(ClientMapper.toEntity(clientsVo)).stream().map(CommandeMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<CommandesVo> findByDateCommande(Date date) {
		return commandeRepository.findByDateCommande(date).stream().map(CommandeMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<CommandesVo> findByStatusCommandes(StatusCommandesVo statusCommandesVo) {
		return commandeRepository.findByStatusCommandes(StatusCommandeMapper.toEntity(statusCommandesVo)).stream().map(CommandeMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<CommandesVo> findBymoyensLivraisons(MoyensLivraisonsVo moyensLivraisonsVo) {
		return commandeRepository.findByMoyensLivraisons(MoyenLivraisonMapper.toEntity(moyensLivraisonsVo)).stream().map(CommandeMapper::toVO).collect(Collectors.toList());
	}
	
	private void validateCommande(CommandesVo commandesVo) {
		if(commandesVo.getArticles() == null || commandesVo.getArticles().isEmpty()) {
			throw new IllegalArgumentException("La commande ne contient pas d'articles");
		}
		
		for(ArticlesVo articlesVo : commandesVo.getArticles()) {
			
		}
	}
	
}
