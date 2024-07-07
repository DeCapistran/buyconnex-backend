package com.buyconnex.buyconnex.entity.achat;

import com.buyconnex.buyconnex.entity.article.Articles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PROMOTIONS_DETAILS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PromotionsDetails {

	@Id
	@Getter
	@SequenceGenerator(name = "PROMOTIONS_DETAILS_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROMOTIONS_DETAILS_SEQ_ID")
    @Column(name = "ID_PROMOTIONS_DETAILS")
    private Long promotionDetail_id;
	
	@Getter @Setter
    @ManyToOne
	@JoinColumn(name = "ID_ARTICLES")
    private Articles articles;
	
	@Getter @Setter
    @ManyToOne
	@JoinColumn(name = "ID_PROMOTIONS")
    private Promotions promotions;
}
