package bg.softuni.mobileleleproject.model.dto;

import bg.softuni.mobileleleproject.model.enums.EngineEnum;
import bg.softuni.mobileleleproject.model.enums.TransmissionEnum;
import bg.softuni.mobileleleproject.model.validation.YearNotInTheFuture;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.UUID;

public class OfferEditDTO {

    private UUID uuid;

    @NotNull(message = "Vehicle model is required.")
    private Long modelId;

    @NotNull(message = "Price is required.")
    @Positive(message = "Price must be positive number.")
    private BigDecimal price;

    @NotNull(message = "Engine type is required.")
    private EngineEnum engine;

    @NotNull(message = "Transmission type is required.")
    private TransmissionEnum transmission;

    @YearNotInTheFuture(message = "The year should not be in the future.")
    @NotNull(message = "Manufacturing year is required.")
    @Min(value = 1930, message = "The year should not be before 1930.")
    private Integer year;

    @NotNull(message = "Mileage is required.")
    @Positive(message = "Value in kilometers must be positive number.")
    private Integer mileage;

    @NotEmpty(message = "Description is required.")
    @Size(min = 5, max = 512, message = "Length must be between 5 and 512 symbols.")
    private String description;

    @NotEmpty(message = "Vehicle image URL is required.")
    private String imageUrl;

    public OfferEditDTO() {

    }

    public UUID getUuid() {
        return uuid;
    }

    public OfferEditDTO setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public Long getModelId() {
        return modelId;
    }

    public OfferEditDTO setModelId(Long modelId) {
        this.modelId = modelId;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferEditDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferEditDTO setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferEditDTO setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OfferEditDTO setYear(Integer year) {
        this.year = year;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferEditDTO setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferEditDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferEditDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}