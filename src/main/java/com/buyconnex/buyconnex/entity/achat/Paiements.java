package com.buyconnex.buyconnex.entity.achat;

import java.util.Date;

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

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name = "PAIEMENTS_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PAIEMENTS_SEQ_ID")
    @Column(name = "ID_PAIEMENTS")
    private Long paiement_id;
	
	@Getter @Setter
    @Column(name = "DATE_PAIEMENT")
    private Date datePaiement;
	
	@Getter @Setter
    @Column(name = "MONTANT")
    private Long montant;
	
	@Getter @Setter
	@JoinColumn(name = "ID_MOYENS_PAIEMENTS")
    @ManyToOne(targetEntity = MoyensPaiements.class, fetch = FetchType.EAGER, optional = false)
    private MoyensPaiements moyensPaiements;
	
	@Getter @Setter
	@JoinColumn(name = "ID_STATUS_PAIEMENTS")
    @ManyToOne(targetEntity = StatusPaiements.class, fetch = FetchType.EAGER, optional = false)
    private StatusPaiements statusPaiements;
}
