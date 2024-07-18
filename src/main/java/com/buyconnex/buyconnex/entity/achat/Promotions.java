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
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PROMOTIONS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Promotions {

	@Id
	@Getter
    @SequenceGenerator(name = "PROMOTIONS_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROMOTIONS_SEQ_ID")
    @Column(name = "ID_PROMOTIONS")
    private Long promotion_id;
	
	@Getter @Setter
	@Column(name = "DATE_CREATION")
    private LocalDateTime dateCreation;
	
	@Getter @Setter
	@Column(name = "DATE_DEBUT")
    private Date dateDebut;
	
	@Getter @Setter
	@Column(name = "DATE_FIN")
    private Date dateFin;
	
	@Getter @Setter
	@Column(name = "POURCENTAGE")
    private int pourcentage;
	
	@Getter @Setter
	@Column(name = "LIBELLE")
    private String libelle;
	
	@Getter @Setter
	@Column(name = "DESCRIPTION")
    private String description;
	
	@Getter @Setter
	@OneToMany(mappedBy="promotions", cascade = CascadeType.ALL)
    private Set<PromotionsDetails> promotionsDetails;
	
	@PrePersist
    protected void onCreate() {
		dateCreation = LocalDateTime.now();
    }

}
