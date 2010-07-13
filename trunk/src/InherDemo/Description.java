

import java.io.* ;
import java.util.* ;


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

