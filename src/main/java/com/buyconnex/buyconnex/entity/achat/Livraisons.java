package com.buyconnex.buyconnex.entity.achat;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import com.buyconnex.buyconnex.entity.client.Adresses;

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
import jakarta.persistence.OneToOne;
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
@Table(name = "LIVRAISONS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Livraisons {

	@Id
	@Getter
    @SequenceGenerator(name = "LIVRAISONS_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LIVRAISONS_SEQ_ID")
    @Column(name = "ID_LIVRAISONS")
    private Long livraison_id;
	
	@Getter @Setter
	@Column(name = "NUMERO_LIVRAISON")
    private String numeroLivraison;
	
	@Getter @Setter
    @Column(name = "DATE_LIVRAISON_ESTIMEE")
    private Date dateLivraisonEstimee;
	
	@Getter @Setter
    @Column(name = "DATE_LIVRAISON")
    private LocalDateTime dateLivraison;
	
	@Getter @Setter
	@Column(name = "COMMENTAIRE")
    private String commentaire;
	
	@Getter @Setter
    @ManyToOne(targetEntity = StatusLivraisons.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ID_STATUS_LIVRAISONS", referencedColumnName = "ID_STATUS_LIVRAISONS")
    private StatusLivraisons statusLivraisons;
	
	@Getter @Setter
	@JoinColumn(name = "ID_ADRESSE", referencedColumnName = "ID_ADRESSE")
    @OneToOne(targetEntity = Adresses.class, fetch = FetchType.EAGER, optional = false)
    private Adresses adresses;
	
	@Getter @Setter
	@OneToMany(mappedBy="livraisons", cascade = CascadeType.ALL)
    private Set<LivraisonsDetails> livraisonsDetails;
	
	@PrePersist
    protected void onCreate() {
		dateLivraison = LocalDateTime.now();
    }
}
