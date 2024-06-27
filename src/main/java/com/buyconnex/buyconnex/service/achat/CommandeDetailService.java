package com.buyconnex.buyconnex.service.achat;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.buyconnex.buyconnex.repository.achat.CommandeDetailRepository;
import com.buyconnex.buyconnex.vo.achat.CommandesDetailsVo;
import com.buyconnex.buyconnex.vo.achat.CommandesVo;
import com.buyconnex.buyconnex.vo.article.ArticlesVo;

public class CommandeDetailService implements ICommandeDetailService {
	
	@Autowired
	CommandeDetailRepository commandeDetailRepository;

	@Override
	public Optional<CommandesDetailsVo> findById(Long id) {
		return commandeDetailRepository.findById(id).map(null);
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

	 
}
