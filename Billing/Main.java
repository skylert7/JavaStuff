import java.lang.*;
import java.util.*;
public class Main {
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    // only got here if we didn't return false
	    return true;
	}
	
	public static void main(String[] args) throws Exception
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter number of doctors in the facility: ");
		
		int doctorNo = 0;					//number of doctor in total (size of the doctor array)
		doctorNo = kb.nextInt();			//get number of doctor from user
		int i = 0;							//declare dummy variable to use the entire program
		
		while (doctorNo <= 0)				//if number of doctor is <= 0, keep asking until get valid result
		{
			System.out.print("Enter number of doctors in the facility: ");
			doctorNo = kb.nextInt();
		}
		Doctor[] doctorArray = new Doctor[doctorNo]; 		//create array type Doctor with size = doctor number
		
		System.out.print("\nEnter number of patients in the facility: ");
		
		int patientNo = kb.nextInt();		//get number of patient from user
		
		while (patientNo <= 0)				//if number of patient is <= 0, keep asking until get valid result
		{
			System.out.print("\nEnter number of patients in the facility: ");
			patientNo = kb.nextInt();
		}
		
		Patient[] patientArray = new Patient[patientNo];	//create array type Patient with size = patient number
		kb.nextLine();
		System.out.print("-----------------------------" + 
						"\nCreate Doctor Array:" +
						"\n-----------------------------");
		for(i = 0; i<doctorNo;i++)			//fill out the array with user's input
		{
				System.out.print("\nDoctor " + (i + 1)  +
								"\nEnter doctor's name: ");
				String doctorName = kb.nextLine();		//get doctorName, has no exception
				System.out.print("Enter Specialty: ");
				String specialty = kb.nextLine();		//get specialty, has no exception
				double visitFee = 0;
				while (true) 
				{
				    try 
				    {
				    	System.out.print("Enter office visit fee: ");
				    	visitFee = Double.parseDouble(kb.next());
				    	if(visitFee < 0)    			//create new exception
				    	{
				    		throw new Exception("Office visit fee can not a negaive number! Try again.");
				    	}
				    	break;							//if visitFee is legit, break out of the while loop
				    }
				    catch(NumberFormatException e)		//catch exception when user's input is anything other than a number
				    {
				    	System.out.print("Input Mismatch Exception! Try again. ");
				    	continue;						//continue the loop if exception is caught
				    }
				    catch(Exception e)					//catch exception created above
				    {
				    	System.out.print(e.getMessage());
				    	continue;						//continue the loop if exception is caught
				    }
				}
				kb.nextLine();							//cancel out the reluctant line
				Doctor d0 = new Doctor(doctorName, specialty, visitFee);	//Create doctor object with checked valid input
				doctorArray[i] = d0;					//store doctor object into the array
		} //end creating doctor array/end storing objects in the array
		
		System.out.print("\n-----------------------------" + 
				"\nCreate Patient Array:" +
				"\n-----------------------------");
		for(i = 0; i<patientNo; i++)					//Fill out patient array with input
		{
				System.out.print("\nPatient " + i + 
								 "\nEnter patient's name: ");
				String patientName = "";
				patientName = kb.nextLine();
				/*while (true) 
				{
				    try 
				    {
				    	patientName = kb.next();
				        break;
				    }
				    catch(IllegalArgumentException ignore)
				    {}
				}*/
				
				int patientID = 0;
				while (true) 
				{
				    try 
				    {
				    	System.out.print("Enter Patient ID: ");
				    	patientID = Integer.parseInt(kb.next());	//change user input to Integer
				    	
				    		if (patientID < 1000 || patientID > 9999)
				    		{
				    			throw new Exception("Patient ID should be 4 digit Number! Try again. ");
				    		}
				    		break;
				    	
				    }
				    catch(NumberFormatException e)
				    {
				    	System.out.print("Input Mismatch Exception! Try again. ");
				    	continue;				//continue the loop if exception is caught
				    }
				    catch(Exception ignore)
				    {
				    	System.out.print(ignore.getMessage());
				        continue;				//continue the loop if exception is caught
				    }
				}
				kb.nextLine();
				Patient p0 = new Patient(patientName, patientID);	//Create patient object with user's input
				patientArray[i] = p0;			//Store created patient object into the array 
			
		}
		System.out.print("\n");
		for(i = 0; i < patientNo; i++)			//display patient's information
		{
			Patient p1 = patientArray[i];
		}
		char ch;
		int a;
		i = 0;
		String inputLine = "";
		Billing[] billingArray = new Billing[100];	//Create an array type Billing with size of 100 (dummy size)
		do
		{
		System.out.print("Enter Patient index: ");	//Get patient index
		int patientInd = 0;
		int docInd = 0;
		while (true)
		{
			
			try
			{
				
				patientInd = Integer.parseInt(kb.next());
				System.out.print("Enter Doctor index: ");
				while (true)
				{
					try
					{
						docInd = Integer.parseInt(kb.next());
						if (docInd < 0 || docInd > doctorNo - 1)
						{
							throw new Exception("Array Index Out Of Bounds Exception! Try again.");
						}
						break;
					}
					catch (Exception e)
					{
						System.out.print(e.getMessage());
						System.out.print("Do you want to set another appointment? (y/n)");
						inputLine = kb.nextLine();
						continue;
					}
				}
				
					if (patientInd < 0 || patientInd > patientNo - 1)
					{
						throw new Exception("Array Index Out Of Bounds Exception! Try again.");
					}
					break;
				
			}
			catch (Exception e)
			{
				System.out.print(e.getMessage());
				System.out.print("Do you want to set another appointment? (y/n)");
				inputLine = kb.nextLine();
				continue;
			}
		
		}
			
		Billing b0 = new Billing(doctorArray[docInd], patientArray[patientInd]);
		billingArray[i] = b0;
		i++;
		a = i;
		kb.nextLine();
		System.out.print("Do you want to set another appointment? (y/n)");
		inputLine = kb.nextLine();
		ch = inputLine.charAt(0);
		
		} while (ch == 'y');
		
		for(i = 0; i < doctorNo; i++)
		{
			
			Billing b1 = billingArray[i];
			b1.display();
		}
		
	}
}
