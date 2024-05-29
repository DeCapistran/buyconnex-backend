package com.buyconnex.buyconnex.entity.article;

import java.util.Set;

import com.buyconnex.buyconnex.entity.client.Adresses;

import java.util.HashSet;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
@Table(name = "CATEGORIES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Categories {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name = "CATEGORIES_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORIES_SEQ_ID")
    @Column(name = "ID_CATEGORIE")
    private Long categorie_id;
	
	@Getter @Setter
	@Column(name = "LIBELLE")
    private String libelle;
	
	@Getter @Setter
	@Column(name = "IMG")
    private String img;
	
	@Getter @Setter
	@OneToMany(mappedBy="categories", cascade = CascadeType.ALL)
    private Set<Articles> articles = new HashSet<>();
	
	@Getter @Setter
	@OneToMany(mappedBy="categories", cascade = CascadeType.ALL)
    private Set<SousCategories> sousCategorie = new HashSet<>();
	
	@Getter @Setter
	@JoinColumn(name = "ID_IMAGES")
    @OneToOne(targetEntity = Images.class, fetch = FetchType.EAGER, optional = false)
    private Images images;
}
