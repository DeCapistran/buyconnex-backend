package com.buyconnex.buyconnex.entity.achat;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "PAIEMENTS")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Paiements {

	@Id
    @SequenceGenerator(name = "PAIEMENTS_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PAIEMENTS_SEQ_ID")
    @Column(name = "ID_PAIEMENTS")
    private Long paiement_id;
	
    @Column(name = "DATE_PAIEMENT")
    private LocalDateTime datePaiement;
	
    @Column(name = "MONTANT")
    private Long montant;
	
    @ManyToOne(targetEntity = MoyensPaiements.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ID_MOYENS_PAIEMENTS", referencedColumnName = "ID_MOYENS_PAIEMENTS")
    private MoyensPaiements moyensPaiements;
	
    @ManyToOne(targetEntity = StatusPaiements.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ID_STATUS_PAIEMENTS", referencedColumnName = "ID_STATUS_PAIEMENTS")
    private StatusPaiements statusPaiements;
	
	@PrePersist
    protected void onCreate() {
		datePaiement = LocalDateTime.now();
    }
}
