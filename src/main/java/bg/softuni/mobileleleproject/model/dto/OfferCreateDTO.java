package bg.softuni.mobileleleproject.model.dto;

import bg.softuni.mobileleleproject.model.enums.EngineEnum;
import bg.softuni.mobileleleproject.model.enums.TransmissionEnum;

import java.math.BigDecimal;

public class OfferCreateDTO {

    private Long modelId;

    private BigDecimal price;

    private EngineEnum engine;

    private TransmissionEnum transmission;

    private Integer year;

    private Integer mileage;

    private String description;

    private String imageUrl;

    public OfferCreateDTO() {

    }

    public Long getModelId() {
        return modelId;
    }

    public OfferCreateDTO setModelId(Long modelId) {
        this.modelId = modelId;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferCreateDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferCreateDTO setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferCreateDTO setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OfferCreateDTO setYear(Integer year) {
        this.year = year;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferCreateDTO setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferCreateDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferCreateDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

}