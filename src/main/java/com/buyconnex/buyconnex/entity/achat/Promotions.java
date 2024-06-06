package com.buyconnex.buyconnex.entity.achat;

import java.util.Date;
import java.util.Set;

import com.buyconnex.buyconnex.entity.article.Articles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
	
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name = "PROMOTIONS_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROMOTIONS_SEQ_ID")
    @Column(name = "ID_PROMOTIONS")
    private Long promotion_id;
	
	@Getter @Setter
	@Column(name = "DATE_CREATION")
    private Date dateCreation;
	
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
	@ManyToMany(mappedBy = "promotions")
    private Set<Articles> articles;

}
