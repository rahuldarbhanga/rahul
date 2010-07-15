import java.util.*;
import java.io.*;


/* 
	Class Name:- BankAccount
	Desciption:- An Abstact class with 3 abstract Methods deposit() ,  withdraw() , Getinfo().
	Child Classes:- Current Class And Savings Class	
*/

public abstract class BankAccount 
{
       
        public  String Customer_name, Account_Type;
        public int Balance, Total_Amount;
	
        abstract void deposit();

        abstract void withdraw();
	
	abstract void Getinfo();
      
}//End of BankAccount
