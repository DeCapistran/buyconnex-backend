package com.buyconnex.buyconnex.vo.achat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import com.buyconnex.buyconnex.vo.article.ArticlesVo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PromotionsVo {
	private Long id;
	private LocalDateTime dateCreation;
	private Date dateDebut;
	private Date dateFin;
	private int pourcentage;
	private String libelle;
	private String description;
	private Set<ArticlesVo> articles;
	private Set<PromotionsDetailsVo> promotionsDetails;
}
