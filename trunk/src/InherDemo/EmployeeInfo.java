

import java.io.* ;
import java.util.* ;

/*  Class Name:- EmployeeInfo
    Purpose:- To Get Primary information From User.
*/

class EmployeeInfo
{	
	public String name,address,designation;
	private  long phone;

/*  Method Name:- GetInfo
    Return Type:- Void
    Purpose:- To Get Input From keyBoard.
*/
	public  void Getinfo()
	{
	Scanner S = new Scanner(System.in);
  	
	System.out.println("\nEnter Name:-    ");
	name = S.next();
	System.out.println("Enter Address:-    ");
	address = S.next();
	System.out.println("Enter Phone No.:-    ");
	phone = S.nextLong();
	System.out.println("Enter Designation:-    ");
	designation = S.next();
	}

/*  Method Name:- DisplayInfo
    Return Type:- Void
    Purpose:- To Display User information on Console.
*/

	public void Displayinfo()
	{
	System.out.println("\n+++++++++++++++++++++++++++ Information +++++++++++++++++++++++++");
	System.out.println("Your Name:-  " +name);
	System.out.println("Your Address:-  " +address);
	System.out.println("Your Phone No.:-  " +phone);
	System.out.println("Your Designation:-  " +designation);
	System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}

	void Show()
	{
	System.out.println("Nothing to Show");
	}

	void Show(String n)
	{
	name = n;
	System.out.println("You Entered:-  " +name);
	}

	void Show(String n,long p)
	{
	name = n;
	phone = p;
	System.out.println("You Entered Name:-  " +name + "And Phone:-  " +phone);
	}


}//EmployeeInfo class Ends here.





