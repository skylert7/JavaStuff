/*
 * Drive Patient form the class Person. A patient record has the Patient's name, and an identification number.
 */
public class Patient extends Person{
	protected int id; 
	
	public Patient(String name, int id) {
		super(name); 
		this.id = id; 
	}
	
	public void display() {
		super.display(); 
		System.out.printf("%-20s %d\n","ID", id); 
	}
	
	public int getId() {
		return id; 
	}
	
	public boolean equals(Patient second) {
		if(super.hasSameName(second) && id == second.getId())
			return true; 
		else
			return false; 
	}
}
