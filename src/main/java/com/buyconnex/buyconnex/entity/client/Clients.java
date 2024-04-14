package com.buyconnex.buyconnex.entity.client;

import java.util.Set;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.entity.user.Users;

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
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CLIENTS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Clients {
	
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name = "CLIENTS_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENTS_SEQ_ID")
    @Column(name = "ID_CLIENT")
    private Long client_id;
	
	@Getter @Setter
	@Column(name = "FIRSTNAME")
    private String fristname;
	
	@Getter @Setter
	@Column(name = "LASTNAME")
    private String lastname;
	
	@Getter @Setter
	@Column(name = "ENTREPRISE")
    private String entreprise;
	
	@Getter @Setter
	@Column(name = "GENRE")
    private String genre;
	
	@Getter @Setter
	@Column(name = "FACEBOOK")
    private String facebook;
	
	@Getter @Setter
	@Column(name = "INSTAGRAM")
    private String instagram;
	
	@Getter @Setter
	@Column(name = "TELEPHONE1")
    private String telephone1;
	
	@Getter @Setter
	@Column(name = "TELEPHONE2")
    private String telephone2;
	
	@Getter @Setter
	@JoinColumn(name = "ID_ADRESSE")
    @OneToOne(targetEntity = Adresses.class, fetch = FetchType.EAGER, optional = false)
    private Adresses adresse;
	
	@Getter @Setter
	@OneToMany(mappedBy="clients")
    private Set<Commandes> commandes;
	
	@Getter @Setter
	@OneToOne(mappedBy = "clients")
	private Users users;

}
