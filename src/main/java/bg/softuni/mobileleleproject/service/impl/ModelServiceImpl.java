package bg.softuni.mobileleleproject.service.impl;

import bg.softuni.mobileleleproject.exception.ModelNotFoundException;
import bg.softuni.mobileleleproject.model.entity.ModelEntity;
import bg.softuni.mobileleleproject.repository.ModelRepository;
import bg.softuni.mobileleleproject.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public ModelEntity getModelById(Long id) {
        return this.modelRepository.findById(id)
                .orElseThrow(() -> new ModelNotFoundException("Company with id: " + id + " not found!"));
    }
}