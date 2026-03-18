package com.buyconnex.buyconnex.entity.achat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "LIVRAISONS_DETAILS")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LivraisonsDetails {

	@Id
	@SequenceGenerator(name = "lIVRAISONS_DETAILS_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LIVRAISONS_DETAILS_SEQ_ID")
    @Column(name = "ID_LIVRAISONS_DETAILS")
    private Long livraisonDetail_id;
	
    @ManyToOne(targetEntity = Commandes.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ID_COMMANDES", referencedColumnName = "ID_COMMANDES")
    private Commandes commandes;
	
    @ManyToOne(targetEntity = Livraisons.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ID_LIVRAISONS", referencedColumnName = "ID_LIVRAISONS")
    private Livraisons livraisons;
}
