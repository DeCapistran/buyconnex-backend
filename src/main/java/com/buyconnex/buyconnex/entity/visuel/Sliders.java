package com.buyconnex.buyconnex.entity.visuel;

import com.buyconnex.buyconnex.entity.article.Images;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "SLIDERS")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sliders {

	@Id
    @SequenceGenerator(name = "SLIDERS_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SLIDERS_SEQ_ID")
    @Column(name = "ID_SLIDER")
    private Long slider_id;
	
	@Column(name = "TITTLE")
    private String tittle;
	
	@JoinColumn(name = "ID_IMAGES", referencedColumnName = "ID_IMAGES")
    @OneToOne(targetEntity = Images.class, fetch = FetchType.EAGER, optional = false)
	@JsonManagedReference(value = "slider-image")
    private Images images;
}
