package finra.springframework.sfgpetclinic.bootstrap;

import finra.springframework.sfgpetclinic.model.Owner;
import finra.springframework.sfgpetclinic.model.Pet;
import finra.springframework.sfgpetclinic.model.PetType;
import finra.springframework.sfgpetclinic.model.Vet;
import finra.springframework.sfgpetclinic.sevices.OwnerService;
import finra.springframework.sfgpetclinic.sevices.PetTypeService;
import finra.springframework.sfgpetclinic.sevices.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Street 1");
        owner1.setCity("Miami");
        owner1.setTelephone("9817293031");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fionaa");
        owner2.setLastName("Glen");
        owner2.setAddress("123 Street 1");
        owner2.setCity("Miami");
        owner2.setTelephone("9817293031");

        Pet fioansCat = new Pet();
        fioansCat.setName("Just Cat");
        fioansCat.setOwner(owner2);
        fioansCat.setBirthDate(LocalDate.now());
        fioansCat.setPetType(savedCatPetType);
        owner2.getPets().add(fioansCat);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jack");
        vet2.setLastName("Bony");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
