package bg.softuni.mobileleleproject.model.dto;

import bg.softuni.mobileleleproject.model.enums.CategoryEnum;

public class ModelDTO {

    private Long id;

    private String name;

    private String category;

    private String imageUrl;

    private Integer startYear;

    private Integer endYear;

    public ModelDTO() {

    }

    public ModelDTO(Long id, String name, String category, String imageUrl, Integer startYear, Integer endYear) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.imageUrl = imageUrl;
        this.startYear = startYear;
        this.endYear = endYear;
    }

    public Long getId() {
        return id;
    }

    public ModelDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ModelDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public ModelDTO setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ModelDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public ModelDTO setStartYear(Integer startYear) {
        this.startYear = startYear;
        return this;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public ModelDTO setEndYear(Integer endYear) {
        this.endYear = endYear;
        return this;
    }

}