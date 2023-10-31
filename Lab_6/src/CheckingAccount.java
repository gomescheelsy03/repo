/*
 * Class: CMSC203 
 * Instructor:Grigoriy Grinberg 
 * Description: The 'CheckingAccount' class represents a bank account that allows unlimited deposits and withdrawals.
 * Due: 11/06/2023
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: _Chelsy Gomes_________
*/

public class CheckingAccount extends BankAccount {

    private static final double FEE = 0.15;

    public CheckingAccount(String owner, double initialAmount) {
        super(owner, initialAmount);
        String newAccountNumber = super.getAccountNumber() + "-10";
        setAccountNumber(newAccountNumber);
    }

    @Override
    public boolean withdraw(double amount) {
        double totalAmount = amount + FEE;
        return super.withdraw(totalAmount);
    }
}
