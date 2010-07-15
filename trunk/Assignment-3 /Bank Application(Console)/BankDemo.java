
import java.util.*;
import java.io.*;


/* 
	Class Name:- BankDemo
	Desciption:- A Class to Designed To Arrange The Data into Proper Console Format.
*/


class BankDemo
{
public static void main(String args[]) 
{	
	Scanner input = new Scanner(System.in);
	
	Map<Object,String> mp=new HashMap<Object, String>();
	int menu3,menu,menu2,Account_No,Account_No2 ;
	BankDemo bankDemo = new BankDemo(); 
	        do {  	
		String ch ="";
                System.out.println("_______________ Menu ___________________");
                System.out.println("1. Create New Current Account");
                System.out.println("2. Create New Saving Account");
		System.out.println("3. Deposit To Current Account  ");
           	System.out.println("4. Withdraw From Current Account ");
		System.out.println("5. Deposit To Savings Account ");
           	System.out.println("6. Withdraw From Savings Account");
		System.out.println("7. Check Equality");
		System.out.println("8. Compair Accounts");
           	System.out.println("9. Create ATM Account");
                System.out.println("0. Exit");
                System.out.println("________________________________________");
                        System.out.print("Please Enter Your Choice:-  ");
                        menu = input.nextInt();
			switch (menu) {
                        case 1:   do { 			
                		System.out.println("\t_______________ Menu ___________________");           		
				System.out.println("\t1.Enter Information");
				System.out.println("\t2.Display Information");
	            		System.out.println("\t3. Exit");
                		System.out.println("\t________________________________________");	              
				System.out.print("\tPlease Enter Your Choice:-");
                	       	menu2 = input.nextInt();
                	        switch (menu2) 
					{   case 1 : 	Current C1 = new Current();
							C1.Getinfo();						
							Current.addCurrent(C1);
							break;
					    case 2:	Current.display();
					 		break;
					   }
                		} while (menu2 != 3);  					
                   			break;

                        case 2:  do {				
				System.out.println("\t_______________ Menu ___________________");
				System.out.println("\t1.Enter Information");
                		System.out.println("\t2.Display Information");
	            		System.out.println("\t3. Exit");
                		System.out.println("\t________________________________________");			               
                	        System.out.print("\tPlease Enter Your Choice:-  ");
                	        menu3 = input.nextInt();
                	        switch (menu3) { 
					case 1 : Savings S = new Savings();
						S.Getinfo();
						Savings.addSavings(S);	
						break;
					case 2: Savings.display();
						break;					
						 }
                			} while (menu3 != 3);
						
				break; 
 			             
			case 3:	if(Current.Check_list_Empty() == false)
				{ System.out.println("Enter Account No.:-  ");
				  Account_No = input.nextInt();
				  Current CC =  Current.Get_Object(Account_No);
				  CC.deposit(); 
				}
				else
				{ System.out.println("No Current Account Present....!!!"); }
                                break;
                        case 4: if(Current.Check_list_Empty() == false)
				{ System.out.println("Enter Account No.:-  ");
				  Account_No = input.nextInt();
				  Current CCC =  Current.Get_Object(Account_No);
				  CCC.withdraw(); }
				else
				{ System.out.println("No Current Account Present....!!!");  }	
                                break;
			case 5:	if (Savings.Check_list_Empty() == false)
				{ System.out.println("Enter Account No.:-  ");
				  Account_No2 = input.nextInt();
				  Savings SS =  Savings.Get_Object(Account_No2);
				  SS.deposit(); }
				else
				{ System.out.println("No Savings Account Present....!!!"); }	
                                break;
                        case 6: if(Savings.Check_list_Empty() == false)
				{ System.out.println("Enter Account No.:-  ");
				  Account_No2 = input.nextInt();
				  Savings SSS =  Savings.Get_Object(Account_No2);
				  SSS.withdraw(); }
				else
				{ System.out.println("No Savings Account Present....!!!"); }
                                break;
			case 7: if(!((Savings.Check_list_Empty()) && (Current.Check_list_Empty()))) 
				{	System.out.println("\t\tPlease Select Account[ 1:Current 2:Savings]:");
					int Type = input.nextInt();
					if( Type ==1)
					{       System.out.println("\t\tEnter First Account No.:-  ");
				        	Account_No = input.nextInt();
				        	System.out.println("\t\tEnter Second Account No.:-  ");
				        	Account_No2 = input.nextInt();
						if(Current.equals(Account_No,Account_No2) == true)
						 {	System.out.println("\t\tSame Initial Balance..."); }
						else 
						{	System.out.println("\t\tDifferent Initial Balance..."); }
					}	
					else 
					{	System.out.println("\t\tEnter First Account No.:-  ");
				    		Account_No = input.nextInt();
				   		System.out.println("\t\tEnter Second Account No.:-  ");
				    		Account_No2 = input.nextInt();
						if(Savings.equals(Account_No,Account_No2) == true)
						 {	System.out.println("\t\tSame Initial Balance..."); }
						else 
						{	System.out.println("\t\tDifferent Initial Balance..."); }
			        	} }
				else
				{ 	System.out.println("No Savings & Current Account Present....!!!"); }								
				break;
			case 8: if(!((Savings.Check_list_Empty()) && (Current.Check_list_Empty()))) 
				{	System.out.println("\t\tPlease Select Account[ 1:Current 2:Savings]:");
					int Type2 = input.nextInt();
					if( Type2 ==1)
					{       System.out.println("\t\tEnter First Account No.:-  ");
					        Account_No = input.nextInt();
						Current CCCC =  Current.Get_Object(Account_No);
					        System.out.println("\t\tEnter Second Account No.:-  ");
					        Account_No2 = input.nextInt();
						Current CCCC1 =  Current.Get_Object(Account_No2);
						Current Ct = new Current();
						if (Ct.compare(CCCC,CCCC1) == 0)
						 {	System.out.println("\t\tBoth Accounts Have Same Balance..."); }//if
						else if (Ct.compare(CCCC,CCCC1) == 1) 
					         {	System.out.println("\t\tAccount 1 Have Greater Balance Than Account 2...");}//else if
						else  
						{	System.out.println("\t\tAccount 1 Have Lesser Balance Than Account 2..."); }//else
					}	
					else 
					{	System.out.println("\t\tEnter First Account No.:-  ");
				        	Account_No = input.nextInt();
						Savings SSSS =  Savings.Get_Object(Account_No);
				        	System.out.println("\t\tEnter Second Account No.:-  ");
				        	Account_No2 = input.nextInt();
						Savings SSSS1 =  Savings.Get_Object(Account_No2);
						Savings Sv = new Savings();
						if (Sv.compare(SSSS,SSSS1) == 0)
						 {	System.out.println("\t\tBoth Accounts Have Same Balance..."); }
						else if (Sv.compare(SSSS,SSSS1) == 1) 
						{	System.out.println("\t\tAccount 1 Have Greater Balance Than Account 2..."); }
						else  
						{	System.out.println("\t\tAccount 1 Have Lesser Balance Than Account 2..."); }
					} }
				else
				{ 	System.out.println("No Savings & Current Account Present....!!!"); }			
				break;
			case 9:	if(!((Savings.Check_list_Empty()) && (Current.Check_list_Empty()))) 
				{	System.out.println("\t\tPlease Select Account[ 1:Current 2:Savings]:");
					int Type3 = input.nextInt();
					if( Type3 ==1)
					{       System.out.println("\t\tEnter Account No.:-  ");
					        Account_No = input.nextInt();
						Current CCCCC =  Current.Get_Object(Account_No);
						CCCCC.CreateHashMap();	
						CCCCC.displayHashMap();     
						
					}	
					else 
					{	System.out.println("\t\tEnter First Account No.:-  ");
				        	Account_No = input.nextInt();
						Savings SSSSS =  Savings.Get_Object(Account_No);
				        	SSSSS.CreateHashMap();	      
						SSSSS.displayHashMap();
					 }  }
				else
				{ 	System.out.println("No Savings & Current Account Present....!!!"); }	
				break;
                        }//Main Switch
                } while (menu != 0);
}//End Of Main
}//End Of Class BankDemo
