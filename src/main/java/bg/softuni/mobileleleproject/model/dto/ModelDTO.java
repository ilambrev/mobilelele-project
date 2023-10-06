package bg.softuni.mobileleleproject.model.dto;

public class ModelDTO {

    private Long id;

    private String name;

    public ModelDTO() {

    }

    public ModelDTO(Long id, String name) {
        this.id = id;
        this.name = name;
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

}