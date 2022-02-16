package co.com.example.ms.pocspringmicroserviceswagger.application.rest.mappers;

import co.com.example.ms.pocspringmicroserviceswagger.application.rest.model.request.PersonRequest;
import co.com.example.ms.pocspringmicroserviceswagger.application.rest.model.response.PersonResponse;
import co.com.example.ms.pocspringmicroserviceswagger.domain.model.PersonModel;
import co.com.example.ms.pocspringmicroserviceswagger.infrastructure.entity.PersonEntity;
import co.com.example.ms.pocspringmicroserviceswagger.infrastructure.mappers.PersonMapper;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonRestMapper {

	PersonRestMapper INSTANCE = Mappers.getMapper(PersonRestMapper.class);

	PersonModel mapToPersonModel(PersonRequest personRequest);

	PersonResponse mapToPersonResponse(PersonModel personModel);

	List<PersonResponse> mapToPersonResponseList(List<PersonModel> personListModel);
}
