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
@Table(name = "STATUS_PAIEMENTS")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatusPaiements {

	@Id
    @SequenceGenerator(name = "STATUS_PAIEMENTS_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STATUS_PAIEMENTS_SEQ_ID")
    @Column(name = "ID_STATUS_PAIEMENTS")
    private Long status_paiement_id;
	
	@Column(name = "STATUS")
    private String status;
	
	@Column(name = "DESCRIPTION")
    private String description;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="statusPaiements")
    private Set<Paiements> paiements;
}
