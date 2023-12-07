package com.buyconnex.buyconnex.entity.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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


    private String roleName;
    private String roleDescription;

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
