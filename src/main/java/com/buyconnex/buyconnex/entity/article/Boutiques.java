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
@Table(name = "BOUTIQUES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = {"articles", "images"})
@ToString(exclude = {"articles", "images"})
public class Boutiques {

    @Id
    @SequenceGenerator(name = "BOUTIQUES_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOUTIQUES_SEQ_ID")
    @Column(name = "ID_BOUTIQUES")
    private Long boutique_id;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "TELEPHONE")
    private String telephone;

    @OneToMany(mappedBy = "boutiques", cascade = CascadeType.ALL)
    private Set<Articles> articles;

    @JoinColumn(name = "ID_IMAGES", referencedColumnName = "ID_IMAGES")
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JsonManagedReference(value = "boutique-image")
    private Images images;
}
