package org.example.oops;

//example of encapsulation in which we are using private access specifier.
public class BankAccount {
    //Encapsulated data
    private double balance;

    //constructor
    public BankAccount(double initialBalance){
        this.balance = initialBalance;
    }

    public void deposit(double amount){
        if(amount>0) {
            balance += amount;
            System.out.println("deposited: " + amount + " "+ "new Balance: " + balance);
        }
    }
    public void withdraw(double amount){
        if(amount<= balance){
            balance -= amount;
            System.out.println("Withdraw : "+ amount + "New Balance :" + balance);
        }
    }
    public double getBalance(){
        return balance;
    }
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        account.deposit(500);
        account.withdraw(200);
    }
}
