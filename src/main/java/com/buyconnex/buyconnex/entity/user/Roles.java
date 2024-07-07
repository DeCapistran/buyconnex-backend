package com.buyconnex.buyconnex.entity.user;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data 
@NoArgsConstructor 
@AllArgsConstructor
@Entity
public class Roles {

	@Id 
	@Getter
	@SequenceGenerator(name = "ROLES_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLES_SEQ_ID") 
	private Long role_id;
	
	@Getter @Setter
	@Column(name = "ROLE")
	private String role;
	
	@Getter @Setter
	@ManyToMany(mappedBy = "roles")
    private Set<Users> users = new HashSet<>();
}
