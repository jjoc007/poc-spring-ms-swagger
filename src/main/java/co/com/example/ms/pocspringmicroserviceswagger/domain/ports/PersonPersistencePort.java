package co.com.example.ms.pocspringmicroserviceswagger.domain.ports;

import co.com.example.ms.pocspringmicroserviceswagger.domain.model.PersonModel;
import java.util.List;

public interface PersonPersistencePort {

	PersonModel addPerson(PersonModel personModel);

	void deletePersonById(Long id);

	PersonModel updatePerson(PersonModel personModel);

	List<PersonModel> getPersons();

	PersonModel getPersonById(Long id);

}
