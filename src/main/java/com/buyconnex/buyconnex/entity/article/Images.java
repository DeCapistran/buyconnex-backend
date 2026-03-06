package com.buyconnex.buyconnex.entity.article;

import java.util.Set;

import com.buyconnex.buyconnex.entity.visuel.Sliders;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "IMAGES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = {"categories", "articles", "sliders", "boutiques", "articlesImages"})
@ToString(exclude = {"categories", "articles", "sliders", "boutiques", "articlesImages"})
public class Images {

    @Id
    @SequenceGenerator(name = "IMAGES_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IMAGES_SEQ_ID")
    @Column(name = "ID_IMAGES")
    private Long image_id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "URL")
    private String url;

    @Column(name = "IMAGE", length = 4048576)
    @Lob
    private byte[] image;

    @OneToOne(mappedBy = "images", cascade = CascadeType.ALL)
    @JsonBackReference(value = "categorie-image")
    private Categories categories;

    @OneToOne(mappedBy = "images", cascade = CascadeType.ALL)
    @JsonBackReference(value = "article-image")
    private Articles articles;

    @OneToOne(mappedBy = "images", cascade = CascadeType.ALL)
    @JsonBackReference(value = "slider-image")
    private Sliders sliders;

    @OneToOne(mappedBy = "images", cascade = CascadeType.ALL)
    @JsonBackReference(value = "boutique-image")
    private Boutiques boutiques;

    @OneToMany(mappedBy = "images", cascade = CascadeType.ALL)
    private Set<ArticlesImages> articlesImages;
}
