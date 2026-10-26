
/*
 * Represents a current bank account.
 * A current account allows customers to deposit and
 * withdraw money. It may also support an overdraft,
 * which allows withdrawals beyond the available balance
 * up to a predefined limit.

 * Concepts used:
 * - Inheritance
 * - Method Overriding
 * - Encapsulation
 * - Polymorphism
 */
public class CurrentAccont extends BankAccount {
    private final double overdraftLimit;

    /*
     * Constructs a current account with the specified details.
     *
     * @param accountHolder the name of the account owner
     * @param accountNumber the unique account number
     * @param initialBalance the starting account balance
     * @param overdraftLimit the maximum permitted overdraft
     */

    public CurrentAccont(String accountholder, String accountNumber, double initialBalance, double overdraftLimit) {
        // Initialize the common account properties
        super(accountholder, accountNumber, initialBalance);

        // An overdraft limit cannot be negative or invalid.
        if (!Double.isFinite(overdraftLimit) || overdraftLimit < 0) {
            throw new IllegalArgumentException("Invalid overdraft limit");
        }
        this.overdraftLimit = overdraftLimit;
    }

    /*
     * Withdraws money within the available balance and overdraft limit.
     *
     * @param amount the amount to withdraw
     * @return true if the withdrawal succeeds; otherwise, false
     */
    public boolean withdraw(double amount) {

        // Reject zero, negative, NaN, and infinite amounts
        if (!Double.isFinite(amount) || amount <= 0) {
            System.out.println("Invalid withdraw amount");
            return false;
        }
        if (amount > getBalance() + overdraftLimit) {
            System.out.println("withdraw exceeds overdraft limit");
            return false;
        }
        // Update the balance after all checks pass.
       changeBalance(getBalance() - amount);
System.out.println("withdraw successful.");
System.out.println("New balance :"+getBalance());
return true;
    }


    /*
     * Returns the type of this bank account.
     *
     * @return the account type
     */
    @Override
    public String getAccountType(){
        return "Current Account";
    }
}