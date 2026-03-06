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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "MARQUES")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Marques {

	@Id
    @SequenceGenerator(name = "MARQUES_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MARQUES_SEQ_ID")
    @Column(name = "ID_MARQUES")
    private Long marque_id;
	
	@Column(name = "LIBELLE")
    private String libelle;
	
	@Column(name = "DESCRIPTION")
    private String description;
	
	@OneToMany(mappedBy="marques", cascade = CascadeType.ALL)
    private Set<Articles> articles;
}
