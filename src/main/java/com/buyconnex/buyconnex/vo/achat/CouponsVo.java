package com.buyconnex.buyconnex.vo.achat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

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
	private String codeCoupon;
	private LocalDateTime dateCreation;
	private Date dateDebut;
	private Date dateFin;
	private BigDecimal pourcentage;
	private BigDecimal montantMinimum;
}
