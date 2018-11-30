package finra.springframework.sfgpetclinic.sevices;

import finra.springframework.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);


}
