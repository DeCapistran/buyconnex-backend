package com.buyconnex.buyconnex.entity.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

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
    private Date dateCreation;
    
	@Getter @Setter
    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name="user_role",joinColumns = @JoinColumn(name="user_id") , 
			   inverseJoinColumns = @JoinColumn(name="role_id")) 
	private List<Roles> roles;

}
