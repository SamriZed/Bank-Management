package lab5;

public class CheckingAccount extends BankAccount {
 public CheckingAccount(int accountNumber, String holderName, double balance, String accountType) {
  super (accountNumber, holderName, balance, accountType);
  
 }
 @Override
 public void deposit(double amount) {
  balance += amount;
  String message = (amount + " has been deposited into " + getHolderName() + "'s checking. New balance is "+balance);
  logTransaction(message);
  System.out.println(message);
  
 }
 
 @Override
 public void withdraw(double amount) {
  balance -= amount;
  if (balance <= -500) {
   balance -= 5;
   String message =("Balance has reached -500, overdraft fee of $5 has been applied");
   logTransaction(message);
   System.out.println(message);
  }
  String message =(amount + " has been withdrawn from checking. New balance is " + balance);
  logTransaction(message);
  System.out.println(message);
 }
 
 @Override
 public void displayAccountInfo() {
  System.out.println("Displaying account #" + getAccountNumber() + ":");
  System.out.println("Holders name is "+getHolderName()+ ", Account type is checking, and balance is $"+balance);
  
 }

}