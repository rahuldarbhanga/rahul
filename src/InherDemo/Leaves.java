

import java.io.* ;
import java.util.* ;


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
