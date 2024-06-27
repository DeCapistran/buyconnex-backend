package com.buyconnex.buyconnex.mapper.achat;

import com.buyconnex.buyconnex.entity.achat.CommandesDetails;
import com.buyconnex.buyconnex.mapper.article.ArticleMapper;
import com.buyconnex.buyconnex.vo.achat.CommandesDetailsVo;

public class CommandeDetailMapper {

	public static CommandesDetailsVo toVO(CommandesDetails commandesDetails) {
		CommandesDetailsVo commandesDetailsVo = new CommandesDetailsVo();
		commandesDetailsVo.setArticlesVo(ArticleMapper.toVO(commandesDetails.getArticles()));
		commandesDetailsVo.setCommandesVo(CommandeMapper.toVO(commandesDetails.getCommandes()));
		commandesDetailsVo.setQuantite(commandesDetails.getQuantite());
		
		return commandesDetailsVo;
	}
	
	public static CommandesDetails toEntity(CommandesDetailsVo commandesDetailsVo) {
		CommandesDetails commandesDetails = new CommandesDetails();
		commandesDetails.setArticles(ArticleMapper.toEntity(commandesDetailsVo.getArticlesVo()));
		commandesDetails.setCommandes(CommandeMapper.toEntity(commandesDetailsVo.getCommandesVo()));
		commandesDetails.setQuantite(commandesDetailsVo.getQuantite());
		
		return commandesDetails;
	}
	
	public static void updateEntityFromVo(CommandesDetails commandesDetails, CommandesDetailsVo commandesDetailsVo) {
		commandesDetails.setArticles(ArticleMapper.toEntity(commandesDetailsVo.getArticlesVo()));
		commandesDetails.setCommandes(CommandeMapper.toEntity(commandesDetailsVo.getCommandesVo()));
		commandesDetails.setQuantite(commandesDetailsVo.getQuantite());
	}
}
