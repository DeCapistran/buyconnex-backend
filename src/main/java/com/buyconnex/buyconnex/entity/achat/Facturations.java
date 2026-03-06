package com.buyconnex.buyconnex.entity.achat;

import java.time.LocalDateTime;

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
@Table(name = "FACTURATIONS")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Facturations {

	@Id
    @SequenceGenerator(name = "FACTURATIONS_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FACTURATIONS_SEQ_ID")
    @Column(name = "ID_FACTURATIONS")
    private Long facturation_id;
	
    @Column(name = "DATE_FACTURATION")
    private LocalDateTime dateFacturation;
	
	@Column(name = "DESCRIPTION")
    private String description;
	
    @ManyToOne(targetEntity = Commandes.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ID_COMMANDES", referencedColumnName = "ID_COMMANDES")
    private Commandes commandes;
	
	@JoinColumn(name = "ID_ADRESSE", referencedColumnName = "ID_ADRESSE")
    @OneToOne(targetEntity = Adresses.class, fetch = FetchType.EAGER, optional = false)
    private Adresses adresses;
	
	@PrePersist
    protected void onCreate() {
		dateFacturation = LocalDateTime.now();
    }
}
