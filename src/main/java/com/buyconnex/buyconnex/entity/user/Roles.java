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
import static com.buyconnex.buyconnex.entity.user.Permissions.CLIENT_READ;
import static com.buyconnex.buyconnex.entity.user.Permissions.CLIENT_UPDATE;
import static com.buyconnex.buyconnex.entity.user.Permissions.CLIENT_DELETE;
import static com.buyconnex.buyconnex.entity.user.Permissions.CLIENT_CREATE;

@RequiredArgsConstructor
public enum Roles {
	
	USERS(Collections.emptySet()),
	ADMIN(
          Set.of(
                  ADMIN_READ,
                  ADMIN_UPDATE,
                  ADMIN_DELETE,
                  ADMIN_CREATE,
                  CLIENT_READ,
                  CLIENT_UPDATE,
                  CLIENT_DELETE,
                  CLIENT_CREATE
          )
	  ),
	  CLIENT(
	          Set.of(
	                  CLIENT_READ,
	                  CLIENT_UPDATE,
	                  CLIENT_DELETE,
	                  CLIENT_CREATE
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
	    authorities.add(new SimpleGrantedAuthority("ROLES_" + this.name()));
	    return authorities;
	  }
}
