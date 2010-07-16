
import java.util.*;
import java.io.*;


/* 
	Class Name:- Current
	Desciption:- A Class to Create Current Account with 2 Operations To Perform i.e. Deposit & Withdraw Money.
		     This Class overrides equals()  Methods of List.
	Methods: Getinfo(), deposit() , withdraw(),  equals() , compare() ,addSavings() , Get_Object() , Check_list_Empty() .
	Collections Used : HashMap , ArrayList

*/

public class Current extends BankAccount 
{
	static Scanner input = new Scanner(System.in);
	public static List<Current> list2 = new ArrayList<Current>(); 
	private static Map<Integer,Current> CurrentMap=new HashMap<Integer,Current>();
	static int i=0;
	int Account_Count = 0;
	
//This Method Gets The User Information From Console.
	public void Getinfo()
	{	System.out.println("\t\tEnter Your Name:- ");
               	this.Customer_name = input.next();
               	System.out.println("\t\tEnter Initial Balance:- ");
                this.Balance = input.nextInt();
		while (Balance < 1000) 
		{       System.out.println("\t\tInitial Balance Must Be Greater Than 1000");
                        System.out.println("\n\t\tRe-Enter Initial Balance:- ");
                	 this.Balance = input.nextInt();			
                }			
		this.Account_Type = "Current";
		System.out.println("\t\tCurrent Account Created......!!!!");	
	}

//This Method is to Add a New Current Account.	
	public static void addCurrent(Current C1)
  	{ 	list2.add(i,C1);
		i++;	}

//This Method is to Get The Object.
	public static Current Get_Object(int a)
	{	return list2.get(a-1); 	}

//This Method is To Check Weather List is Empty or Not.
	public static boolean Check_list_Empty()
	{	if(list2.isEmpty())
		{ return true;  }
		else
		 { return false; }
	}

//This Method Display The User Information To Console.	
	public static void display()
	{	 Iterator<Current> iterator=list2.iterator();
		 int counter=0;
		 int counter1=0;
        	 System.out.println("\t\tName\t\tAccount No.\t\tAccount Type\t\tBalance");
        	 while(iterator.hasNext())               
        	  { Current current=iterator.next();
                    System.out.println(++counter+ "\t\t" +current.Customer_name + "\t\t" + ++counter1 +"\t\t\t" +current.Account_Type +"\t\t\t" +current.Balance);
        	  }
        	System.out.println();
	}

//This Method is To Deposit Money.
	 public void deposit()
	 {      System.out.print("Enter Amount to Deposit:");
                Total_Amount = input.nextInt();
                if( (Total_Amount < 0) && (Total_Amount > Balance)) 
		{       System.out.println("Invalid Amount");
			System.out.println("\nRe-Enter Amount:- ");
                	Total_Amount = input.nextInt();
                 }
                Balance = Balance + Total_Amount;
		System.out.println("\nYour Current Total Balance is:- " + Balance);		
         }

//This Method is To Withdraw Money.
	public void withdraw() 
	{       System.out.println("Your Current Balance is:- " + Balance);
                System.out.print("Enter Amount to Withdraw:");
                Total_Amount = input.nextInt();
                if (Balance < Total_Amount) 
		{       System.out.println("Not Sufficient Balance.");
                        System.out.println("\nRe-Enter Amount:- ");
                	Total_Amount = input.nextInt();
                }
                if (Total_Amount < 0) 
		{       System.out.println("Invalid Amount");
                        System.out.println("\nRe-Enter Amount:- ");
                	Total_Amount = input.nextInt();
                }
                Balance = Balance - Total_Amount;
		System.out.println("Your Current Total Balance:- " + Balance);                
        }
	
//This Method is Ovverriden Method Which Checks Weather Two Objects are Equal(With There Balance).
	public static boolean equals(int A1,int A2)
	{	Current C = Get_Object(A1);
		Current C1 = Get_Object(A2);
		if(C.Balance == C1.Balance)
		{ return true; }
		else
		{ return false; }
	}

	
//This Method is Ovverriden Method Which Compares Two Objects are Equal(With There Balance).
	public int compare(Object o1,Object o2)
	{	Current A1 = (Current) o1; 
		Current A2 = (Current) o2;
		if(A1.Balance == A2.Balance)
		{ 
		return 0; }
		else if(A1.Balance > A2.Balance)
		{ return 1; }
		else 
		{ return -1; }
	}
 

}//End Of Class Current
