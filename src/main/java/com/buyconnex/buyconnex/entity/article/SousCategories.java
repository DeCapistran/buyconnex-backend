package com.buyconnex.buyconnex.entity.article;

import java.util.Set;

import com.buyconnex.buyconnex.entity.achat.Coupons;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "SOUS_CATEGORIES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SousCategories {
	
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Id
	@Getter
    @SequenceGenerator(name = "SOUS_CATEGORIES_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SOUS_CATEGORIES_SEQ_ID")
    @Column(name = "ID_SOUS_CATEGORIE")
    private Long sous_categorie_id;
	
	@Getter @Setter
	@Column(name = "LIBELLE")
    private String libelle;
	
	@Getter @Setter
    @ManyToOne(targetEntity = Categories.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ID_CATEGORIE", referencedColumnName = "ID_CATEGORIE")
    private Categories categories;
	
	@Getter @Setter
	@OneToMany(mappedBy="sousCategories", cascade = CascadeType.ALL)
    private Set<Coupons> coupons;

}
