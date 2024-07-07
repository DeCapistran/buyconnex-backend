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

	@Id
	@Getter
	@SequenceGenerator(name = "COMMANDES_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMANDES_SEQ_ID")
    @Column(name = "ID_COMMANDES")
    private Long commande_id;
	
	@Getter @Setter
	@Column(name = "NUMERO_COMMANDE")
    private String numeroCommande;
	
	@Getter @Setter
    @Column(name = "DATE_COMMANDE")
    private LocalDateTime dateCommande;
	
	@Getter @Setter
	@Column(name = "CODE_COUPON")
    private String codeCoupon;
	
	@Getter @Setter
    @ManyToOne(targetEntity = Clients.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID_CLIENT")
    private Clients clients;
	
	@Getter @Setter
    @ManyToOne(targetEntity = StatusCommandes.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ID_STATUS_COMMANDES", referencedColumnName = "ID_STATUS_COMMANDES")
    private StatusCommandes statusCommandes;
	
	@Getter @Setter
    @ManyToOne(targetEntity = MoyensLivraisons.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ID_MOYENS_LIVRAISONS", referencedColumnName = "ID_MOYENS_LIVRAISONS")
    private MoyensLivraisons moyensLivraisons;
	
	@Getter @Setter
	@OneToMany(mappedBy="commandes", cascade = CascadeType.ALL)
    private Set<CommandesDetails> commandesDetails;
	
	@Getter @Setter
	@OneToMany(mappedBy="commandes", cascade = CascadeType.ALL)
    private Set<LivraisonsDetails> livraisonsDetails;
	
	@Getter @Setter
	@OneToMany(mappedBy="commandes", cascade = CascadeType.ALL)
    private Set<Expeditions> expeditions;
	
	@Getter @Setter
	@OneToMany(mappedBy="commandes", cascade = CascadeType.ALL)
    private Set<Facturations> facturations;
	
	@PrePersist
    protected void onCreate() {
		dateCommande = LocalDateTime.now();
    }
	
}
