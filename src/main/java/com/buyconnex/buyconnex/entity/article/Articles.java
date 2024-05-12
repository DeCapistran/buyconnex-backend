package com.buyconnex.buyconnex.entity.article;

import com.buyconnex.buyconnex.entity.achat.*;
import com.buyconnex.buyconnex.entity.client.Communes;
import com.buyconnex.buyconnex.entity.client.Paniers;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name = "ARTICLES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Articles {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name = "ARTICLES_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ARTICLES_SEQ_ID")
    @Column(name = "ID_ARTICLES")
    private Long article_id;
	
	@Getter @Setter
	@Column(name = "SKU")
    private String sku;
	
	@Getter @Setter
	@Column(name = "IMG")
    private String img;
	
	@Getter @Setter
	@Column(name = "TITLE")
    private String title;
	
	@Getter @Setter
	@Column(name = "PRIX")
    private Long prix;
	
	@Getter @Setter
	@Column(name = "QUANTITE")
    private int quantite;
	
	@Getter @Setter
	@Column(name = "DESCRIPTION")
    private String description;
	
	@Getter @Setter
	@Column(name = "COMPOSITION")
    private String composition;
	
	@Getter @Setter
	@Column(name = "DATE_AJOUT")
    private Date dateAjout;
	
	@Getter @Setter
    @ManyToOne(targetEntity = Categories.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ID_CATEGORIE", referencedColumnName = "ID_CATEGORIE")
    private Categories categories;
	
	@Getter @Setter
    @ManyToOne(targetEntity = Marques.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ID_MARQUES", referencedColumnName = "ID_MARQUES")
    private Marques marques;
	
	@Getter @Setter
    @ManyToOne(targetEntity = Boutiques.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ID_BOUTIQUES", referencedColumnName = "ID_BOUTIQUES")
    private Boutiques boutiques;
	
	@Getter @Setter
    @ManyToOne(targetEntity = StatusArticles.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ID_STATUS_ARTICLES", referencedColumnName = "ID_STATUS_ARTICLES")
    private StatusArticles statusArticles;
	
	@Getter @Setter
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "PROMOTIONS_DETAILS", joinColumns = { @JoinColumn(name = "article_id") }, inverseJoinColumns = { @JoinColumn(name = "promotion_id") })
	Set<Promotions> promotions = new HashSet<>();
	
	@Getter @Setter
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "TAGS_DETAILS", joinColumns = { @JoinColumn(name = "article_id") }, inverseJoinColumns = { @JoinColumn(name = "tags_id") })
	Set<Tags> tags = new HashSet<>();
	
	@Getter @Setter
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "COMMANDES_DETAILS", joinColumns = { @JoinColumn(name = "articles_id") }, inverseJoinColumns = { @JoinColumn(name = "commandes_id") })
	Set<Commandes> commandes = new HashSet<>();
	
	@Getter @Setter
    @ManyToOne(targetEntity = Paniers.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ID_PANIERS", referencedColumnName = "ID_PANIERS")
    private Paniers paniers;
	
	@Getter @Setter
	@OneToMany(mappedBy="articles", cascade = CascadeType.ALL)
    private Set<Avis> avis = new HashSet<>();
}
