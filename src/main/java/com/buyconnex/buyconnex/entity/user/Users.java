package com.buyconnex.buyconnex.entity.user;

import java.time.LocalDateTime;
import java.util.Set;

import com.buyconnex.buyconnex.entity.article.Avis;
import com.buyconnex.buyconnex.entity.client.Clients;
import com.buyconnex.buyconnex.entity.client.Paniers;
import com.buyconnex.buyconnex.entity.others.Newsletters;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name = "USERS")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Users {

	@Id
    @SequenceGenerator(name = "USERS_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQ_ID")
    @Column(name = "ID_USER")
    private Long user_id;

	@Column(name = "USERNAME")
    private String username;
	
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;
    
    @Column(name = "FIRSTNAME")
    private String firstname;
    
    @Column(name = "LASTNAME")
    private String lastname;

    @Column(name = "B_ACTIVATED")
    private boolean bActivated;

    @Column(name = "DATE_CREATION")
    private LocalDateTime dateCreation;
    
    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name="user_role",joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name="role_id")) 
	Set<Roles> roles;
	
	@OneToMany(mappedBy="users", cascade = CascadeType.ALL)
    private Set<Notifications> notifications;
	
	@OneToMany(mappedBy="users", cascade = CascadeType.ALL)
    private Set<Avis> avis;
	
	@OneToOne(mappedBy = "users", cascade = CascadeType.ALL)
	private Paniers paniers;
	
	@OneToOne(mappedBy = "users", cascade = CascadeType.ALL)
	private Clients clients;

	@OneToOne(mappedBy = "users", cascade = CascadeType.ALL)
	private Newsletters newsletters;
	
	@PrePersist
    protected void onCreate() {
		dateCreation = LocalDateTime.now();
    }

}
