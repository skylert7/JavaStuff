/*
 * Then define a class named Doctor whose objects are records for a clinic's doctors. 
 * Drive this class from the class Person. A Doctor record has doctor's name, a specialty, 
 * and office visit fee. Give your class a reasonable complement of constructors and get/set methods, and an equals method as well. 
 * The equals method returns true if two doctor records are the same.
 */
public class Doctor extends Person{
	//String name: from super class	
	protected String specialty; 
	protected double visitFee; 
	protected double income; 
	
	public Doctor(String name, String specialty, double visitFee) {
		super(name); 
		this.specialty = specialty; 
		this.visitFee = visitFee; 
		this.income = 0; 
	}
	
	public String getSpecialty() {
		return specialty; 
	}
	
	public double getVisitFee() {
		return visitFee; 
	}
	
	public void display() {
		super.display(); 
		System.out.printf("%-20s %s\n", "Specialty", specialty); 
		System.out.printf("%-20s $%.2f\n", "Office Visit Fee", visitFee); 
		System.out.printf("%-20s $%.2f\n", "Total Income", income); 
		System.out.println("------------------------------------");
	}
	
	public void oneLineDisplay() {
		System.out.printf("%-20s %-20s $%.2f\n", name, specialty, visitFee); 
	}
	
	public boolean equals(Doctor secondDoctor) {
		boolean nameStatus = name.equalsIgnoreCase(secondDoctor.getName()); 
		boolean specialtyStatus = specialty.equalsIgnoreCase(secondDoctor.getSpecialty()); 
		boolean visitFeeStatus = visitFee == secondDoctor.getVisitFee(); 
		
		if(nameStatus && specialtyStatus && visitFeeStatus)
			return true; 
		else 
			return false; 
	}
}

