package com.buyconnex.buyconnex.vo.user;


import java.time.LocalDateTime;
import java.util.Set;

import com.buyconnex.buyconnex.entity.user.Roles;
import com.buyconnex.buyconnex.vo.article.AvisVo;
import com.buyconnex.buyconnex.vo.client.ClientsVo;
import com.buyconnex.buyconnex.vo.client.PaniersVo;
import com.buyconnex.buyconnex.vo.other.NewslettersVo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsersVo {
	private Long id;
    private String firstname;   
    private String lastname; 
    private String username;
    private String email;
    private String password;
    private LocalDateTime dateCreation;
    private boolean bActivated;
    private Set<Roles> roles;
    private Set<NotificationsVo> notifications;
    private Set<AvisVo> avis;
    private PaniersVo paniers;
    private ClientsVo clients;
    private NewslettersVo newsletters;
}
