package com.buyconnex.buyconnex.entity.client;

import java.util.Set;

import com.buyconnex.buyconnex.entity.achat.Commandes;
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
@Table(name = "CLIENTS")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Clients {

	@Id
    @SequenceGenerator(name = "CLIENTS_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENTS_SEQ_ID")
    @Column(name = "ID_CLIENT")
    private Long client_id;
	
	@Column(name = "FIRSTNAME")
    private String fristname;
	
	@Column(name = "LASTNAME")
    private String lastname;
	
	@Column(name = "ENTREPRISE")
    private String entreprise;
	
	@Column(name = "GENRE")
    private String genre;
	
	@Column(name = "FACEBOOK")
    private String facebook;
	
	@Column(name = "INSTAGRAM")
    private String instagram;
	
	@Column(name = "TELEPHONE1")
    private String telephone1;
	
	@Column(name = "TELEPHONE2")
    private String telephone2;
	
	@JoinColumn(name = "ID_ADRESSE", referencedColumnName = "ID_ADRESSE")
    @OneToOne(targetEntity = Adresses.class, fetch = FetchType.EAGER, optional = false)
    private Adresses adresses;
	
	@JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
    @OneToOne(targetEntity = Users.class, fetch = FetchType.EAGER, optional = false)
    private Users users;
	
	@OneToMany(mappedBy="clients", cascade = CascadeType.ALL)
    private Set<Commandes> commandes;
	

}
