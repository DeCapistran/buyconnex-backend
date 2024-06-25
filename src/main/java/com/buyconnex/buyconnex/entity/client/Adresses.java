package com.buyconnex.buyconnex.entity.client;

import com.buyconnex.buyconnex.entity.achat.Facturations;
import com.buyconnex.buyconnex.entity.achat.Livraisons;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ADRESSES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Adresses {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Id
	@Getter
    @SequenceGenerator(name = "ADRESSES_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADRESSES_SEQ_ID")
    @Column(name = "ID_ADRESSE")
    private Long adresse_id;
	
	@JoinColumn(name = "ID_PAYS")
    @OneToOne(targetEntity = Pays.class, fetch = FetchType.EAGER, optional = false)
    private Pays pays;
	
	@JoinColumn(name = "ID_VILLE")
    @OneToOne(targetEntity = Villes.class, fetch = FetchType.EAGER, optional = false)
    private Villes ville;
	
	@JoinColumn(name = "ID_COMMUNE")
    @OneToOne(targetEntity = Communes.class, fetch = FetchType.EAGER, optional = false)
    private Communes commune;
	
	@Getter @Setter
	@Column(name = "ADRESSE1")
    private String adresse1;
	
	@Getter @Setter
	@Column(name = "ADRESSE2")
    private String adresse2;
	
	@Getter @Setter
	@Column(name = "CODE_POSTAL")
    private int codePostal;
	
	@Getter @Setter
	@Column(name = "DESCRIPTION")
    private String description;
	
	@Getter @Setter
	@OneToOne(mappedBy = "adresses")
	private Clients clients;
	
	@Getter @Setter
	@OneToOne(mappedBy = "adresses")
	private Facturations facturations;
	
	@Getter @Setter
	@OneToOne(mappedBy = "adresses")
	private Livraisons livraisons;
	
}
