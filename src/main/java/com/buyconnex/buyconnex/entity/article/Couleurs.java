package com.buyconnex.buyconnex.entity.article;

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
@Table(name = "COULEURS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Couleurs {

	@Id
	@Getter
    @SequenceGenerator(name = "COULEURS_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COULEURS_SEQ_ID")
    @Column(name = "ID_COULEURS")
    private Long couleur_id;
	
	@Getter @Setter
	@Column(name = "COULEUR")
    private String couleur;
	
	@Getter @Setter
	@Column(name = "CODE_COULEUR")
    private String codeCouleur;
	
	@Getter @Setter
	@OneToMany(mappedBy="couleurs", cascade = CascadeType.ALL)
    private Set<Images> images;
}
