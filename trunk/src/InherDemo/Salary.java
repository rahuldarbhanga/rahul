

import java.io.* ;
import java.util.* ;


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


