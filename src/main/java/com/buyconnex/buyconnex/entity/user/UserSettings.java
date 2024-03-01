package com.buyconnex.buyconnex.entity.user;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "USERS_DETAILS")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UserSettings {

    @Id
    @SequenceGenerator(name = "USERS_DETAILS_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_DETAILS_SEQ_ID")
    @Column(name = "ID_USER_DETAIL")
    private Long id;

    @JoinColumn(name = "ID_USER")
    @OneToOne(targetEntity = Users.class, fetch = FetchType.EAGER, optional = false)
    private Users users;

    @Column(name = "LANGUE")
    private String langue;

    @Column(name = "MFA_ACTIVE")
    private boolean mfaActive;

    @Column(name = "NOTIF_ACTIVE")
    private boolean notifActive;

}
