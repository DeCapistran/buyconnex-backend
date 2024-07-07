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
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "MOYENS_PAIEMENTS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MoyensPaiements {

	@Id
	@Getter
    @SequenceGenerator(name = "MOYENS_PAIEMENTS_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MOYENS_PAIEMENTS_SEQ_ID")
    @Column(name = "ID_MOYENS_PAIEMENTS")
    private Long moyen_paiement_id;
	
	@Getter @Setter
	@Column(name = "MOYEN_PAIEMENT")
    private String moyenPaiement;
	
	@Getter @Setter
	@Column(name = "DESCRIPTION")
    private String description;
	
	@Getter @Setter
	@OneToMany(mappedBy="moyensPaiements", cascade = CascadeType.ALL)
    private Set<Paiements> paiements;
}
