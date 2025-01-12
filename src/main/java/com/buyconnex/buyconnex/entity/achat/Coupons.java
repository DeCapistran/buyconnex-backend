package com.buyconnex.buyconnex.entity.achat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "COUPONS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Coupons {

	@Id
	@Getter
    @SequenceGenerator(name = "COUPONS_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COUPONS_SEQ_ID")
    @Column(name = "ID_COUPONS")
    private Long coupon_id;
	
	@Getter @Setter
	@Column(name = "LIBELLE")
    private String libelle;
	
	@Getter @Setter
	@Column(name = "CODE_COUPON")
    private String codeCoupon;
	
	@Getter @Setter
	@Column(name = "DATE_CREATION")
    private LocalDateTime dateCreation;
	
	@Getter @Setter
	@Column(name = "DATE_DEBUT")
    private Date dateDebut;
	
	@Getter @Setter
	@Column(name = "DATE_FIN")
    private Date dateFin;
	
	@Getter @Setter
	@Column(name = "POURCENTAGE")
    private BigDecimal pourcentage;
	
	@Getter @Setter
	@Column(name = "MONTANT_MINIMUM")
    private BigDecimal montantMinimum;
	
	@PrePersist
    protected void onCreate() {
		dateCreation = LocalDateTime.now();
    }
}
