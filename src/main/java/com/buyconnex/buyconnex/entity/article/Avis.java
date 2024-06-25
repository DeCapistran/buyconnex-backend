package com.buyconnex.buyconnex.entity.article;

import java.time.LocalDateTime;

import com.buyconnex.buyconnex.entity.user.Users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "AVIS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Avis {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Id
	@Getter
    @SequenceGenerator(name = "AVIS_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AVIS_SEQ_ID")
    @Column(name = "ID_AVIS")
    private Long avis_id;
	
	@Getter @Setter
	@Column(name = "DATE_AVIS")
    private LocalDateTime dateAvis;
	
	@Getter @Setter
	@Column(name = "ETOILE")
    private int etoile;
	
	@Getter @Setter
	@Column(name = "COMMENTAIRE")
    private String commentaire;
	
	@Getter @Setter
    @ManyToOne(targetEntity = Articles.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ID_ARTICLES", referencedColumnName = "ID_ARTICLES")
    private Articles articles;
	
	@Getter @Setter
    @ManyToOne(targetEntity = Users.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
    private Users users;
	
	@PrePersist
    protected void onCreate() {
		dateAvis = LocalDateTime.now();
    }
}
