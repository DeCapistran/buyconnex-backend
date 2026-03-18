package com.buyconnex.buyconnex.service.client;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.client.Adresses;
import com.buyconnex.buyconnex.mapper.achat.FacturationMapper;
import com.buyconnex.buyconnex.mapper.achat.LivraisonMapper;
import com.buyconnex.buyconnex.mapper.client.AdresseMapper;
import com.buyconnex.buyconnex.mapper.client.ClientMapper;
import com.buyconnex.buyconnex.mapper.client.PaysMapper;
import com.buyconnex.buyconnex.mapper.client.VilleMapper;
import com.buyconnex.buyconnex.repository.client.AdresseRepository;
import com.buyconnex.buyconnex.vo.achat.FacturationsVo;
import com.buyconnex.buyconnex.vo.achat.LivraisonsVo;
import com.buyconnex.buyconnex.vo.client.AdresseVo;
import com.buyconnex.buyconnex.vo.client.ClientsVo;
import com.buyconnex.buyconnex.vo.client.PaysVo;
import com.buyconnex.buyconnex.vo.client.VillesVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AdresseService implements IAdresseService {

	@Autowired
	AdresseRepository adresseRepository;
	
	@Override
	public Optional<AdresseVo> findById(Long id) {
		return adresseRepository.findById(id).map(AdresseMapper::toVO);
	}

	@Override
	public AdresseVo saveAdresse(AdresseVo adresseVo) {
		Adresses adresses = AdresseMapper.toEntity(adresseVo);
		Adresses adressesSave = adresseRepository.save(adresses);
		return AdresseMapper.toVO(adressesSave);
	}

	@Override
	public void deleteAdresse(AdresseVo adresseVo) {
		Adresses adresses = AdresseMapper.toEntity(adresseVo);
		adresseRepository.delete(adresses);
	}

	@Override
	public AdresseVo updateAdresse(Long id, AdresseVo adresseVo) {
		return adresseRepository.findById(id).map(adresse -> {
			AdresseMapper.updateEntityFromVO(adresseVo, adresse);
			Adresses adressesUpdated = adresseRepository.save(adresse);
			return AdresseMapper.toVO(adressesUpdated);
		}).orElse(null);
	}

	@Override
	public List<AdresseVo> findByFacturations(FacturationsVo facturationsVo) {
		return adresseRepository.findByFacturations(FacturationMapper.toEntity(facturationsVo)).stream().map(AdresseMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<AdresseVo> findByLivraisons(LivraisonsVo livraisonsVo) {
		return adresseRepository.findByLivraisons(LivraisonMapper.toEntity(livraisonsVo)).stream().map(AdresseMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<AdresseVo> findByPays(PaysVo paysVo) {
		return adresseRepository.findByPays(PaysMapper.toEntity(paysVo)).stream().map(AdresseMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<AdresseVo> findByVilles(VillesVo villesVo) {
		return adresseRepository.findByVille(VilleMapper.toEntity(villesVo)).stream().map(AdresseMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<AdresseVo> findByClients(ClientsVo clientsVo) {
		return adresseRepository.findByClients(ClientMapper.toEntity(clientsVo)).stream().map(AdresseMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<AdresseVo> findAll() {
		return adresseRepository.findAll().stream().map(AdresseMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public void deleteAdresseById(Long id) {
		adresseRepository.deleteById(id);
	}

}
