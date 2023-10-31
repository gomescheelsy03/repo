/*
 * Class: CMSC203 
 * Instructor:Grigoriy Grinberg 
 * Description: The 'SavingsAccount' class represents a bank account that earns interest and may have limited withdrawal capabilities.
 * Due: 11/06/2023
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: _Chelsy Gomes_________
*/


public class SavingsAccount extends BankAccount {

    private static final double RATE = 0.025;  // Annual interest rate
    private int savingsNumber = 0;
    private String accountNumber;

    public SavingsAccount(String owner, double initialBalance) {
        super(owner, initialBalance);
        accountNumber = super.getAccountNumber() + "-" + savingsNumber;
    }

    public SavingsAccount(SavingsAccount oldAccount, double amount) {
        super(oldAccount, amount);
        savingsNumber = oldAccount.savingsNumber + 1;
        accountNumber = super.getAccountNumber() + "-" + savingsNumber;
    }

    public void postInterest() {
        double interest = getBalance() * RATE / 12;  // Monthly interest
        deposit(interest);
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }
}
