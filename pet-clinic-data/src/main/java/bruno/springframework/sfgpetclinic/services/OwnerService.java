package bruno.springframework.sfgpetclinic.services;
import bruno.springframework.sfgpetclinic.model.Owner;
import java.util.Set;

public interface OwnerService  extends CrudService<Owner,Long> {
    Owner findByLastName(String lastName);
}
