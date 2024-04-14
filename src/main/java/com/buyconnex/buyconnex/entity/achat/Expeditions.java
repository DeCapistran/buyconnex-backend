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
@Table(name = "EXPEDITIONS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Expeditions {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name = "EXPEDITIONS_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXPEDITIONS_SEQ_ID")
    @Column(name = "ID_EXPEDITIONS")
    private Long expedition_id;
	
	@Getter @Setter
	@Column(name = "COMMENTAIRE")
    private String commentaire;
	
	@Getter @Setter
    @Column(name = "DATE_EXPEDITION")
    private Date dateExpedition;
	
	@Getter @Setter
	@JoinColumn(name = "ID_COMMANDES")
    @ManyToOne(targetEntity = Commandes.class, fetch = FetchType.EAGER, optional = false)
    private Commandes commandes;
}
