package com.buyconnex.buyconnex.entity.client;

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
@Table(name = "COMMUNES")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Communes {

	@Id
	@Getter
    @SequenceGenerator(name = "COMMUNES_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMUNES_SEQ_ID")
    @Column(name = "ID_COMMUNE")
    private Long commune_id;
	
	@Getter @Setter
	@Column(name = "COMMUNE")
    private String commune;
	
	@Getter @Setter
    @ManyToOne(targetEntity = Villes.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ID_VILLE", referencedColumnName = "ID_VILLE")
    private Villes villes;
}
