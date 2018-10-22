/*
 * Define a class Person that holds person's name and appropriate constructors, get/set methods, 
 * display and hasSameName methods. hasSameName method will return true if two objects of data type Person have the same name.
 */
public class Person {
	protected String name; 
	
	public Person() {
		name = ""; 
	}
	
	public Person(String name) {
		this.name = name; 
	}
	
	public String getName() {
		return name; 
	}
	
	public boolean hasSameName(Person secondPerson) {
		if(name.equalsIgnoreCase(secondPerson.getName()))
			return true; 
		else
			return false; 
	}
	
	public void display() {
		System.out.printf("%-20s %s\n", "Name", name); 
	}

}
