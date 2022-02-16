package co.com.example.ms.pocspringmicroserviceswagger.infrastructure.adapters;

import co.com.example.ms.pocspringmicroserviceswagger.domain.model.PersonModel;
import co.com.example.ms.pocspringmicroserviceswagger.domain.ports.PersonPersistencePort;
import co.com.example.ms.pocspringmicroserviceswagger.infrastructure.entity.PersonEntity;
import co.com.example.ms.pocspringmicroserviceswagger.infrastructure.mappers.PersonMapper;
import co.com.example.ms.pocspringmicroserviceswagger.infrastructure.repository.PersonRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonJpaAdapter implements PersonPersistencePort {

	private final PersonRepository personRepository;

	@Override
	public PersonModel addPerson(PersonModel personModel) {
		PersonEntity personEntity = PersonMapper.INSTANCE.mapToPersonEntity(personModel);
		PersonEntity personSaved = this.personRepository.save(personEntity);
		return PersonMapper.INSTANCE.mapToPersonModel(personSaved);
	}

	@Override
	public void deletePersonById(Long id) {
		this.personRepository.deleteById(id);
	}

	@Override
	public PersonModel updatePerson(PersonModel personModel) {
		return this.addPerson(personModel);
	}

	@Override
	public List<PersonModel> getPersons() {
		List<PersonEntity> personEntityList = this.personRepository.findAll();
		return PersonMapper.INSTANCE.mapToPersonListModel(personEntityList);
	}

	@Override
	public PersonModel getPersonById(Long id) {
		Optional<PersonEntity> personEntity = this.personRepository.findById(id);
		return personEntity.map(PersonMapper.INSTANCE::mapToPersonModel)
			.orElse(null);
	}
}
