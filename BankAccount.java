package lab5;
import java.util.ArrayList;

abstract class BankAccount implements TransactionLogger{
 private int accountNumber;
 private String holderName;
 public double balance;
 private String accountType;
 private ArrayList<String> transactionLog = new ArrayList<>();
 
 public BankAccount() {
  setAccountNumber(0000);
  setHolderName("");
  balance = 0.0;
  accountType = "savings";
  
 }
 
 public BankAccount(int accountNumber, String holderName, double balance, String accountType) {
  this.setAccountNumber(accountNumber);
  this.setHolderName(holderName);
  this.balance = balance;
  this.accountType = accountType;
 }
 
 public abstract void deposit(double amount);
 
 public abstract void withdraw(double amount);
 
 public double getBalance() {
  return balance;
 }
 
 public abstract void displayAccountInfo();

 public int getAccountNumber() {
  return accountNumber;
 }

 public void setAccountNumber(int accountNumber) {
  this.accountNumber = accountNumber;
 }

 public String getHolderName() {
  return holderName;
 }

 public void setHolderName(String holderName) {
  this.holderName = holderName;
 }
 
 public String getAccountType() {
  return accountType;
 }
 
 @Override
 public void logTransaction(String message) {
  transactionLog.add(message);
 }

 @Override
 public void displayLog() {
  if (transactionLog.isEmpty()) {
   System.out.println("There are no transactions to display");
  } else {
   for (String transaction : transactionLog) {
    System.out.println(transaction);
   }
  }
 }

 
 
 

}