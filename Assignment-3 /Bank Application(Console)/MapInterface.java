
import java.util.*;
import java.io.*;


/* 
	Class Name:- MapInterface
	Desciption:- A Class to Create ATM Accounts with 4 Operations To Perform i.e. Create, Display ,Check Account , Find ATM Holder's Name Which Overrides 
			3 Methods of Map Interface i.e. put() , get() , containsKey().
	Methods: put() , get() , containsKey() , display();
	Collections Used : Array
*/

public class MapInterface 
{

        public static int count;
        int i;
    
        Integer[] For_Keys=new Integer[10];           //Array for key
        Object[] For_Objects=new Object[10];           //Array for object

//This Method Puts (Key,Value) Pair using 2 Arrays.
        public Object put(Object arg1,Object arg2)                
        {
                For_Keys[count]=(Integer)arg1;
                For_Objects[count]=arg2;
		count++;  
  		System.out.println("ATM Account Created With Account No. As Password...");
		return 0;                    
               
        }

//This Method Displays All (Key,Value) Pairs.
	public void display()
	{
	       for(int i = 0; i < count ; i++)
	       { System.out.println("Password: " +For_Keys[i] + "\tObject Name: " +For_Objects[i]); }
		
   	}	
//This Method Checks Weather Perticular Account Number is Present Or Not.
	public boolean containsKey(Object key)
	{	boolean flag = false;
		key = (Integer)key;
		for(int i = 0; i < count ; i++)
	       { 	if(For_Keys[i] == key)
			{ return true; }
		}
		return false;
	}

//This Method Gets The Value For A Perticular Key (Used To Obtain ATM Holder's Name.)
	public Object get(Object key)
	{ 	boolean flag = false;
		key = (Integer)key;
		for(int i = 0; i < count ; i++)
	       { 	if(For_Keys[i] == key)
			{ flag = true; break; }
		}
			if(flag == false)
			{ return null;
			}

		return For_Objects[i];
	}

}//End Of Class Mapinterface


