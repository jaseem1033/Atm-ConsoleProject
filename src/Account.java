public abstract class Account {
    protected int accountNumber;
    protected String holderName;
    private double balance;
    private final int pin;

    Account(int accountNumber, String holderName, double balance, int pin) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.pin = pin;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }
    public String getHolderName() {
        return this.holderName;
    }
    public double getBalance() {
        return this.balance;
    }
    public int getPin() { return this.pin; }

    public String deposit(double var1) {
        this.balance += var1;
        return "Deposited " + var1 + " successfully";
    }

    public void setBalance(double var1) {
        this.balance = var1;
    }
    abstract String withdraw(double var1, int pin);
}