package com.buyconnex.buyconnex.service.achat;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.mapper.achat.CommandeDetailMapper;
import com.buyconnex.buyconnex.repository.achat.CommandeDetailRepository;
import com.buyconnex.buyconnex.vo.achat.CommandesDetailsVo;
import com.buyconnex.buyconnex.vo.achat.CommandesVo;
import com.buyconnex.buyconnex.vo.article.ArticlesVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CommandeDetailService implements ICommandeDetailService {
	
	@Autowired
	CommandeDetailRepository commandeDetailRepository;

	@Override
	public Optional<CommandesDetailsVo> findById(Long id) {
		return commandeDetailRepository.findById(id).map(CommandeDetailMapper::toVO);
	}

	@Override
	public CommandesDetailsVo saveCommandesDetails(CommandesDetailsVo commandesDetailsVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCommandesDetails(CommandesDetailsVo commandesDetailsVo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CommandesDetailsVo updateCommandesdetails(Long id, CommandesDetailsVo commandesDetailsVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommandesDetailsVo> findByCommandes(CommandesVo commandesVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommandesDetailsVo> findByArticles(ArticlesVo articlesVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<CommandesDetailsVo> findByAll() {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void deleteCommandesDetailsById(Long id) {
		// TODO Auto-generated method stub
		
	}

	 
}
