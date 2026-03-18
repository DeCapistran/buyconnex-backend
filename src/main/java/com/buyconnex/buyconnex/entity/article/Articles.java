package com.buyconnex.buyconnex.entity.article;

import java.time.LocalDateTime;
import java.util.Set;

import com.buyconnex.buyconnex.entity.achat.CommandesDetails;
import com.buyconnex.buyconnex.entity.achat.PromotionsDetails;
import com.buyconnex.buyconnex.entity.client.PaniersDetails;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
import jakarta.persistence.OneToOne;
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
@Table(name = "ARTICLES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = {"categories", "marques", "boutiques", "tags", "statusArticles", "images",
    "promotionsDetails", "commandesDetails", "paniersDetails", "avis", "articlesImages"})
@ToString(exclude = {"categories", "marques", "boutiques", "tags", "statusArticles", "images",
    "promotionsDetails", "commandesDetails", "paniersDetails", "avis", "articlesImages"})
public class Articles {

    @Id
    @SequenceGenerator(name = "ARTICLES_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ARTICLES_SEQ_ID")
    @Column(name = "ID_ARTICLES")
    private Long article_id;

    @Column(name = "SKU")
    private String sku;

    @Column(name = "IMG_PATH")
    private String imgPath;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "PRIX")
    private Long prix;

    @Column(name = "QUANTITE")
    private int quantite;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "COMPOSITION")
    private String composition;

    @Column(name = "DATE_AJOUT")
    private LocalDateTime dateAjout;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "ID_CATEGORIE")
    private Categories categories;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "ID_MARQUES")
    private Marques marques;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "ID_BOUTIQUES")
    private Boutiques boutiques;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "ID_TAGS")
    private Tags tags;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "ID_STATUS_ARTICLES")
    private StatusArticles statusArticles;

    @JoinColumn(name = "ID_IMAGES", referencedColumnName = "ID_IMAGES")
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JsonManagedReference(value = "article-image")
    private Images images;

    @OneToMany(mappedBy = "articles", cascade = CascadeType.ALL)
    private Set<PromotionsDetails> promotionsDetails;

    @OneToMany(mappedBy = "articles", cascade = CascadeType.ALL)
    private Set<CommandesDetails> commandesDetails;

    @OneToMany(mappedBy = "articles", cascade = CascadeType.ALL)
    private Set<PaniersDetails> paniersDetails;

    @OneToMany(mappedBy = "articles", cascade = CascadeType.ALL)
    private Set<Avis> avis;

    @OneToMany(mappedBy = "articles", cascade = CascadeType.ALL)
    private Set<ArticlesImages> articlesImages;

    @PrePersist
    protected void onCreate() {
        dateAjout = LocalDateTime.now();
    }
}
