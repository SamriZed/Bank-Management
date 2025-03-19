package lab5;

public class SavingsAccount extends BankAccount{
 private double minimumBalance;
 private double monthlyInterest;
 
 public SavingsAccount(int accountNumber, String holderName, double balance, String accountType) {
  super (accountNumber, holderName, balance, accountType);
  minimumBalance = 100;
  monthlyInterest = 0.0025;
  if (balance < minimumBalance) {
   System.out.println("Insufficient funds. Below minimum.");
  }
 }
 
 @Override
 public void deposit(double amount) {
  balance += amount;
  String message = ("$" + amount + " has been deposited into " + getHolderName() + " savings. New balance is "+balance);
  System.out.println(message);
  logTransaction(message);
 }
 
 @Override
 public void withdraw(double amount) {
  balance -= amount;
  if (balance < minimumBalance) {
   String message = ("Insufficient funds. Cannot Withdraw below minimum.");
   System.out.println(message);
   logTransaction(message);
   balance+=amount;
  }
  else {
   String message = (amount + " has been withdrawn from " + getHolderName() +"'s savings. New balance is "+balance);
   System.out.println(message);
   logTransaction(message);
  }
 }
 @Override
 public void displayAccountInfo() {
  System.out.println("Displaying account #" + getAccountNumber() + ":");
  System.out.println("Holders name is "+ getHolderName()+ ", Account type is savings, and balance is $"+balance);
  
 }
 
 public void addInterest() {
  balance = balance + (balance * monthlyInterest);
  String message =("1 month has passed. Monthly interest has been added");
  System.out.println(message);
  logTransaction(message);
 }


 
}