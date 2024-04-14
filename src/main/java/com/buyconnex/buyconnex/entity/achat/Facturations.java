package com.buyconnex.buyconnex.entity.achat;

import java.util.Date;

import com.buyconnex.buyconnex.entity.client.Adresses;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "FACTURATIONS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Facturations {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name = "FACTURATIONS_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FACTURATIONS_SEQ_ID")
    @Column(name = "ID_FACTURATIONS")
    private Long facturation_id;
	
	@Getter @Setter
    @Column(name = "DATE_FACTURATION")
    private Date dateFacturation;
	
	@Getter @Setter
	@Column(name = "DESCRIPTION")
    private String description;
	
	@Getter @Setter
	@JoinColumn(name = "ID_COMMANDES")
    @ManyToOne(targetEntity = Commandes.class, fetch = FetchType.EAGER, optional = false)
    private Commandes commandes;
	
	@Getter @Setter
	@JoinColumn(name = "ID_ADRESSE")
    @OneToOne(targetEntity = Adresses.class, fetch = FetchType.EAGER, optional = false)
    private Adresses adresse;
}
