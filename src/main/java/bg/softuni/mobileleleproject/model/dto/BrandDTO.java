package bg.softuni.mobileleleproject.model.dto;

import java.util.ArrayList;
import java.util.List;

public class BrandDTO {

    private String name;

    private List<ModelDTO> models;

    public BrandDTO() {
        this.models = new ArrayList<>();
    }

    public BrandDTO(String name, List<ModelDTO> models) {
        this.name = name;
        this.models = models;
    }

    public String getName() {
        return name;
    }

    public BrandDTO setName(String name) {
        this.name = name;
        return this;
    }

    public List<ModelDTO> getModels() {
        return models;
    }

    public BrandDTO setModels(List<ModelDTO> models) {
        this.models = models;
        return this;
    }

}