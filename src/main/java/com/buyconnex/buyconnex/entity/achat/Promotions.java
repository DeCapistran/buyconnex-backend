package com.buyconnex.buyconnex.entity.achat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "PROMOTIONS")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Promotions {

	@Id
    @SequenceGenerator(name = "PROMOTIONS_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROMOTIONS_SEQ_ID")
    @Column(name = "ID_PROMOTIONS")
    private Long promotion_id;
	
	@Column(name = "DATE_CREATION")
    private LocalDateTime dateCreation;
	
	@Column(name = "DATE_DEBUT")
    private Date dateDebut;
	
	@Column(name = "DATE_FIN")
    private Date dateFin;
	
	@Column(name = "POURCENTAGE")
    private int pourcentage;
	
	@Column(name = "LIBELLE")
    private String libelle;
	
	@Column(name = "DESCRIPTION")
    private String description;
	
	@OneToMany(mappedBy="promotions", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PromotionsDetails> promotionsDetails;
	
	@PrePersist
    protected void onCreate() {
		dateCreation = LocalDateTime.now();
    }

}
