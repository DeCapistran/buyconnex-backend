package com.buyconnex.buyconnex.entity.security;

import com.buyconnex.buyconnex.entity.user.Users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "EXPIRE_RESET_PASSWORD_TOKEN")
@NoArgsConstructor
@Getter
@Setter
public class ResetPasswordToken {

    private static final int EXPIRATION_RESET_PASSWORD_TOKEN = 60*3;

    @Id
    @SequenceGenerator(name = "EXPIRE_RESET_PASSWORD_TOKEN_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXPIRE_RESET_PASSWORD_TOKEN_SEQ_ID")
    private Long id;

    @OneToOne(targetEntity = Users.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "ID_USER")
    private Users users;

    @Column(name = "TOKEN")
    private String token;

    @Column(name = "DATE_EXPIRE")
    private Date dateExpire;

    public ResetPasswordToken(Users users, String token) {
        this.users = users;
        this.token = token;
        this.dateExpire = calculateDateExpire(EXPIRATION_RESET_PASSWORD_TOKEN);
    }

    public ResetPasswordToken(String token, Date dateExpire) {
        this.token = token;
        this.dateExpire = calculateDateExpire(EXPIRATION_RESET_PASSWORD_TOKEN);
    }

    private Date calculateDateExpire(final int dateExpireInMinute) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE, dateExpireInMinute);
        return new Date(calendar.getTime().getTime());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDateExpire() == null) ? 0 : getDateExpire().hashCode());
        result = prime * result + ((getDateExpire() == null) ? 0 : getToken().hashCode());
        result = prime * result + ((getDateExpire() == null) ? 0 : getUsers().hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        final ResetPasswordToken resetPasswordTokenOther = (ResetPasswordToken) obj;

        if(this == obj) {
            return true;
        }
        if(obj == null) {
            return false;
        }
        if(getClass() != obj.getClass()) {
            return false;
        }
        if(getDateExpire() == null) {
            if (resetPasswordTokenOther.getDateExpire() != null) {
                return false;
            }
        } else if (!getDateExpire().equals(resetPasswordTokenOther.getDateExpire())) {
            return false;
        }
        if (getToken() == null) {
            if (resetPasswordTokenOther.getToken() != null) {
                return false;
            }
        } else if (!getToken().equals(resetPasswordTokenOther.getToken())) {
            return false;
        }
        if (getUsers() == null) {
            if (resetPasswordTokenOther.getUsers() != null) {
                return false;
            }
        } else if (!getUsers().equals(resetPasswordTokenOther.getUsers())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Token [String=").append(token).append("]").append("[Expires").append(dateExpire).append("]");
        return builder.toString();
    }

}
