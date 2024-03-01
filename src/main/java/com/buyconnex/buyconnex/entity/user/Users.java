package com.buyconnex.buyconnex.entity.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    @Column(name = "B_AUTHENTICATE")
    private boolean bAuthenticate;

    @Column(name = "B_LOCKED")
    private boolean bLocked;

    @Column(name = "DATE_CREATION")
    private Date dateCreation;
    
    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name="user_role",joinColumns = @JoinColumn(name="user_id") , 
			   inverseJoinColumns = @JoinColumn(name="role_id")) 
	private List<Roles> roles;

    public String getPassword() {
      return password;
    }

    public String getUsername() {
      return email;
    }

    public boolean isAccountNonExpired() {
      return true;
    }

    public boolean isAccountNonLocked() {
      return true;
    }

    public boolean isCredentialsNonExpired() {
      return true;
    }

    public boolean isEnabled() {
      return true;
    }

}
