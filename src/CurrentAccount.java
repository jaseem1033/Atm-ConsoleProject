public class CurrentAccount extends Account {
    final double overDraftLimit = -10000;

    CurrentAccount(int accountNumber, String holderName, double balance, int pin) {
        super(accountNumber, holderName, balance, pin);
    }

    @Override
    String withdraw(double amount, int pin) {
        if(getBalance() - amount < -10000) return "Withdraw failed: Overdraft limit exceeded";
        else {
            if(getPin() != pin) return "Incorrect Pin";
            setBalance(getBalance() - amount);
            return "Withdrawn " + amount + " successfully";
        }
    }
}