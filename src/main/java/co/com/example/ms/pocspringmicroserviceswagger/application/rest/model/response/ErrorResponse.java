package co.com.example.ms.pocspringmicroserviceswagger.application.rest.model.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ErrorResponse {

	private int code;

	private String cause;
}
