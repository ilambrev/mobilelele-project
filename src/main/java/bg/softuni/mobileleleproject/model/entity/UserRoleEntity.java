package bg.softuni.mobileleleproject.model.entity;

import bg.softuni.mobileleleproject.model.enums.RoleEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class UserRoleEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private RoleEnum name;

    public UserRoleEntity() {

    }

    public RoleEnum getName() {
        return name;
    }

    public UserRoleEntity setName(RoleEnum name) {
        this.name = name;
        return this;
    }

}