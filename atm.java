import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class atm
{
    float Balance=0;
    int pin;
    List<String> transactions;
    public atm() 
    {
        Balance = 0;
        transactions = new ArrayList<>();
       
    }

    public void checkpin()
    {   
    	System.out.print("Create PIN:");
    	Scanner sc=new Scanner(System.in);
        pin=sc.nextInt();
    
        System.out.print("\nPlease Enter the PIN:");
        
        int epin;
        epin = sc.nextInt();
        if(pin==epin)
        {
            menu();
        }
        else
        {
            System.out.print("\nPlease Enter Valid PIN");  
            System.out.print("\nPlease Enter the PIN:");
            
            epin=sc.nextInt();
            menu();
            
        }
  
        sc.close();

    }
    
    public void menu()
    {
        System.out.println("\nENTER YOUR CHOICE\n");
        System.out.println("1. Check A/C Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Transfer Money");
        System.out.println("5. Transaction History");
        System.out.println("6. Exit");
        Scanner sc= new Scanner(System.in);
        int opt=sc.nextInt();
        System.out.println("Entered Choice is: "+opt+"\n");
        if(opt==1)
        {
           checkBalance();
        }
        else if(opt==2)
        {
            withdrawMoney();
        }
        else if(opt==3)
        {
            depositMoney();
        }
        else if(opt==4)
        {
            transfer();
        }
        else if(opt==5)
        {
        	displayTransactionsHistory();
        }
        else if(opt==6)
        {	System.out.println("Thank you for using our ATM. Have a great day!");
            return;
        }
        else
        {
            System.out.println("\nEnter a Valid Choice\n");
        }
        
    }
    
    public void checkBalance()
    {
        System.out.println("Available Balance is: "+Balance+"\n");
        menu();
    }
    
    public void withdrawMoney()
    {
        System.out.print("Enter Amount to WITHDRAW: ");
        Scanner sc=new Scanner(System.in);
        float amount=sc.nextFloat();
        if(amount>Balance)
        {
            System.out.println("\nInsufficient Balance");
        }
        else
        {
           
        	Balance = Balance - amount;
        	transactions.add("Withdrawal of Rs." + Balance); 
        	
            System.out.println("\nMoney Withdrawal Successfull");
            System.out.println("\nNew Balance is: Rs."+Balance+"\n");
        }
        menu();
        sc.close();
    }

    public void depositMoney()
    {
        System.out.print("Enter Amount to DEPOSIT: ");
        Scanner sc=new Scanner(System.in);
        float amount=sc.nextFloat();
        Balance = Balance + amount;
      transactions.add("Deposit of Rs." + Balance);
        System.out.println("\nMoney has been Deposited Successfully\n ");
        System.out.println("Available Balance is: Rs."+Balance+"\n");
        menu();
    }
    
    public void transfer() 
    {
        System.out.print("Enter the amount to TRANSFER: ");
        Scanner sc=new Scanner(System.in);
        float amount = sc.nextFloat();
        if (Balance >= amount) 
        {
           Balance -= amount;
           System.out.println("Transfer successful. Your current balance is Rs." + Balance);
        } 
        else 
        {
           System.out.println("Insufficient funds. Your current balance is Rs." + Balance);
        }
        transactions.add("Transfer of Rs." + amount);
        menu();
     }
    
    public void displayTransactionsHistory() 
    {
    	System.out.println("Transactions History\n");
        for (String transaction : transactions) {
        System.out.println(transaction);
        menu();
    }
}

    public static void main(String[] args) 
    {
        atm obj = new atm();
        obj.checkpin();
    }
}



