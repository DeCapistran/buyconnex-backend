package com.buyconnex.buyconnex.entity.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "CONTACTS")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Contacts {

    @Id
    @SequenceGenerator(name = "CONTACTS_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTACTS_SEQ_ID")
    @Column(name = "ID")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "GENRE")
    private String genre;

    @Column(name = "ADRESSE")
    private String adresse;

    @Column(name = "CODE_POSTAL")
    private String codePostal;

    @Column(name = "VILLE")
    private String ville;

    @Column(name = "FACEBOOK")
    private String facebook;

    @Column(name = "INSTAGRAM")
    private String instagram;

    @Column(name = "TELEPHONE1")
    private String telephone1;

    @Column(name = "TELEPHONE2")
    private String telephone2;

}
