package SimpleProjects;

import java.util.Scanner;

public class Bank_Management_Software 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your 'Name' and 'CustomerID' to access your Bank Account:");
		String name = input.nextLine();
		String customerID = input.nextLine();
		BankAccount obj1 = new BankAccount(name, customerID);
		obj1.menu();
	}

}

class BankAccount
{
	double bal;
	double prevTrans;
	String customerName;
	String customerID;
	
	BankAccount (String customerName, String customerID)
	{
		this.customerName = customerName;
		this.customerID = customerID;
	}
	
	void deposit(double amount)
	{
		if(amount != 0) //not equal
		{
			bal += amount; //balance plus the amount is what the new balance will be
			prevTrans = amount;
		}
	}
	
	void withdraw(double amt)
	{
		if (amt != 0 && bal >= amt) 
			//amount doesn't equal 0 and balance is less than or equal to amount
		{
			bal -= amt;
			prevTrans -= amt; //take away from the amount when you withdraw
		}
		else if (bal < amt) //can't take out what you don't have
		{
			System.out.println("Bank balane insufficient");
		}
			
	}
	
	void getPreviousTrans()
	{
		if(prevTrans > 0)
		{
			System.out.println("Deposited: " + prevTrans);
		}
		else if(prevTrans < 0)
		{
			System.out.println("Withdrawn: " + Math.abs(prevTrans));
		}
		else
		{
			System.out.println("No transaction occurde");
		}
	}
	
	void menu ()
	{//giving the user options on what they want to do
		char option; 
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome "+customerName);
        System.out.println("Your ID:"+customerID);
        System.out.println("\n");
        System.out.println("a) Check Balance");
        System.out.println("b) Deposit Amount");
        System.out.println("c) Withdraw Amount");
        System.out.println("d) Previous Transaction");
        System.out.println("e) Exit");
        
        do
        {
        	System.out.println("********************************************");
            System.out.println("Choose an option");
            option=input.next().charAt(0);
            System.out.println("\n");

            switch (option){
                case 'a':
                    System.out.println("......................");
                    System.out.println("Balance ="+bal);
                    System.out.println("......................");
                    System.out.println("\n");
                    break;
                case 'b':
                    System.out.println("......................");
                    System.out.println("Enter a amount to deposit :");
                    System.out.println("......................");
                    double amt=input.nextDouble();
                    deposit(amt);
                    System.out.println("\n");
                    break;
                case 'c':
                    System.out.println("......................");
                    System.out.println("Enter a amount to Withdraw :");
                    System.out.println("......................");
                    double amtW=input.nextDouble();
                    withdraw(amtW);
                    System.out.println("\n");
                    break;
                case 'd':
                    System.out.println("......................");
                    System.out.println("Previous Transaction:");
                    getPreviousTrans();
                    System.out.println("......................");
                    System.out.println("\n");
                    break;

                case 'e':
                    System.out.println("......................");
                    break;
                default:
                    System.out.println("Choose a correct option to proceed");
                    break;
            }
        }while(option != 'e');
        
        System.out.println("Thank you for using our banking services");
	}
	
	
}
    




