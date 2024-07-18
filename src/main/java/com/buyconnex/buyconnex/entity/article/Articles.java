package com.buyconnex.buyconnex.entity.article;

import java.time.LocalDateTime;
import java.util.Set;

import com.buyconnex.buyconnex.entity.achat.CommandesDetails;
import com.buyconnex.buyconnex.entity.achat.PromotionsDetails;
import com.buyconnex.buyconnex.entity.client.PaniersDetails;

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
@Table(name = "ARTICLES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Articles {

	@Id
	@Getter
    @SequenceGenerator(name = "ARTICLES_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ARTICLES_SEQ_ID")
    @Column(name = "ID_ARTICLES")
    private Long article_id;
	
	@Getter @Setter
	@Column(name = "SKU")
    private String sku;
	
	@Getter @Setter
	@Column(name = "IMG_PATH")
    private String imgPath;
	
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
    private LocalDateTime dateAjout;
	
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
	@OneToMany(mappedBy="articles", cascade = CascadeType.ALL)
    private Set<PromotionsDetails> promotionsDetails;
	
	@Getter @Setter
	@OneToMany(mappedBy="articles", cascade = CascadeType.ALL)
    private Set<CommandesDetails> commandesDetails;	
	
	@Getter @Setter
	@OneToMany(mappedBy="articles", cascade = CascadeType.ALL)
    private Set<PaniersDetails> paniersDetails;
	
	@Getter @Setter
	@OneToMany(mappedBy="articles", cascade = CascadeType.ALL)
    private Set<Avis> avis;
	
	@Getter @Setter
	@OneToMany(mappedBy="articles", cascade = CascadeType.ALL)
    private Set<ArticlesImages> articlesImages;
	
	@Getter @Setter
	@OneToMany(mappedBy="articles", cascade = CascadeType.ALL)
    private Set<TagsArticles> tagsArticles;
	
	@PrePersist
    protected void onCreate() {
		dateAjout = LocalDateTime.now();
    }
}
