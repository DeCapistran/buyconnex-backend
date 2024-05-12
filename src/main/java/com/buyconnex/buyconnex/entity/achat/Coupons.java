package com.buyconnex.buyconnex.entity.achat;

import java.util.Date;
import java.util.Set;
import java.util.HashSet;

import com.buyconnex.buyconnex.entity.article.SousCategories;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name = "COUPONS_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COUPONS_SEQ_ID")
    @Column(name = "ID_COUPONS")
    private Long coupon_id;
	
	@Getter @Setter
	@Column(name = "LIBELLE")
    private String libelle;
	
	@Getter @Setter
	@Column(name = "LOGO")
    private String logo;
	
	@Getter @Setter
	@Column(name = "CODE_COUPON")
    private String codeCoupon;
	
	@Getter @Setter
	@Column(name = "DATE_CREATION")
    private Date dateCreation;
	
	@Getter @Setter
	@Column(name = "DATE_DEBUT")
    private Date dateDebut;
	
	@Getter @Setter
	@Column(name = "DATE_FIN")
    private Date dateFin;
	
	@Getter @Setter
	@Column(name = "POURCENTAGE")
    private int pourcentage;
	
	@Getter @Setter
	@Column(name = "MONTANT_MINIMUM")
    private Long montantMinimum;
	
	@Getter @Setter
    @ManyToOne(targetEntity = SousCategories.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ID_SOUS_CATEGORIE", referencedColumnName = "ID_SOUS_CATEGORIE")
    private SousCategories sousCategories;
	
	@Getter @Setter
	@OneToMany(mappedBy="coupons", cascade = CascadeType.ALL)
    private Set<Commandes> commandes = new HashSet<>();
}
