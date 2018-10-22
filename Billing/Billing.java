/*
 * A Billing object will contain a Patient object and a Doctor object. 
 * Give your class a reasonable complement of constructors, get/set methods, display and an equals method. 
 */
public class Billing{
	private Doctor doctor; 
	private Patient patient; 
	
	public Billing(String dname, String specialty, double visitFee, String pname, int id) {
		doctor = new Doctor(dname, specialty, visitFee); 
		patient = new Patient(pname, id); 
		doctor.income =+ doctor.visitFee; 
	}
	
	public Billing(Doctor d, Patient p) {
		doctor = d;
		patient = p; 
		doctor.income += doctor.visitFee; 
	}
	
	public void display() {
		doctor.display();
	}
	
	public Doctor getDoctor() {
		return doctor; 
	}
	
	public Patient getPatient() {
		return patient; 
	}
	
	public boolean equals(Billing second) {
		if(doctor.equals(second.getDoctor()) && patient.equals(second.getPatient()))
			return true; 
		else
			return false; 
	}
}
