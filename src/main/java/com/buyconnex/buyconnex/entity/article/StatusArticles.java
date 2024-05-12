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
@Table(name = "STATUS_ARTICLES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatusArticles {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name = "STATUS_ARTICLES_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STATUS_ARTICLES_SEQ_ID")
    @Column(name = "ID_STATUS_ARTICLES")
    private Long status_article_id;
	
	@Getter @Setter
	@Column(name = "STATUS")
    private String status;
	
	@Getter @Setter
	@Column(name = "DESCRIPTION")
    private String description;
	
	@Getter @Setter
	@OneToMany(mappedBy="statusArticles", cascade = CascadeType.ALL)
    private Set<Articles> articles = new HashSet<>();
}
