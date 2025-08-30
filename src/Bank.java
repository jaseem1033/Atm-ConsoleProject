import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Double, Account> accounts= new HashMap<>();

    public String addAccount(double accountNumber, Account ac) {
        if(accounts.containsKey(accountNumber)) return "Account Number already exists";
        else accounts.put(accountNumber, ac);
        return "Account added successfully";
    }

    public Account getAccount(double accountNumber) {
        if(!accounts.containsKey(accountNumber)) return null;
        return accounts.get(accountNumber);
    }

    public String deactivateAccount(double accountNumber, int pin) {
        if(!accounts.containsKey(accountNumber)) return "Account does not exist";
        else {
            if(accounts.get(accountNumber).getPin() != pin) return "Invalid PIN";
            accounts.remove(accountNumber);
            return "Account deactivated successfully";
        }
    }

    public String transfer(double from, double to, double amount, int pin) {
        Account sender = getAccount(from);
        if(sender == null) return "Invalid Sender Account";

        Account receiver = getAccount(to);
        if(receiver == null) return "Invalid Reciever Account";

        if(sender.getPin() != pin) return "Invalid PIN";

        if(sender.getBalance() - amount < 500)  return "You Should maintain minimum Rs 500";
        else {
            sender.withdraw(amount, pin);
            receiver.deposit(amount);
            return "Transfer Successful";
        }
    }
}