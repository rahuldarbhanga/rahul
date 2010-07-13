// A Simple Java Programme.

//import Allclass.*;
import java.io.* ;
import java.util.* ;



public class InherDemo 
{

public static void main(String args[])
{
	Scanner S = new Scanner(System.in);
  	
	int ch;
	System.out.println(((char) 27)+"[2J");
	EmployeeInfo Ex = new EmployeeInfo();
	

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

