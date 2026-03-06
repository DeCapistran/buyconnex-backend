package com.buyconnex.buyconnex.entity.article;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "CATEGORIES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = {"articles", "images"})
@ToString(exclude = {"articles", "images"})
public class Categories {

    @Id
    @SequenceGenerator(name = "CATEGORIES_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORIES_SEQ_ID")
    @Column(name = "ID_CATEGORIE")
    private Long categorie_id;

    @Column(name = "LIBELLE")
    private String libelle;

    @OneToMany(mappedBy = "categories", cascade = CascadeType.ALL)
    private Set<Articles> articles;

    @JoinColumn(name = "ID_IMAGES", referencedColumnName = "ID_IMAGES")
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JsonManagedReference(value = "categorie-image")
    private Images images;
}

