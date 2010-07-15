
import java.util.*;
import java.io.*;


/* 
	Class Name:- Savings
	Desciption:- A Class to Create Savings Account with 2 Operations To Perform i.e. Deposit & Withdraw Money.
		     This Class implements Comparator Interface and Overrides  hashCode() , equals() , compare() Methods.
	Methods: Getinfo(), deposit() , withdraw(), hashCode() , equals() , compare() .
*/

public class Savings extends BankAccount implements Comparator
{
	static Scanner input = new Scanner(System.in);
	public static List<Savings> list = new ArrayList<Savings>(); 
	private static Map<Integer,Savings> SavingMap=new HashMap<Integer,Savings>();
	static int i=0;
	int Account_Count = 0;

//This Method Gets The User Information From Console.	
	public void Getinfo()
	{	System.out.println("\t\tEnter Your Name:- ");
                Customer_name = input.next();
                System.out.println("\t\tEnter Initial Balance:- ");
                Balance = input.nextInt();
		while (Balance < 500) 
		{       System.out.println("\t\tInitial Balance Must Be Greater Than 500");
                        System.out.println("\n\t\tRe-Enter Initial Balance:- ");
                	Balance = input.nextInt();
                }
		Account_Type = "Savings";
		//this.num = ++Account_Count;		
		System.out.println("\t\tSavings Account Created......!!!!");		
	}

//This Method is to Add a New Savings Account.	
	public static void addSavings(Savings saving)
  	{
       	list.add(i,saving);
	i++;	
         }

//This Method is to Get The Object.
	public static Savings Get_Object(int a)
	{
		return list.get(a-1);
	}

//This Method is To Check Weather List is Empty or Not.
	public static boolean Check_list_Empty()
		{
			if(list.isEmpty())
			{ return true;  }
			else
			 { return false; }
		}

//This Method Display The User Information To Console.		
	public static void display()
	{	int counter=0;
		int counter1=0;
         	Iterator<Savings> iterator=list.iterator();
        	System.out.println("\t\tName\t\tAccount No.\t\tAccount Type\t\tBalance");
        	while(iterator.hasNext())               
        	{
                	Savings savings=iterator.next();
                        System.out.println(++counter+ "\t\t" +savings.Customer_name + "\t\t" + ++counter1  +"\t\t\t" +savings.Account_Type +"\t\t\t" +savings.Balance);
                }
        	System.out.println();
	}	

//This Method is To Deposit Money.
	 public void deposit()
	 {      System.out.print("Enter Amount to Deposit:- ");
                Total_Amount = input.nextInt();
                if ((Total_Amount < 0) && (Total_Amount > Balance)) 
		{       System.out.println("Invalid Amount");
                        System.out.println("\nRe-Enter Amount:- ");
                	Total_Amount = input.nextInt();
                }
                Balance = Balance + Total_Amount;
		System.out.println("Your Current Total Balance:- " + Balance);                
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
	{	Savings S= Get_Object(A1);
		Savings S1 = Get_Object(A2);
		if(S.Balance == S1.Balance)
		{ return true; }
		else
		{ return false; }
	}

//This Method is Ovverriden Method To Create Hash Code.
	public int hashCode()
	{ 	
		int m =	(this.Balance) % 10 ;
		return m;
	}

//This Method is Ovverriden Method Which Compares Two Objects are Equal(With There Balance).
	public int compare(Object o1,Object o2)
	{	Savings A1 = (Savings) o1; 
		Savings A2 = (Savings) o2;
		if(A1.Balance == A2.Balance)
		{ System.out.println("A1:= "+A1.Balance + "A2:=" +A2.Balance);
		return 0; }
		else if(A1.Balance > A2.Balance)
		{ return 1; }
		else 
		{ return -1; }
	}

//This Method is To Create A Map.	
 	public static void CreateHashMap()
  	 { Iterator<Savings> iterator=list.iterator();
           while(iterator.hasNext())              
       		 { Savings saving=iterator.next();
           	   int code=saving.hashCode();
                   SavingMap.put(code,saving);  }
           System.out.println("ATM Account Created With Account No. As Password...");
   	}

//This Method is To Display The Map.	
	public static void displayHashMap()
	{
	        for(Map.Entry<Integer,Savings> entry : SavingMap.entrySet())
	        {  System.out.println("Key: "+entry.getKey()+"\t Value: "+entry.getValue());  }
   	}    

	


}//End Of Class Savings


