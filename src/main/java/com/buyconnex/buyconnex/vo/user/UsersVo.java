package com.buyconnex.buyconnex.vo.user;


import java.time.LocalDateTime;
import java.util.Set;

import com.buyconnex.buyconnex.entity.article.Avis;
import com.buyconnex.buyconnex.entity.client.Clients;
import com.buyconnex.buyconnex.entity.client.Paniers;
import com.buyconnex.buyconnex.entity.others.Newsletters;
import com.buyconnex.buyconnex.entity.user.Notifications;
import com.buyconnex.buyconnex.entity.user.Roles;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsersVo {
	
    private String firstname;   
    private String lastname; 
    private String username;
    private String email;
    private String password;
    private LocalDateTime dateCreation;
    private boolean bActivated;
    private Set<Roles> roles;
    private Set<Notifications> notifications;
    private Set<Avis> avis;
    private Paniers paniers;
    private Clients clients;
    private Newsletters newsletters;
}
