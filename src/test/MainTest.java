package test;

import java.util.List;

import org.junit.jupiter.api.Test;

import dao.PersonDao;

import daoimpl.PersonDaoImpl01;
import utils.Person;

public class MainTest {
	public static void main(String[] args) {
		MainTest test=new MainTest();
		test.setTest();
	}
	@Test
	public void setTest() {
		PersonDao dao=new PersonDaoImpl01();
		print(dao.getByPk(1));
	}
	
	
	@Test
	public void getTest() {
		//Person pn =new Person();
		PersonDao dao =new PersonDaoImpl01();
		List<Person> list=dao.getById("root","root0307","root0313");
		list.forEach(x -> print(x));
	}
	
	@Test
	public void getTest1() {
		PersonDao dao =new PersonDaoImpl01();
		print(dao.getByPk(1));
	}
	
	
	private void print(Person pn) {
		int pk =pn.getPk();
		String id=pn.getId();
		String pass=pn.getPass();
		if (pk!=0) {
			System.out.println("PK  : "+pk);
			System.out.println("ID  : "+id);
			System.out.println("Pass: "+pass);
			System.out.println("---------------------");
		}else{
			if(id==null) {
				System.out.println("No Data!");
				System.out.println("---------------------");
			}else {
				System.out.println("ID  : "+id);
				System.out.println("Pass: "+pass);
				System.out.println("---------------------");
			}
		}
	}

}
