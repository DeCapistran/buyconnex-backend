package com.buyconnex.buyconnex.entity.client;

import java.time.LocalDateTime;
import java.util.Set;

import com.buyconnex.buyconnex.entity.user.Users;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
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
@Table(name = "PANIERS")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Paniers {

	@Id
	@Getter
    @SequenceGenerator(name = "PANIERS_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PANIERS_SEQ_ID")
    @Column(name = "ID_PANIERS")
    private Long paniers_id;
	
    @Column(name = "DATE_PANIERS")
    private LocalDateTime datePanier;
	
	@JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
    @OneToOne(targetEntity = Users.class, fetch = FetchType.EAGER, optional = false)
    private Users users;
	
	@OneToMany(mappedBy="paniers", cascade = CascadeType.ALL)
    private Set<PaniersDetails> paniersDetails;
	
	@PrePersist
    protected void onCreate() {
		datePanier = LocalDateTime.now();
    }
}
