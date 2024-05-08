package bg.softuni.mobileleleproject.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OfferDTO {

    private String uuid;

    private String description;

    private String engine;

    private String imageUrl;

    private Integer mileage;

    private BigDecimal price;

    private String transmission;

    private Integer year;

    private LocalDateTime created;

    private LocalDateTime modified;

    private String brand;

    private String model;

    private String seller;

    public OfferDTO() {

    }

    public OfferDTO(String uuid, String description, String engine, String imageUrl, Integer mileage,
                    BigDecimal price, String transmission, Integer year, LocalDateTime created,
                    LocalDateTime modified, String brand, String model, String seller) {
        this.uuid = uuid;
        this.description = description;
        this.engine = engine;
        this.imageUrl = imageUrl;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.year = year;
        this.created = created;
        this.modified = modified;
        this.brand = brand;
        this.model = model;
        this.seller = seller;
    }

    public String getUuid() {
        return uuid;
    }

    public OfferDTO setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getEngine() {
        return engine;
    }

    public OfferDTO setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferDTO setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getTransmission() {
        return transmission;
    }

    public OfferDTO setTransmission(String transmission) {
        this.transmission = transmission;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OfferDTO setYear(Integer year) {
        this.year = year;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public OfferDTO setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public OfferDTO setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public OfferDTO setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public OfferDTO setModel(String model) {
        this.model = model;
        return this;
    }

    public String getSeller() {
        return seller;
    }

    public OfferDTO setSeller(String seller) {
        this.seller = seller;
        return this;
    }

}