package com.buyconnex.buyconnex.entity.user;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ROLES")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Roles {

    @Id
    @SequenceGenerator(name = "ROLES_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLES_SEQ_ID")
    @Column(name = "ID_ROLE")
    private Long id;

    @Column(name = "ROLE_NAME")
    private String roleName;

    @JoinColumn(name = "ID_USER")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Users users;

}
