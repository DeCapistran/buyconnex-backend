package com.buyconnex.buyconnex.vo;

import java.util.Date;
import java.util.List;

import com.buyconnex.buyconnex.entity.user.Roles;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UsersVo {

	private Long idUser;

    private String email;

    private String password;
    
    private String firstname;
    
    private String lastname;

    private boolean isActivated = true;
    
    private boolean isAuthenticate = true;

    private boolean isLocked = false;
    
    private Date dateCreation;

    private Roles roles;
    
    private Long idContact;

}
