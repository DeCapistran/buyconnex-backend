package com.buyconnex.buyconnex.entity.article;

import java.util.Set;
import java.util.HashSet;
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
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "BOUTIQUES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Boutiques {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name = "BOUTIQUES_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOUTIQUES_SEQ_ID")
    @Column(name = "ID_BOUTIQUES")
    private Long boutique_id;
	
	@Getter @Setter
	@Column(name = "NOM")
    private String nom;
	
	@Getter @Setter
	@Column(name = "EMAIL")
    private String email;
	
	@Getter @Setter
	@Column(name = "TELEPHONE")
    private String telephone;
	
	@Getter @Setter
	@Column(name = "IMG")
    private String img;
	
	@Getter @Setter
	@OneToMany(mappedBy="boutiques", cascade = CascadeType.ALL)
    private Set<Articles> articles = new HashSet<>();
}
