package com.buyconnex.buyconnex.service.achat;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.entity.achat.Livraisons;
import com.buyconnex.buyconnex.mapper.achat.LivraisonMapper;
import com.buyconnex.buyconnex.mapper.achat.StatusLivraisonMapper;
import com.buyconnex.buyconnex.mapper.client.AdresseMapper;
import com.buyconnex.buyconnex.repository.achat.CommandeRepository;
import com.buyconnex.buyconnex.repository.achat.LivraisonRepository;
import com.buyconnex.buyconnex.vo.achat.LivraisonsVo;
import com.buyconnex.buyconnex.vo.achat.StatusLivraisonsVo;
import com.buyconnex.buyconnex.vo.client.AdresseVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LivraisonService implements ILivraisonService {

	@Autowired
	LivraisonRepository livraisonRepository;
	
	@Autowired
	CommandeRepository commandeRepository;
	
	@Override
	public Optional<LivraisonsVo> findById(Long id) {
		return livraisonRepository.findById(id).map(LivraisonMapper::toVO);
	}

	@Override
	public LivraisonsVo saveLivraisons(LivraisonsVo livraisonsVo) {
		Livraisons livraisons = LivraisonMapper.toEntity(livraisonsVo);
		livraisons.getLivraisonsDetails().forEach(livraisonDetail -> {
			Commandes commandes = commandeRepository.findById(livraisonDetail.getCommandes().getCommande_id())
					.orElseThrow(() -> new RuntimeException("Commande non trouvé."));
					livraisonDetail.setCommandes(commandes);
					livraisonDetail.setLivraisons(livraisons);
		});
		Livraisons livraisonSave = livraisonRepository.save(livraisons);
		return LivraisonMapper.toVO(livraisonSave);
	}

	@Override
	public void deleteLivraisons(LivraisonsVo livraisonsVo) {
		Livraisons livraisons = LivraisonMapper.toEntity(livraisonsVo);
		livraisonRepository.delete(livraisons);
	}

	@Override
	public LivraisonsVo updateLivraisons(Long id, LivraisonsVo livraisonsVo) {
		return livraisonRepository.findById(id).map(existLivraison -> {
			LivraisonMapper.updateEntityFromVO(livraisonsVo, existLivraison);
			existLivraison.getLivraisonsDetails().forEach(livraisonDetail -> {
				Commandes commandes = commandeRepository.findById(livraisonDetail.getCommandes().getCommande_id())
						.orElseThrow(() -> new RuntimeException("Commande introuvable"));
				livraisonDetail.setCommandes(commandes);
				livraisonDetail.setLivraisons(existLivraison);
			});
			Livraisons livraisonUpdated = livraisonRepository.save(existLivraison);
			return LivraisonMapper.toVO(livraisonUpdated);
		}).orElse(null);
	}

	@Override
	public List<LivraisonsVo> findByAdresses(AdresseVo adressesVo) {
		return livraisonRepository.findByAdresses(AdresseMapper.toEntity(adressesVo)).stream().map(LivraisonMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<LivraisonsVo> findByDateLivraisons(Date date) {
		return livraisonRepository.findByDateLivraison(date).stream().map(LivraisonMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public LivraisonsVo findByNumeroLivraisons(String numeroLivraison) {
		return LivraisonMapper.toVO(livraisonRepository.findByNumeroLivraison(numeroLivraison));
	}

	@Override
	public List<LivraisonsVo> findByStatusLivraisons(StatusLivraisonsVo statusLivraisonsVo) {
		return livraisonRepository.findByStatusLivraisons(StatusLivraisonMapper.toEntity(statusLivraisonsVo)).stream().map(LivraisonMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<LivraisonsVo> findAll() {
		return livraisonRepository.findAll().stream().map(LivraisonMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public void deleteLivraisonsById(Long id) {
		livraisonRepository.deleteById(id);
	}

}
