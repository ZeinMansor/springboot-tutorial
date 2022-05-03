package zein.starter.dao;

import zein.starter.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> selectAllPeople();
    int deletePersonByID(UUID id);

    int updatePersonByID(UUID id, Person person);

    Optional<Person> selectPersonBYID(UUID id);
}
