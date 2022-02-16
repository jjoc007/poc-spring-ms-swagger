package co.com.example.ms.pocspringmicroserviceswagger.config;

import co.com.example.ms.pocspringmicroserviceswagger.domain.ports.PersonPersistencePort;
import co.com.example.ms.pocspringmicroserviceswagger.domain.ports.PersonServicePort;
import co.com.example.ms.pocspringmicroserviceswagger.domain.service.PersonServiceImpl;
import co.com.example.ms.pocspringmicroserviceswagger.infrastructure.adapters.PersonJpaAdapter;
import co.com.example.ms.pocspringmicroserviceswagger.infrastructure.repository.PersonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonConfig {

	@Bean
	public PersonServicePort personService(PersonPersistencePort personPersistencePort){
		return new PersonServiceImpl(personPersistencePort);
	}

}
