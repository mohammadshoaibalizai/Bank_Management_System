public class CurrentAccont extends BankAccount {
    private final double overdraftLimit;

    public CurrentAccont(String accountholder, String accountNumber, double balance, double overdraftLimit) {
        super(accountholder, accountNumber, balance);
        if (!Double.isFinite(overdraftLimit) || overdraftLimit < 0) {
            throw new IllegalArgumentException("Invalid overdraft limit");
        }
        this.overdraftLimit = overdraftLimit;
    }

    public boolean withdraw(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            System.out.println("Invalid withdraw amount");
            return false;
        }
        if (amount > getBalance() + overdraftLimit) {
            System.out.println("withdraw exceeds overdraft limit");
            return false;
        }
       changeBalance(getBalance() - amount);
System.out.println("withdraw successful.");
System.out.println("New balance :"+getBalance());
return true;
    }
    @Override
    public String getAccountType(){
        return "Current Account";
    }
}