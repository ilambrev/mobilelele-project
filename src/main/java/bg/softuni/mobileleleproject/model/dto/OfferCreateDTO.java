package bg.softuni.mobileleleproject.model.dto;

import bg.softuni.mobileleleproject.model.enums.EngineEnum;
import bg.softuni.mobileleleproject.model.enums.TransmissionEnum;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class OfferCreateDTO {

    @NotNull(message = "Vehicle model is required.")
    private Long modelId;

    @NotNull(message = "Price is required.")
    @Positive(message = "Price must be positive number.")
    private BigDecimal price;

    @NotNull(message = "Engine type is required.")
    private EngineEnum engine;

    @NotNull(message = "Transmission type is required.")
    private TransmissionEnum transmission;

    @NotNull(message = "Manufacturing year is required.")
    @Min(value = 1885, message = "Year should not be less than 1885.")
    @Max(value = 2024, message = "Year should not be greater than current year.")
    private Integer year;

    @NotNull(message = "Mileage is required.")
    @Positive(message = "Value in kilometers must be positive number.")
    private Integer mileage;

    @NotEmpty(message = "Description is required.")
    @Size(min = 5, max = 512, message = "Length must be between 5 and 512 symbols.")
    private String description;

    @NotEmpty(message = "Vehicle image URL is required.")
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