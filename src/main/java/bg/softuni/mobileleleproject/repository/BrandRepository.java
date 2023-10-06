package bg.softuni.mobileleleproject.repository;

import bg.softuni.mobileleleproject.model.entity.BrandEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Long> {

    @EntityGraph(value = "brandWithModels", attributePaths = "models")
    List<BrandEntity> findAllByOrderByName();

}