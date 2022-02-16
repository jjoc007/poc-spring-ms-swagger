package co.com.example.ms.pocspringmicroserviceswagger.application.rest.controller;


import co.com.example.ms.pocspringmicroserviceswagger.application.rest.mappers.PersonRestMapper;
import co.com.example.ms.pocspringmicroserviceswagger.application.rest.model.request.PersonRequest;
import co.com.example.ms.pocspringmicroserviceswagger.application.rest.model.response.PersonResponse;
import co.com.example.ms.pocspringmicroserviceswagger.domain.exception.BusinessException;
import co.com.example.ms.pocspringmicroserviceswagger.domain.model.PersonModel;
import co.com.example.ms.pocspringmicroserviceswagger.domain.ports.PersonServicePort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

	private final PersonServicePort personServicePort;

	@PostMapping
	public ResponseEntity<PersonResponse> addPerson(@RequestBody PersonRequest personRequest) {
		PersonModel personModel = PersonRestMapper.INSTANCE.mapToPersonModel(personRequest);
		PersonResponse personResponse = PersonRestMapper.INSTANCE.mapToPersonResponse(
			personServicePort.addPerson(personModel));
		return ResponseEntity.ok(personResponse);
	}

	@PutMapping
	public ResponseEntity<PersonResponse> updatePerson(@RequestBody PersonRequest personRequest) {
		PersonModel personModel = PersonRestMapper.INSTANCE.mapToPersonModel(personRequest);
		PersonResponse personResponse = PersonRestMapper.INSTANCE.mapToPersonResponse(
			personServicePort.updatePerson(personModel));
		return ResponseEntity.ok(personResponse);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PersonResponse> getPersonByID(@PathVariable long id)
		throws BusinessException {
		PersonResponse personResponse = PersonRestMapper.INSTANCE.mapToPersonResponse(
			personServicePort.getPersonById(id));
		return ResponseEntity.ok(personResponse);
	}

	@GetMapping
	public ResponseEntity<List<PersonResponse>> getAllPersons() {
		List<PersonResponse> personsResponse = PersonRestMapper.INSTANCE.mapToPersonResponseList(
			personServicePort.getPersons());
		return ResponseEntity.ok(personsResponse);
	}

	@DeleteMapping("/{id}")
	public void deletePersonByID(@PathVariable long id) {
			personServicePort.deletePersonById(id);
	}
}
