package bg.softuni.mobileleleproject.service.impl;

import bg.softuni.mobileleleproject.model.entity.BrandEntity;
import bg.softuni.mobileleleproject.repository.BrandRepository;
import bg.softuni.mobileleleproject.service.BrandService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class BrandServiceImplTestIT {

    @Autowired
    private BrandService brandService;

    @Autowired
    private BrandRepository brandRepository;

    @BeforeEach
    void setUp() {
        brandRepository.deleteAll();
    }

    @AfterEach
    void tearDown() {
        brandRepository.deleteAll();
    }

    @Test
    void test_brands_service_getAllBrands_with_records_in_db() {
        List<BrandEntity> brands = List.of(
                new BrandEntity().setName("Skoda").setCreated(LocalDateTime.now()),
                new BrandEntity().setName("Volkswagen").setCreated(LocalDateTime.now()),
                new BrandEntity().setName("Seat").setCreated(LocalDateTime.now()));

        brandRepository.saveAll(brands);

        Assertions.assertEquals(3, brandService.getAllBrands().size());
    }

    @Test
    void test_brands_service_getAllBrands_without_records_in_db() {
        Assertions.assertEquals(0, brandService.getAllBrands().size());
    }
}