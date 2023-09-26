package bruno.springframework.sfgpetclinic.services;
import bruno.springframework.sfgpetclinic.model.Pet;
import java.util.Set;

public interface PetService {

    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();


}
