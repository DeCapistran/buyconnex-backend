package com.buyconnex.buyconnex.entity.achat;

import java.time.LocalDateTime;
import java.util.Set;
import com.buyconnex.buyconnex.entity.client.Clients;

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
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "COMMANDES")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Commandes {

	@Id
	@SequenceGenerator(name = "COMMANDES_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMANDES_SEQ_ID")
    @Column(name = "ID_COMMANDES")
    private Long commande_id;
	
	@Column(name = "NUMERO_COMMANDE")
    private String numeroCommande;
	
    @Column(name = "DATE_COMMANDE")
    private LocalDateTime dateCommande;
	
	@Column(name = "CODE_COUPON")
    private String codeCoupon;
	
    @ManyToOne(targetEntity = Clients.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID_CLIENT")
    private Clients clients;
	
    @ManyToOne(targetEntity = StatusCommandes.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ID_STATUS_COMMANDES", referencedColumnName = "ID_STATUS_COMMANDES")
    private StatusCommandes statusCommandes;
	
    @ManyToOne(targetEntity = MoyensLivraisons.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ID_MOYENS_LIVRAISONS", referencedColumnName = "ID_MOYENS_LIVRAISONS")
    private MoyensLivraisons moyensLivraisons;
	
	@OneToMany(mappedBy="commandes", cascade = CascadeType.ALL)
    private Set<CommandesDetails> commandesDetails;
	
	@OneToMany(mappedBy="commandes", cascade = CascadeType.ALL)
    private Set<LivraisonsDetails> livraisonsDetails;
	
	@OneToMany(mappedBy="commandes", cascade = CascadeType.ALL)
    private Set<Expeditions> expeditions;
	
	@OneToMany(mappedBy="commandes", cascade = CascadeType.ALL)
    private Set<Facturations> facturations;
	
	@PrePersist
    protected void onCreate() {
		dateCommande = LocalDateTime.now();
    }
	
}
