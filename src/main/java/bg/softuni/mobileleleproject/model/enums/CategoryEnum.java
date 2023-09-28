package bg.softuni.mobileleleproject.model.enums;

public enum CategoryEnum {

    CAR("Car"),
    BUS("Bus"),
    TRUCK("Truck"),
    MOTORCYCLE("Motorcycle");

    public final String label;

    CategoryEnum(String label) {
        this.label = label;
    }

}