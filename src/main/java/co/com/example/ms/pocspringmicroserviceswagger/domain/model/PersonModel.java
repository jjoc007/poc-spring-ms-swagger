package co.com.example.ms.pocspringmicroserviceswagger.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PersonModel {
	private Long id;

	private String name;

	private String lastName;

	private String phone;

	private String address;
}
