package co.com.example.ms.pocspringmicroserviceswagger.domain.service;

import co.com.example.ms.pocspringmicroserviceswagger.domain.exception.BusinessException;
import co.com.example.ms.pocspringmicroserviceswagger.domain.exception.PersonNotFoundException;
import co.com.example.ms.pocspringmicroserviceswagger.domain.model.PersonModel;
import co.com.example.ms.pocspringmicroserviceswagger.domain.ports.PersonPersistencePort;
import co.com.example.ms.pocspringmicroserviceswagger.domain.ports.PersonServicePort;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PersonServiceImpl implements PersonServicePort {

	private final PersonPersistencePort personPersistencePort;

	@Override
	public PersonModel addPerson(PersonModel personModel) {
		return this.personPersistencePort.addPerson(personModel);
	}

	@Override
	public void deletePersonById(Long id) {
		this.personPersistencePort.deletePersonById(id);
	}

	@Override
	public PersonModel updatePerson(PersonModel personModel) {
		return this.personPersistencePort.updatePerson(personModel);
	}

	@Override
	public List<PersonModel> getPersons() {
		return this.personPersistencePort.getPersons();
	}

	@Override
	public PersonModel getPersonById(Long id) throws BusinessException {
		Optional<PersonModel> personModelOptional = Optional.ofNullable(
			this.personPersistencePort.getPersonById(id)
		);
		return personModelOptional.orElseThrow(PersonNotFoundException::new);
	}
}
