package bruno.springframework.sfgpetclinic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "types")
public class PetType extends BaseEntity{
    // declarando atributos
    @Column(name = "name")
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
