package dao;
import java.util.List;

import utils.Person;

public interface PersonDao {
	
	void save(Person person);
	int update(Person person);
	int delete(int pk);
    Person getByPk(int pk);
    
    List<Person> getById(String... id);
    List<Person> getByPass(String... pass);
}
