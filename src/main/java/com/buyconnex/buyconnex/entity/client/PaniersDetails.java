package com.buyconnex.buyconnex.entity.client;

import com.buyconnex.buyconnex.entity.article.Articles;

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
@Table(name = "PANIERS_DETAILS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaniersDetails {

	@Id
	@Getter
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PANIERS_DETAILS")
    private Long panierDetail_id;
	
	@Getter @Setter
    @ManyToOne
	@JoinColumn(name = "ID_ARTICLES")
    private Articles articles;
	
	@Getter @Setter
    @ManyToOne
	@JoinColumn(name = "ID_PANIERS")
    private Paniers paniers;
}
