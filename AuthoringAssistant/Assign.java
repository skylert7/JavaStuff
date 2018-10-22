import java.util.Scanner;
public class Assign {

public static int findText(String texttofind, String string)
{
   int atindex = 0;
   int count = 0;

   while (atindex != -1) 
   {

       atindex = string.indexOf(texttofind, atindex);

       if (atindex != -1) 
       {
           count++;
           atindex += texttofind.length();
       }
   }
   return count;
}


public static void main(String [] args){
Scanner scnr = new Scanner(System.in);
System.out.println(" Enter a sample text: ");
String text = scnr.nextLine();
System.out.println("You enter: " + text);

                System.out.print("Find text: ");
                System.out.print("\nEnter a word or phrase to be found: ");
                String texttofind = scnr.nextLine();
                System.out.println("\n" + "\"" + texttofind + "\"" + " instances: "
                + findText(texttofind,text));
}







}


