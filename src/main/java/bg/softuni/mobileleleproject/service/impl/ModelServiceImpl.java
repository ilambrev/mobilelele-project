package bg.softuni.mobileleleproject.service.impl;

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

}