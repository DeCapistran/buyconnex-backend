package com.buyconnex.buyconnex.entity.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.buyconnex.buyconnex.entity.security.Token;

@Entity
@Table(name = "USERS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Users implements UserDetails {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name = "USERS_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQ_ID")
    @Column(name = "ID_USER")
    private Long id;

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

    @Enumerated(EnumType.STRING)
    private Roles roles;

    @OneToMany(mappedBy = "users")
    private List<Token> tokens;
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
      return roles.getAuthorities();
    }

    @Override
    public String getPassword() {
      return password;
    }

    @Override
    public String getUsername() {
      return email;
    }

    @Override
    public boolean isAccountNonExpired() {
      return true;
    }

    @Override
    public boolean isAccountNonLocked() {
      return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
      return true;
    }

    @Override
    public boolean isEnabled() {
      return true;
    }

}
