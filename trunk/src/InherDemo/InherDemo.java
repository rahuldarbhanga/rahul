// A Simple Java Programme.

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


}//Example class Ends here.


/*  Class Name:- Salary 
    Parent class:- EmployeeInfo
    Purpose:- To Get Salary information From User.
*/

 class Salary extends EmployeeInfo
{
	public  int salary,hra,da,ta,basic;
	Scanner S = new Scanner(System.in);

/*  Method Name:- SalaryInfo
    Return Type:- Void
    Purpose:- To Display Get Salary information From User.
*/

	public void SalaryInfo()
 	{	
	System.out.println("\n++++++++++++++++++++++++++++ Salary Information++++++++++++++++++++++");
	System.out.println("Enter Basic Salary:-    ");
	basic = S.nextInt();
	System.out.println("Enter HRA:-    ");
	hra = S.nextInt();
	System.out.println("Enter TA:-    ");
	ta = S.nextInt();
	System.out.println("Enter DA:-    ");
	da = S.nextInt();
	}

}//Salary Class Ends here.


/*  Class Name:- Leaves 
    Parent class:- Salary
    Purpose:- To Get Leave information From User As well as to calculate salary.
*/

 class Leaves extends Salary
{
	public int Leaves;
	Scanner S = new Scanner(System.in);

/*  Method Name:- GetLeaveInfo
    Return Type:- Void
    Purpose:- To Get Leave information From User.
*/
	public void GetLeaveInfo()
	{
	System.out.println("\n++++++++++++++++++++++++++ Leave Information ++++++++++++++++++++++");
	System.out.println("Enter Leaves Taken in Current Month (Enter 0 If Not):-    ");
	Leaves = S.nextInt();
	}


/*  Method Name:- GetSalary
    Return Type:- Void
    Purpose:- To Calculate Salary according to Leaves.
*/
	public void GetSalary()
	{
	salary = basic + hra + ta + da; 
	salary = salary - (Leaves * 100);
	}

}//Leaves class Ends Here



/*  Class Name:- Description 
    Parent class:- Leaves
    Purpose:- To display Information in Proper Format.
*/

class Description extends Leaves
{


/*  Method Name:- ShowAll
    Return Type:- Void
    Purpose:- To Show gathered information in proper Format.
*/
	public void ShowAll()
	{
	System.out.println("\n\n***************************** Summary ********************************");
	System.out.println("\tName\t\tDesignation\t\tLeaves\t\tTotal Slary");
	System.out.println("\t"+name+"\t\t"+designation+"\t\t\t"+Leaves+"\t\t"+salary);
	}

}//Description class Ends here.


public class InherDemo 
{

public static void main(String args[])
{
	Scanner S = new Scanner(System.in);
  	
	int ch;
	System.out.println(((char) 27)+"[2J");
	Example Ex = new Example();
	

do
{
        System.out.println("\n++++++++++++++++ Menu ++++++++++++++++++++++++");
	System.out.println("1.Method Overloading");		
	System.out.println("2.Inheritance");
	System.out.println("3.Exit");
	System.out.println("Select Choice:-");
	ch = S.nextInt();
switch(ch)
{
	case 1:	System.out.println("\n++++++++++++++++ Method Overloading Demo ++++++++++++++++++++++++");		
	Ex.Show();
	Ex.Show("Raj");
	Ex.Show("Raj" ,12345678);
	break;

	case 2 :System.out.println("\n++++++++++++++++ Inheritance  Demo +++++++++++++++++++++++++++++++");	
	Description E = new Description();
	E.Getinfo();
	E.Displayinfo();
	E.SalaryInfo();
	E.GetLeaveInfo();
       	E.GetSalary();
	System.out.println(((char) 27)+"[2J");
	E.ShowAll();
	break;

	case 3 : System.exit(0);
		break;

}//Switch
}while(ch != 3); //while
	
}//main

}//InherDemo

