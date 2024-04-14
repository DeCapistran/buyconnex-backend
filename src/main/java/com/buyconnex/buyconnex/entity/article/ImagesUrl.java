package com.buyconnex.buyconnex.entity.article;

import java.util.HashSet;
import java.util.Set;

import com.buyconnex.buyconnex.entity.achat.Promotions;

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
@Table(name = "IMAGES_URL")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImagesUrl {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name = "IMAGES_URL_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IMAGES_URL_SEQ_ID")
    @Column(name = "ID_IMAGES_URL")
    private Long image_url_id;
	
	@Getter @Setter
	@Column(name = "IMG")
    private String img;
	
	@Getter @Setter
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "IMAGES_URL_COULEURS", joinColumns = { @JoinColumn(name = "image_url_id") }, inverseJoinColumns = { @JoinColumn(name = "couleur_id") })
	Set<Couleurs> couleurs = new HashSet<>();
}
