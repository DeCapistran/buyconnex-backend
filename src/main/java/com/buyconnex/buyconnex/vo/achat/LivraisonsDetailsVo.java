package com.buyconnex.buyconnex.vo.achat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LivraisonsDetailsVo {

	private Long id;
	private Long idCommande;
	private LivraisonsVo livraisonsVo;
}
