package com.buyconnex.buyconnex.entity.article;

import java.util.Set;

import com.buyconnex.buyconnex.entity.visuel.Sliders;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

	@Id
	@Getter
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
	
	@Getter @Setter
    @ManyToOne(targetEntity = Couleurs.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ID_COULEURS", referencedColumnName = "ID_COULEURS")
    private Couleurs couleurs;
	
	@Getter @Setter
	@OneToOne(mappedBy = "images")
	private Categories categories;
	
	@Getter @Setter
	@OneToOne(mappedBy = "images")
	private Sliders sliders;
	
	@Getter @Setter
	@OneToMany(mappedBy="images", cascade = CascadeType.ALL)
    private Set<ArticlesImages> articlesImages;
}
