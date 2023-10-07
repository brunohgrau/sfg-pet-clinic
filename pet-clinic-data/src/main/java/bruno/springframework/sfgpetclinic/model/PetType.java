package bruno.springframework.sfgpetclinic.model;

public class PetType extends BaseEntity{
    // declarando atributos
    private String name;

    // construtor para instanciar objeto
    public PetType() {
    }

    public PetType(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
