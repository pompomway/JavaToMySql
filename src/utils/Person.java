package utils;

public class Person {
	
	public Person() {}
	
	public Person(int pk, String id, String pass) {
		this.pk = pk;
		this.id = id;
		this.pass = pass;
	}

	private int pk;
	private String id;
	private String pass;
	
	public int getPk() {
		return pk;
	}

	public void setPk(int pk) {
		this.pk = pk;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	

}
