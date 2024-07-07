package com.buyconnex.buyconnex.entity.client;

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
@Table(name = "PAYS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pays {

	@Id
	@Getter
    @SequenceGenerator(name = "PAYS_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PAYS_SEQ_ID")
    @Column(name = "ID_PAYS")
    private Long pays_id;
	
	@Getter @Setter
	@Column(name = "PAYS")
    private String pays;
	
	@Getter @Setter
	@OneToMany(mappedBy="pays", cascade = CascadeType.ALL)
    private Set<Villes> villes;
}
