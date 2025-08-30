import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println( "Welcome to the Banking System");
        Bank bank = new Bank();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println( "Enter your choice: \n" +
                    "1. Create Savings Account \n" +
                    "2. Create Current Account \n" +
                    "3. Deactivate Account \n" +
                    "4. Deposit Money \n" +
                    "5. WithDraw Money \n" +
                    "6. Transfer Money \n" +
                    "7. Check Balance \n" +
                    "8. Exit \n" +
                    "Enter your choice: ");
            int n = sc.nextInt();

            switch (n) {
                case 1:
                    System.out.println("Set your 8 digit Account Number: ");
                    int accountNumber = sc.nextInt();
                    if(bank.getAccount(accountNumber) != null) {
                        System.out.println("Account Number already exists");
                        break;
                    }
                    System.out.println("Enter your Name: ");
                    String holderName = sc.next();
                    System.out.println("Set your PIN: ");
                    int pin = sc.nextInt();
                    System.out.println("Enter your Balance: ");
                    double balance = sc.nextDouble();
                    String op = bank.addAccount(accountNumber, new SavingsAccount(accountNumber, holderName, balance, pin));
                    System.out.println(op);
                    break;

                case 2:
                    System.out.println("Set your 8 digit Account Number: ");
                    accountNumber = sc.nextInt();
                    if(bank.getAccount(accountNumber) != null) {
                        System.out.println("Account Number already exists");
                        break;
                    }
                    System.out.println("Enter your Name: ");
                    holderName = sc.next();
                    System.out.println("Set your PIN: ");
                    pin = sc.nextInt();
                    System.out.println("Enter your Balance: ");
                    balance = sc.nextDouble();
                    op = bank.addAccount(accountNumber, new CurrentAccount(accountNumber, holderName, balance, pin));
                    System.out.println(op);
                    break;

                case 3:
                    System.out.println("Enter your account number: ");
                    accountNumber = sc.nextInt();
                    System.out.println("Enter your PIN: ");
                    pin = sc.nextInt();
                    op = bank.deactivateAccount(accountNumber, pin);
                    System.out.println(op);
                    break;

                case 4:
                    System.out.println("Enter your account number: ");
                    accountNumber = sc.nextInt();
                    System.out.println("Enter the Amount: ");
                    double amount = sc.nextDouble();
                    Account ac = bank.getAccount(accountNumber);
                    if(ac == null) System.out.println("Account does not exist");
                    else System.out.println(ac.deposit(amount));
                    break;

                case 5:
                    System.out.println("Enter your account number: ");
                    accountNumber = sc.nextInt();
                    System.out.println("Enter your pin: ");
                    pin = sc.nextInt();
                    ac = bank.getAccount(accountNumber);
                    if(ac == null) System.out.println("Account does not exist");
                    else {
                        System.out.println("Enter the Amount: ");
                        amount = sc.nextDouble();
                        System.out.println(ac.withdraw(amount, pin));
                    }
                    break;

                case 6:
                    System.out.println("Enter your account number: ");
                    accountNumber = sc.nextInt();
                    System.out.println("Enter the receiver's account number: ");
                    int to = sc.nextInt();
                    System.out.println("Enter the amount: ");
                    amount = sc.nextDouble();
                    System.out.println("Enter your pin: ");
                    pin = sc.nextInt();
                    op = bank.transfer(accountNumber, to, amount, pin);
                    System.out.println(op);
                    break;

                case 7:
                    System.out.println("Enter your account number: ");
                    accountNumber = sc.nextInt();
                    ac = bank.getAccount(accountNumber);
                    if(ac == null) {
                        System.out.println("Account does not exist");
                        break;
                    }
                    System.out.println("Enter your pin: ");
                    pin = sc.nextInt();
                    if(ac.getPin() != pin) {
                        System.out.println("Invalid PIN");
                        break;
                    }
                    else {
                        System.out.println("Balance: " + ac.getBalance());
                    }
                    break;

                case 8:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }
}