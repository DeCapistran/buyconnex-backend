package com.buyconnex.buyconnex.entity.user;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import static com.buyconnex.buyconnex.entity.user.Permissions.ADMIN_READ;
import static com.buyconnex.buyconnex.entity.user.Permissions.ADMIN_UPDATE;
import static com.buyconnex.buyconnex.entity.user.Permissions.ADMIN_DELETE;
import static com.buyconnex.buyconnex.entity.user.Permissions.ADMIN_CREATE;
import static com.buyconnex.buyconnex.entity.user.Permissions.MANAGER_READ;
import static com.buyconnex.buyconnex.entity.user.Permissions.MANAGER_UPDATE;
import static com.buyconnex.buyconnex.entity.user.Permissions.MANAGER_DELETE;
import static com.buyconnex.buyconnex.entity.user.Permissions.MANAGER_CREATE;

@RequiredArgsConstructor
public enum Roles {
	
	USERS(Collections.emptySet()),
	ADMIN(
          Set.of(
                  ADMIN_READ,
                  ADMIN_UPDATE,
                  ADMIN_DELETE,
                  ADMIN_CREATE,
                  MANAGER_READ,
                  MANAGER_UPDATE,
                  MANAGER_DELETE,
                  MANAGER_CREATE
          )
	  ),
	  MANAGER(
	          Set.of(
	                  MANAGER_READ,
	                  MANAGER_UPDATE,
	                  MANAGER_DELETE,
	                  MANAGER_CREATE
	          )
	  )

	  ;

	  @Getter
	  private final Set<Permissions> permissions;

	  public List<SimpleGrantedAuthority> getAuthorities() {
	    var authorities = getPermissions()
	            .stream()
	            .map(permission -> new SimpleGrantedAuthority(permission.getPermissions()))
	            .collect(Collectors.toList());
	    authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
	    return authorities;
	  }
}
