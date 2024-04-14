package com.buyconnex.buyconnex.entity.achat;

import java.util.Set;

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
@Table(name = "STATUS_COMMANDES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatusCommandes {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name = "STATUS_COMMANDES_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STATUS_COMMANDES_SEQ_ID")
    @Column(name = "ID_STATUS_COMMANDES")
    private Long status_commande_id;
	
	@Getter @Setter
	@Column(name = "STATUS")
    private String status;
	
	@Getter @Setter
	@Column(name = "DESCRIPTION")
    private String description;
	
	@Getter @Setter
	@OneToMany(mappedBy="statusCommandes")
    private Set<Commandes> commandes;
}
