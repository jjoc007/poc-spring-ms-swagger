package co.com.example.ms.pocspringmicroserviceswagger.infrastructure.mappers;


import co.com.example.ms.pocspringmicroserviceswagger.domain.model.PersonModel;
import co.com.example.ms.pocspringmicroserviceswagger.infrastructure.entity.PersonEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

	PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

	PersonModel mapToPersonModel(PersonEntity personEntity);

	PersonEntity mapToPersonEntity(PersonModel personModel);

	List<PersonModel> mapToPersonListModel(List<PersonEntity> personListEntity);

	List<PersonEntity> mapToPersonListEntity(List<PersonModel> personListModel);
}
