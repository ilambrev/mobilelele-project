package bg.softuni.mobileleleproject.repository;

import bg.softuni.mobileleleproject.model.entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity, Long> {

    Optional<OfferEntity> findByUuid(UUID uuid);

    List<OfferEntity> findAllByOrderByIdDesc();
}