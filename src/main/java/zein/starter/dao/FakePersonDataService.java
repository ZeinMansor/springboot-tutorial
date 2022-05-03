package zein.starter.dao;

import org.springframework.stereotype.Repository;
import zein.starter.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataService implements PersonDao{

    private static List<Person> DB = new ArrayList<>();
    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public int deletePersonByID(UUID id) {
        Optional<Person> personMaybe = selectPersonBYID(id);
        if (personMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePersonByID(UUID id, Person person) {
        return selectPersonBYID(id)
                .map(p -> {
                    int indexToDelete = DB.indexOf(p);
                    if(indexToDelete >= 0) {
                        DB.set(indexToDelete, new Person(id, person.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public Optional<Person> selectPersonBYID(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }
}
