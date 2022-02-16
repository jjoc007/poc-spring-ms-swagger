package co.com.example.ms.pocspringmicroserviceswagger.application.rest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Person {
	private Long id;

	private String name;

	private String lastName;

	private String phone;

	private String address;
}
