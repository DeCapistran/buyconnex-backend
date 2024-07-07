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
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PAIEMENTS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Paiements {

	@Id
	@Getter
    @SequenceGenerator(name = "PAIEMENTS_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PAIEMENTS_SEQ_ID")
    @Column(name = "ID_PAIEMENTS")
    private Long paiement_id;
	
	@Getter @Setter
    @Column(name = "DATE_PAIEMENT")
    private LocalDateTime datePaiement;
	
	@Getter @Setter
    @Column(name = "MONTANT")
    private Long montant;
	
	@Getter @Setter
    @ManyToOne(targetEntity = MoyensPaiements.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ID_MOYENS_PAIEMENTS", referencedColumnName = "ID_MOYENS_PAIEMENTS")
    private MoyensPaiements moyensPaiements;
	
	@Getter @Setter
    @ManyToOne(targetEntity = StatusPaiements.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ID_STATUS_PAIEMENTS", referencedColumnName = "ID_STATUS_PAIEMENTS")
    private StatusPaiements statusPaiements;
	
	@PrePersist
    protected void onCreate() {
		datePaiement = LocalDateTime.now();
    }
}
