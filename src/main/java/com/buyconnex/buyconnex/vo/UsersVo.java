package com.buyconnex.buyconnex.vo;

import java.util.Date;
import java.util.List;

import com.buyconnex.buyconnex.entity.user.Roles;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
