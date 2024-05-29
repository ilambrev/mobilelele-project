package bg.softuni.mobileleleproject.repository;

import bg.softuni.mobileleleproject.model.entity.UserActivationCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserActivationCodeRepository extends JpaRepository<UserActivationCodeEntity, Long> {

}