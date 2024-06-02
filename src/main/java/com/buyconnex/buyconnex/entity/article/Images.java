package com.buyconnex.buyconnex.entity.article;

import java.util.HashSet;
import java.util.Set;

import com.buyconnex.buyconnex.entity.visuel.Sliders;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name = "IMAGES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Images {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name = "IMAGES_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IMAGES_SEQ_ID")
    @Column(name = "ID_IMAGES")
    private Long image_id;
	
	@Getter @Setter
	@Column(name = "NAME")
    private String name;
	
	@Getter @Setter
	@Column(name = "TYPE")
    private String type;
	
	@Column( name = "IMAGE" , length = 4048576 ) 
	@Lob
	private byte[] image; 
	
	@ManyToOne
	@JoinColumn (name="ID_ARTICLES")
	@JsonIgnore
	private Articles articles;
	
	@Getter @Setter
	@OneToOne(mappedBy = "images")
	private Categories categories;
	
	@Getter @Setter
	@OneToOne(mappedBy = "images")
	private Sliders sliders;
	
	@Getter @Setter
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "IMAGES_COULEURS", joinColumns = { @JoinColumn(name = "image_id") }, inverseJoinColumns = { @JoinColumn(name = "couleur_id") })
	Set<Couleurs> couleurs = new HashSet<>();
}
