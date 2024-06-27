package com.buyconnex.buyconnex.entity.article;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "COULEURS_IMAGES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CouleursImages {

	@Id
	@Getter
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COULEURS_IMAGES")
    private Long livraisonDetail_id;
	
	@Getter @Setter
    @ManyToOne
	@JoinColumn(name = "ID_COULEURS")
    private Couleurs couleurs;
	
	@Getter @Setter
    @ManyToOne
	@JoinColumn(name = "ID_IMAGES")
    private Images images;
}
