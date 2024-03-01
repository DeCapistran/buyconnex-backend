package com.buyconnex.buyconnex.vo;

import lombok.*;


@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ContactVo {

    private Long idContact;

    private String firstName;

    private String lastName;
    
    private String entreprise;
    
    private String genre;
    
    private String adresse;
    
    private String codePostal;
    
    private String ville;
    
    private String instagram;
    
    private String facebook;
    
    private String telephone1;

    private String email;

    private String telephone2;
}
