package com.buyconnex.buyconnex.mapper.achat;

import com.buyconnex.buyconnex.entity.achat.LivraisonsDetails;
import com.buyconnex.buyconnex.vo.achat.LivraisonsDetailsVo;

public class LivraisonDetailMapper {

	public static LivraisonsDetailsVo toVO(LivraisonsDetails livraisonsDetails) {
		LivraisonsDetailsVo livraisonsDetailsVo = new LivraisonsDetailsVo();
		livraisonsDetailsVo.setLivraisonsVo(LivraisonMapper.toVO(livraisonsDetails.getLivraisons()));
		livraisonsDetailsVo.setCommandesVo(CommandeMapper.toVO(livraisonsDetails.getCommandes()));
		
		return livraisonsDetailsVo;
	}
	
	public static LivraisonsDetails toEntity(LivraisonsDetailsVo livraisonsDetailsVo) {
		LivraisonsDetails livraisonsDetails = new LivraisonsDetails();
		livraisonsDetails.setLivraisons(LivraisonMapper.toEntity(livraisonsDetailsVo.getLivraisonsVo()));
		livraisonsDetails.setCommandes(CommandeMapper.toEntity(livraisonsDetailsVo.getCommandesVo()));
		
		return livraisonsDetails;
	}
	
	public static void updateEntityFromVo(LivraisonsDetails livraisonsDetails, LivraisonsDetailsVo livraisonsDetailsVo) {
		livraisonsDetails.setLivraisons(LivraisonMapper.toEntity(livraisonsDetailsVo.getLivraisonsVo()));
		livraisonsDetails.setCommandes(CommandeMapper.toEntity(livraisonsDetailsVo.getCommandesVo()));
	}
}
