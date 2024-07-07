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
@Table(name = "STATUS_PAIEMENTS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatusPaiements {

	@Id
	@Getter
    @SequenceGenerator(name = "STATUS_PAIEMENTS_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STATUS_PAIEMENTS_SEQ_ID")
    @Column(name = "ID_STATUS_PAIEMENTS")
    private Long status_paiement_id;
	
	@Getter @Setter
	@Column(name = "STATUS")
    private String status;
	
	@Getter @Setter
	@Column(name = "DESCRIPTION")
    private String description;
	
	@Getter @Setter
	@OneToMany(cascade = CascadeType.ALL, mappedBy="statusPaiements")
    private Set<Paiements> paiements;
}
