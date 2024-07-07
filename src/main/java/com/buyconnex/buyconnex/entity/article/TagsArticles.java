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
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TAGS_ARTICLES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TagsArticles {

	@Id
	@Getter
	@SequenceGenerator(name = "TAGS_ARTICLES_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TAGS_ARTICLES_SEQ_ID")
    @Column(name = "ID_TAGS_ARTICLES")
    private Long tag_article_id;
	
	@Getter @Setter
    @ManyToOne
	@JoinColumn(name = "ID_ARTICLES")
    private Articles articles;
	
	@Getter @Setter
    @ManyToOne
	@JoinColumn(name = "ID_TAGS")
    private Tags tags;
}
