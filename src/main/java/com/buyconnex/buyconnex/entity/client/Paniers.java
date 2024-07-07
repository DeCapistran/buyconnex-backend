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
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PANIERS")
@Data
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
	
	@Getter @Setter
    @Column(name = "DATE_PANIERS")
    private LocalDateTime datePanier;
	
	@Getter @Setter
	@JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
    @OneToOne(targetEntity = Users.class, fetch = FetchType.EAGER, optional = false)
    private Users users;
	
	@Getter @Setter
	@OneToMany(mappedBy="paniers", cascade = CascadeType.ALL)
    private Set<PaniersDetails> paniersDetails;
	
	@PrePersist
    protected void onCreate() {
		datePanier = LocalDateTime.now();
    }
}
