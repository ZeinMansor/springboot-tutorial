package zein.starter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import zein.starter.dao.PersonDao;
import zein.starter.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople() {
        return personDao.selectAllPeople();
    }

    public Optional<Person> getPersonByID(UUID id) {
        return personDao.selectPersonBYID(id);
    }

    public int deletePerson (UUID id) {
        return personDao.deletePersonByID(id);
    }

    public int updatePerson (UUID id, Person person) {
        return personDao.updatePersonByID(id, person);
    }
}
