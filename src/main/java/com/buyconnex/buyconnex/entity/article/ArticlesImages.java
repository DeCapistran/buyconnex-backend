package com.buyconnex.buyconnex.entity.article;

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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ARTICLES_IMAGES")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticlesImages {

	@Id
	@SequenceGenerator(name = "ARTICLES_IMAGES_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ARTICLES_IMAGES_SEQ_ID")
    @Column(name = "ID_ARTICLES_IMAGES")
    private Long article_image_id;
	
    @ManyToOne
	@JoinColumn(name = "ID_ARTICLES")
    private Articles articles;
	
    @ManyToOne
	@JoinColumn(name = "ID_IMAGES")
    private Images images;
}
