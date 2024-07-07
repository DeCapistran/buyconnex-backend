package com.buyconnex.buyconnex.service.achat;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.mapper.achat.CommandeMapper;
import com.buyconnex.buyconnex.mapper.achat.MoyenLivraisonMapper;
import com.buyconnex.buyconnex.mapper.achat.StatusCommandeMapper;
import com.buyconnex.buyconnex.mapper.client.ClientMapper;
import com.buyconnex.buyconnex.repository.achat.CommandeRepository;
import com.buyconnex.buyconnex.repository.article.ArticleRepository;
import com.buyconnex.buyconnex.vo.achat.CommandesDetailsVo;
import com.buyconnex.buyconnex.vo.achat.CommandesVo;
import com.buyconnex.buyconnex.vo.achat.MoyensLivraisonsVo;
import com.buyconnex.buyconnex.vo.achat.StatusCommandesVo;
import com.buyconnex.buyconnex.vo.client.ClientsVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CommandeService implements ICommandeService {
	
	@Autowired
	CommandeRepository commandeRepository;
	
	@Autowired
	ArticleRepository articleRepository;

	@Override
	public Optional<CommandesVo> findById(Long id) {
		return commandeRepository.findById(id).map(CommandeMapper::toVO);
	}
	
	@Override
	public CommandesVo saveCommandes(CommandesVo commandesVo) {
		validateCommande(commandesVo);
		Commandes commandes = CommandeMapper.toEntity(commandesVo);
		commandes.getCommandesDetails().forEach(commandeDetail -> {
			Articles articles = articleRepository.findById(commandeDetail.getArticles().getArticle_id())
					.orElseThrow(() -> new RuntimeException("Article non trouvé."));
					commandeDetail.setArticles(articles);
					commandeDetail.setCommandes(commandes);
		});
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
		return commandeRepository.findById(id).map(existCommande -> {
			CommandeMapper.updateEntityFromVO(commandesVo, existCommande);
			existCommande.getCommandesDetails().forEach(comDetail -> {
				Articles articles = articleRepository.findById(comDetail.getArticles().getArticle_id())
						.orElseThrow(() -> new RuntimeException("Article introuvable"));
				comDetail.setArticles(articles);
				comDetail.setCommandes(existCommande);
			});
			Commandes commandeUpdated = commandeRepository.save(existCommande);
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
			throw new IllegalArgumentException("La commande ne contient pas d'articles.");
		} else {
			for(CommandesDetailsVo comDetailVo : commandesVo.getCommandesDetails()) {
				if (comDetailVo.getQuantite() <= 0) {
					throw new IllegalArgumentException("La quantité ne doit pas être nulle.");
				} 
				if(comDetailVo.getArticlesVo() == null || comDetailVo.getArticlesVo().getIdArticle() == null) {
					throw new IllegalArgumentException("Tous les articles doivent être valides.");
				}
				if(articleRepository.existsById(comDetailVo.getArticlesVo().getIdArticle())) {
					throw new IllegalArgumentException("Le produit avec ID : " + comDetailVo.getArticlesVo().getIdArticle() + " n'existe pas.");
				}
			}
		}
	}

	@Override
	public List<CommandesVo> findAll() {
		return commandeRepository.findAll().stream().map(CommandeMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public void deleteCommandesById(Long id) {
		commandeRepository.deleteById(id);
		
	}
	
}
