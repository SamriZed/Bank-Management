package lab5;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Bank {
 
 static ArrayList <BankAccount> customers = new ArrayList<>();
 

 
 public static void originalDisplay(Scanner scanner) {
  System.out.println("Enter 1 to create an account");
  System.out.println("Enter 2 to make a deposit");
  System.out.println("Enter 3 to withdraw money");
  System.out.println("Enter 4 to transfer funds");
  System.out.println("Enter 5 to view transaction history");
  System.out.println("Enter 6 to display all accounts");
  System.out.println("Enter 7 to exit");
  try {
  int choice = scanner.nextInt();
  scanner.nextLine();
  switch(choice) {
   case(1):
    
    createAccount(scanner);
 
    
    break;
   case(2):
    System.out.println("Login: Please enter your name: ");
    String name = scanner.nextLine();
    System.out.println("Savings or checking: ");
    String type = scanner.nextLine();
    BankAccount account = verifyAccount(name, type);
    if (account == null) {
     break;
    }
    else{
     System.out.println("How much would you like to deposit? ");
     double amount = scanner.nextDouble();
     scanner.nextLine();
     account.deposit(amount);
    }

  
    break;
    
   case(3):
    System.out.println("Login: Please enter your name: ");
    String name2 = scanner.nextLine();
    System.out.println("Savings or checking: ");
    String type2 = scanner.nextLine();
    BankAccount account2 = verifyAccount(name2, type2);
    if (account2 == null) {
     break;
    }
    else{
     System.out.println("How much would you like to withdraw? ");
     double amount = scanner.nextDouble();
     scanner.nextLine();
     account2.withdraw(amount);
    }
    
    break;
    
   case(4):
    System.out.println("Please enter your name: ");
    String own_name = scanner.nextLine();
    System.out.println("Savings or checking: ");
    String own_type = scanner.nextLine();
    BankAccount own_account = verifyAccount(own_name, own_type);
    if (own_account == null) {
     break;
    }
    else{
     System.out.println("Please enter name of account you want to transfer to: ");
     String transfer_name = scanner.nextLine();
     System.out.println("Savings or checking: ");
     String transfer_type = scanner.nextLine();
     BankAccount transfer_account = verifyAccount(transfer_name, transfer_type);
     if (transfer_account == null) {
      break;
     }
     else{
      System.out.println("Amount you would like to transfer: ");
      double amount = scanner.nextDouble();
      scanner.nextLine();
      own_account.withdraw(amount);
      transfer_account.deposit(amount);
      
      
     }
    }
    break;
    
   case(5):
    System.out.println("Please enter your name: ");
    String history_name = scanner.nextLine();
    System.out.println("Savings or checking: ");
    String history_type = scanner.nextLine();
    BankAccount history_account = verifyAccount(history_name, history_type);
   if (history_account == null) {
    break;
   }
   else{
    history_account.displayLog();
   }
    break;
    
   case(6):
    for (BankAccount x : customers) {
     x.displayAccountInfo();
    }
    break;
   case(7):
    System.exit(7);
    break;
    
  }
  
  
  
  }catch(InputMismatchException e) { 
   System.out.println("Invalid input. Please enter a valid number."); 
   scanner.nextLine();
  }
    
  
 }
 
 public static BankAccount verifyAccount(String name, String type) {
  for (BankAccount account : customers) {
   if (account.getHolderName().equalsIgnoreCase(name) && account.getAccountType().equalsIgnoreCase(type)) {
    System.out.println(name + " has a " + type + " account.");
    return account; 
   }
  }
  System.out.println("User not found.");
  return null; 
  }
 
 static void createAccount(Scanner scanner) {
  
  
  System.out.println("Please enter account type(savings or checking): ");
  String type = scanner.nextLine();
  System.out.println("Please enter deposit amount: ");
  double amount = scanner.nextDouble();
  scanner.nextLine();
  Random account = new Random();
  
  
  
  switch (type){
   case("savings"):
    if (amount >= 100) { 
     System.out.println("Please enter your name: ");
     String name = scanner.nextLine();
     int accountNumber = 1000 + account.nextInt(9000);
     String message = ("Savings account has been created for " +name + " with account number "+ accountNumber);
     
     System.out.println(message);
     BankAccount one = new SavingsAccount(accountNumber, name, amount, "savings");
     one.logTransaction(message);
     customers.add(one);
     ((SavingsAccount) one).addInterest();
    }
    else {
     System.out.println("Cannot create account. Minimum balance must be $100");
    }
    break;
   case("checking"):
    System.out.println("Please enter your name: ");
    String name = scanner.nextLine();
    int accountNumber = 1000 + account.nextInt(9000);
    String message =("Checking account has been created for " + name + " with account number " + accountNumber);
    System.out.println(message);
    BankAccount one = new CheckingAccount(accountNumber, name, amount, "checking");
    one.logTransaction(message);
    customers.add(one);
    break;
  }

 } 
 public static void displayAllAccounts() {
  for (BankAccount x: customers) {
   x.displayAccountInfo();
  }
 

 }

  

 public static void main(String[] args) {

  Scanner scanner = new Scanner(System.in);
  Boolean a =true;
  while (a) {
   originalDisplay(scanner);
  }
  scanner.close();

  

  
  

  
  
 }

}