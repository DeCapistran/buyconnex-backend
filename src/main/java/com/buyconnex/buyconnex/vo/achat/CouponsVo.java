package com.buyconnex.buyconnex.vo.achat;

import java.time.LocalDateTime;
import java.util.Date;

import com.buyconnex.buyconnex.entity.article.SousCategories;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CouponsVo {
	private Long id;
	private String libelle;
	private String logo;
	private String codeCoupon;
	private LocalDateTime dateCreation;
	private Date dateDebut;
	private Date dateFin;
	private int pourcentage;
	private Long montantMinimum;
	private SousCategories sousCategories;
}
