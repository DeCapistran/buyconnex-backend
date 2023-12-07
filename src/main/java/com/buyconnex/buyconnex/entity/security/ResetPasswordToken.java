package com.buyconnex.buyconnex.entity.security;

import com.buyconnex.buyconnex.entity.user.Users;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name = "EXPIRE_RESET_PASSWORD_TOKEN")
@NoArgsConstructor
@Getter @Setter
public class ResetPasswordToken {

    private static final int EXPIRATION_RESET_PASSWORD_TOKEN = 60*3;

    public ResetPasswordToken(Users users, String token) {

    }

}
