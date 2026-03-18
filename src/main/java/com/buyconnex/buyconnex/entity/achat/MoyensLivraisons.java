package com.buyconnex.buyconnex.entity.achat;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "MOYENS_LIVRAISONS")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MoyensLivraisons {

	@Id
    @SequenceGenerator(name = "MOYENS_LIVRAISONS_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MOYENS_LIVRAISONS_SEQ_ID")
    @Column(name = "ID_MOYENS_LIVRAISONS")
    private Long moyen_livraison_id;
	
	@Column(name = "MOYEN_LIVRAISON")
    private String moyenLivraison;
	
	@Column(name = "DESCRIPTION")
    private String description;
	
	@OneToMany(mappedBy="moyensLivraisons", cascade = CascadeType.ALL)
    private Set<Commandes> commandes;
}
