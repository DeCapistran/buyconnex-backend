package com.buyconnex.buyconnex.entity.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "USERS_DETAILS")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UserSettings {

    @Id
    @Getter
    @SequenceGenerator(name = "USERS_DETAILS_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_DETAILS_SEQ_ID")
    @Column(name = "ID_USER_DETAIL")
    private Long id;

    @Getter @Setter
    @JoinColumn(name = "ID_USER")
    @OneToOne(targetEntity = Users.class, fetch = FetchType.EAGER, optional = false)
    private Users users;

    @Getter @Setter
    @Column(name = "LANGUE")
    private String langue;

    @Getter @Setter
    @Column(name = "MFA_ACTIVE")
    private boolean mfaActive;

    @Getter @Setter
    @Column(name = "NOTIF_ACTIVE")
    private boolean notifActive;

}
