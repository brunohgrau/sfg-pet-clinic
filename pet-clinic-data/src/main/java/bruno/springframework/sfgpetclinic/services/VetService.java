package bruno.springframework.sfgpetclinic.services;

import bruno.springframework.sfgpetclinic.model.Pet;
import bruno.springframework.sfgpetclinic.model.Vet;
import java.util.Set;

public interface VetService {


    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();


}
