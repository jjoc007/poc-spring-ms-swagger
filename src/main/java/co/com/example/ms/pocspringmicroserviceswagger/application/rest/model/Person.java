package co.com.example.ms.pocspringmicroserviceswagger.application.rest.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "entidad persona")
@Getter
@Setter
public class Person {

	@Schema(
			description = "Id de la persona",
			example = "123456789"
	)
	private Long id;

	@Schema(
			description = "Nombre de la persona",
			example = "pepito",
			required = true
	)
	private String name;

	@Schema(
			description = "Apellido de la persona",
			example = "perez",
			required = true
	)
	private String lastName;

	@Schema(
			description = "telefono de la persona",
			example = "573126669997",
			required = true
	)
	private String phone;

	@Schema(
			description = "Direccion de la persona",
			example = "calle falsa 123",
			required = true
	)
	private String address;
}
