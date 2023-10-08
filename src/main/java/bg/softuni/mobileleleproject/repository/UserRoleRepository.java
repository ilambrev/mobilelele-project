package bg.softuni.mobileleleproject.repository;

import bg.softuni.mobileleleproject.model.entity.UserRoleEntity;
import bg.softuni.mobileleleproject.model.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

    UserRoleEntity findByName(RoleEnum roleEnum);

}