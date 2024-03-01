package com.buyconnex.buyconnex.vo;


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

    private String email;

    private String password;
    
    private Roles roles;

}
