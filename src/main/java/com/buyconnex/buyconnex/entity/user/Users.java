package com.buyconnex.buyconnex.entity.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "USERS")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Users {

    @Id
    @SequenceGenerator(name = "USERS_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQ_ID")
    @Column(name = "ID")
    private Long id;

    @Column(name = "USER_LOGIN")
    private String userLogin;

    @Column(name = "USER_PASSWORD")
    private String userPassword;

    @Column(name = "B_ACTIVATED")
    private boolean bActivated;

    @Column(name = "B_AUTHENTICATE")
    private boolean bAuthenticate;

    @Column(name = "B_LOCKED")
    private boolean bLocked;

    @Column(name = "DATE_CREATION")
    private Date dateCreation;

    @JoinColumn(name = "ID_CONTACT")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Contacts contacts;

}
