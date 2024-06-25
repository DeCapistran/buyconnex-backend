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
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USERS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    /**
	 * 
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Id
	@Getter
    @SequenceGenerator(name = "USERS_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQ_ID")
    @Column(name = "ID_USER")
    private Long user_id;

	@Getter @Setter
	@Column(name = "USERNAME")
    private String username;
	
	@Getter @Setter
    @Column(name = "EMAIL")
    private String email;

	@Getter @Setter
    @Column(name = "PASSWORD")
    private String password;
    
	@Getter @Setter
    @Column(name = "FIRSTNAME")
    private String firstname;
    
	@Getter @Setter
    @Column(name = "LASTNAME")
    private String lastname;

	@Getter @Setter
    @Column(name = "B_ACTIVATED")
    private boolean bActivated;

	@Getter @Setter
    @Column(name = "DATE_CREATION")
    private LocalDateTime dateCreation;
    
	@Getter @Setter
    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name="user_role",joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name="role_id")) 
	Set<Roles> roles;
	
	@Getter @Setter
	@OneToMany(mappedBy="users", cascade = CascadeType.ALL)
    private Set<Notifications> notifications;
	
	@Getter @Setter
	@OneToMany(mappedBy="users", cascade = CascadeType.ALL)
    private Set<Avis> avis;
	
	@Getter @Setter
	@OneToOne(mappedBy = "users")
	private Paniers paniers;
	
	@Getter @Setter
	@OneToOne(mappedBy = "users")
	private Clients clients;
	
	@Getter @Setter
	@OneToOne(mappedBy = "users")
	private Newsletters newsletters;
	
	@PrePersist
    protected void onCreate() {
		dateCreation = LocalDateTime.now();
    }

}
