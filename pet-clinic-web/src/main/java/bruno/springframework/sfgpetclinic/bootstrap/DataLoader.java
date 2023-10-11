package bruno.springframework.sfgpetclinic.bootstrap;
import bruno.springframework.sfgpetclinic.model.*;
import bruno.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0){
            loadData();
        }

    }

    private void loadData() {
//        PetType dog = new PetType();
//        dog.setName("Dog");
//        PetType savedDogPetType = petTypeService.save(dog);

        PetType savedDogPetType = petTypeService.save(new PetType("Dog"));
        PetType savedCatPetType = petTypeService.save(new PetType("Cat"));
        Speciality savedRadiology = specialtyService.save(new Speciality("Radiology"));
        Speciality savedSurgery = specialtyService.save(new Speciality("Surgery"));
        Speciality savedDentistry = specialtyService.save(new Speciality("Dentistry"));

        Owner owner1 = ownerService.save(new Owner("Micahel","Weston","123 Bickerl","Miami","1234"));

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Miina");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = ownerService.save(new Owner("Fiona","Jones","87 John","Miami","13332"));

        Pet fionasCat = new Pet();
        fionasCat.setPetType(savedCatPetType);
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setName("Zé");
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(fionasCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Cat");
        visitService.save(catVisit);

        System.out.println("Loaded Owners.....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Jones");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("John");
        vet2.setLastName("Doe");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets");
    }
}
