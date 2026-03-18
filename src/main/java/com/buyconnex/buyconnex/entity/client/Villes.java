package com.buyconnex.buyconnex.entity.client;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "VILLES")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Villes {

	@Id
    @SequenceGenerator(name = "VILLES_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VILLES_SEQ_ID")
    @Column(name = "ID_VILLE")
    private Long ville_id;
	
	@Column(name = "VILLE")
    private String ville;
	
	@OneToMany(mappedBy="villes", cascade = CascadeType.ALL)
    private Set<Communes> communes;
	
    @ManyToOne(targetEntity = Pays.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ID_PAYS", referencedColumnName = "ID_PAYS")
    private Pays pays;
}
