package com.buyconnex.buyconnex.entity.achat;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.buyconnex.buyconnex.entity.client.Clients;
import com.buyconnex.buyconnex.entity.article.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "COMMANDES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Commandes {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name = "COMMANDES_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMANDES_SEQ_ID")
    @Column(name = "ID_COMMANDES")
    private Long commande_id;
	
	@Getter @Setter
	@Column(name = "NUMERO_COMMANDE")
    private String numeroCommande;
	
	@Getter @Setter
    @Column(name = "DATE_COMMANDE")
    private Date dateCommande;
	
	@Getter @Setter
	@JoinColumn(name = "ID_CLIENTS")
    @ManyToOne(targetEntity = Clients.class, fetch = FetchType.EAGER, optional = false)
    private Clients clients;
	
	@Getter @Setter
	@JoinColumn(name = "ID_STATUS_COMMANDES")
    @ManyToOne(targetEntity = StatusCommandes.class, fetch = FetchType.EAGER, optional = false)
    private StatusCommandes statusCommandes;
	
	@Getter @Setter
	@JoinColumn(name = "ID_MOYENS_LIVRAISONS")
    @ManyToOne(targetEntity = MoyensLivraisons.class, fetch = FetchType.EAGER, optional = false)
    private MoyensLivraisons moyensLivraisons;
	
	@JoinColumn(name = "ID_COUPONS")
    @OneToOne(targetEntity = Coupons.class, fetch = FetchType.EAGER, optional = false)
    private Coupons coupons;
	
	@Getter @Setter
	@ManyToMany(mappedBy = "commandes")
    private Set<Articles> articles = new HashSet<>();
	
	@Getter @Setter
	@OneToMany(mappedBy="commandes")
    private Set<Expeditions> expeditions;
	
	@Getter @Setter
	@OneToMany(mappedBy="commandes")
    private Set<Facturations> facturations;
	
	@Getter @Setter
	@OneToMany(mappedBy="commandes")
    private Set<Livraisons> livraisons;
	
}
