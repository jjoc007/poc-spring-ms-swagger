package co.com.example.ms.pocspringmicroserviceswagger.application.rest.controller;


import co.com.example.ms.pocspringmicroserviceswagger.application.rest.mappers.PersonRestMapper;
import co.com.example.ms.pocspringmicroserviceswagger.application.rest.model.request.PersonRequest;
import co.com.example.ms.pocspringmicroserviceswagger.application.rest.model.response.PersonResponse;
import co.com.example.ms.pocspringmicroserviceswagger.domain.exception.BusinessException;
import co.com.example.ms.pocspringmicroserviceswagger.domain.model.PersonModel;
import co.com.example.ms.pocspringmicroserviceswagger.domain.ports.PersonServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Persons", description = "Operaciones permitidas sobre la entidad persona")
@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

	private final PersonServicePort personServicePort;

	@Operation(summary = "Crear una nueva persona")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Persona Creada",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = PersonResponse.class)) }) })
	@PostMapping
	public ResponseEntity<PersonResponse> addPerson(@RequestBody PersonRequest personRequest) {
		PersonModel personModel = PersonRestMapper.INSTANCE.mapToPersonModel(personRequest);
		PersonResponse personResponse = PersonRestMapper.INSTANCE.mapToPersonResponse(
			personServicePort.addPerson(personModel));
		return ResponseEntity.status(HttpStatus.CREATED)
			.body(personResponse);
	}

	@Operation(summary = "Actualizar una persona")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Persona Actualizada",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = PersonResponse.class)) }) })
	@PutMapping
	public ResponseEntity<PersonResponse> updatePerson(@RequestBody PersonRequest personRequest) {
		PersonModel personModel = PersonRestMapper.INSTANCE.mapToPersonModel(personRequest);
		PersonResponse personResponse = PersonRestMapper.INSTANCE.mapToPersonResponse(
			personServicePort.updatePerson(personModel));
		return ResponseEntity.ok(personResponse);
	}

	@Operation(summary = "Obtener informacion de una persona")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Persona Obtenida",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = PersonResponse.class)) }) })
	@GetMapping("/{id}")
	public ResponseEntity<PersonResponse> getPersonByID(@PathVariable long id)
		throws BusinessException {
		PersonResponse personResponse = PersonRestMapper.INSTANCE.mapToPersonResponse(
			personServicePort.getPersonById(id));
		return ResponseEntity.ok(personResponse);
	}

	@Operation(summary = "Obtener la informacion de todas las personas")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Personas",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = PersonResponse.class)) }) })
	@GetMapping
	public ResponseEntity<List<PersonResponse>> getAllPersons() {
		List<PersonResponse> personsResponse = PersonRestMapper.INSTANCE.mapToPersonResponseList(
			personServicePort.getPersons());
		return ResponseEntity.ok(personsResponse);
	}

	@Operation(summary = "Eliminar persona por ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Persona eliminada",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = PersonResponse.class)) }) })
	@DeleteMapping("/{id}")
	public void deletePersonByID(@PathVariable long id) {
			personServicePort.deletePersonById(id);
	}
}
