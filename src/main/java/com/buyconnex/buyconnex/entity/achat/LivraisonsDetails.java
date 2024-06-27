package com.buyconnex.buyconnex.entity.achat;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

public class LivraisonsDetails {

	@Id
	@Getter
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LIVRAISONS_DETAILS")
    private Long livraisonDetail_id;
	
	@Getter @Setter
    @ManyToOne(targetEntity = Commandes.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ID_COMMANDES", referencedColumnName = "ID_COMMANDES")
    private Commandes commandes;
	
	@Getter @Setter
    @ManyToOne(targetEntity = Livraisons.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ID_LIVRAISONS", referencedColumnName = "ID_LIVRAISONS")
    private Livraisons livraisons;
}
