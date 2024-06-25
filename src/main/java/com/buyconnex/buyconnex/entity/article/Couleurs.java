package com.buyconnex.buyconnex.entity.article;

import java.util.Set;

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
@Table(name = "COULEURS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Couleurs {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

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
	@ManyToMany(mappedBy = "couleurs")
    private Set<Images> images;
}
