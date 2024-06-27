package com.buyconnex.buyconnex.service.achat;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.achat.CommandesDetailsVo;
import com.buyconnex.buyconnex.vo.achat.CommandesVo;
import com.buyconnex.buyconnex.vo.article.ArticlesVo;

public interface ICommandeDetailService {

	public Optional<CommandesDetailsVo> findById(Long id);
	public CommandesDetailsVo saveCommandesDetails(CommandesDetailsVo commandesDetailsVo);
	public void deleteCommandesDetails(CommandesDetailsVo commandesDetailsVo);
	public CommandesDetailsVo updateCommandesdetails(Long id, CommandesDetailsVo commandesDetailsVo);
	public List<CommandesDetailsVo> findByCommandes(CommandesVo commandesVo);
	public List<CommandesDetailsVo> findByArticles(ArticlesVo articlesVo);
	
}
