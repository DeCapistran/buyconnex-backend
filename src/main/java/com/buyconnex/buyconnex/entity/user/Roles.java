package com.buyconnex.buyconnex.entity.user;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
	@GeneratedValue (strategy=GenerationType.IDENTITY) 
	private Long role_id;
	
	@Getter @Setter
	@Column(name = "ROLE")
	private String role;
	
	@Getter @Setter
	@ManyToMany(mappedBy = "roles")
    private Set<Users> users = new HashSet<>();
}
