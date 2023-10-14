package bg.softuni.mobileleleproject.service.impl;

import bg.softuni.mobileleleproject.model.dto.BrandDTO;
import bg.softuni.mobileleleproject.model.dto.ModelDTO;
import bg.softuni.mobileleleproject.repository.BrandRepository;
import bg.softuni.mobileleleproject.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<BrandDTO> getAllBrands() {
        return this.brandRepository.findAllByOrderByName()
                .stream()
                .map(brand -> new BrandDTO(
                        brand.getName(),
                        brand.getModels().stream()
                                .map(model -> new ModelDTO(
                                        model.getId(),
                                        model.getName(),
                                        model.getCategory().name(),
                                        model.getImageUrl(),
                                        model.getStartYear(),
                                        model.getEndYear()
                                )).collect(Collectors.toList())
                )).collect(Collectors.toList());

    }

}