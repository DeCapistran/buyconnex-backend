package com.buyconnex.buyconnex.entity.security;

import com.buyconnex.buyconnex.entity.user.Users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

@Entity
@Table(name = "EXPIRE_VERIF_MFA")
@NoArgsConstructor
@Getter
@Setter
public class VerificationTokenMfa {

    private static final int EXPIRATION_RESET_PASSWORD_TOKEN = 5;
    private String token;

    @Id
    @Getter
    @SequenceGenerator(name = "EXPIRE_VERIF_MFA_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXPIRE_VERIF_MFA_SEQ_ID")
    @Column(name = "ID")
    private Long id;

    @JoinColumn(nullable = false, name = "ID_USER", foreignKey = @ForeignKey(name = "FK_VERIF_MFA_USER"))
    @OneToOne(targetEntity = Users.class, fetch = FetchType.EAGER)
    private Users users;


    @Column(name = "MFA_CODE")
    private String mfaCode;

    @Column(name = "DATE_EXPIRE")
    private Date dateExpire;

    public VerificationTokenMfa(final Users users, final String token) {
        this.users = users;
        this.token = token;
        this.dateExpire = calculateDateExpire(EXPIRATION_RESET_PASSWORD_TOKEN);
        this.setMfaCode(generateOTP());
    }

    private Date calculateDateExpire(final int dateExpireInMinute) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE, dateExpireInMinute);
        return new Date(calendar.getTime().getTime());
    }

    public String generateOTP() {
        Random random = new Random();
        int otp = 1000 * random.nextInt(9000);
        return Integer.toString(otp);
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
