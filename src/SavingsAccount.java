public class SavingsAccount extends Account {
    final double minBalance = 500;


    SavingsAccount(int accountNumber, String holderName, double balance, int pin) {
        super(accountNumber, holderName, balance, pin);
    }
    @Override
    String withdraw(double amount, int pin) {
        if(getBalance() - amount < 500) return "A minimum of Rs 500 should be maintained";
        else {
            if(getPin() != pin) return "Incorrect Pin";
            setBalance(getBalance() - amount);
            return "Withdrawn " + amount + " successfully";
        }
    }
}