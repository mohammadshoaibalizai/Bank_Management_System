
/*
 * BankAccount is an abstract base class that represents
 * a general bank account.
 *
 * It provides common account information and operations
 * that can be shared by different types of bank accounts.
 *
 * Concepts used:
 * - Encapsulation
 * - Abstraction
 * - Inheritance
 */
public abstract class BankAccount implements AccountOperation {
    // Private fields protect account data from direct access.
    private String accountholder;
    private String accountNumber;
    private double balance;
    /*
     * Constructs a bank account with the given details.
     *
     * @param accountHolder the name of the account owner
     * @param accountNumber the unique account number
     * @param initialBalance the starting account balance
     */
    public BankAccount(String accountholder,String accountNumber,double balance){
        // Validate the account holder's name.
        if(accountholder==null ||accountholder.isBlank()){
            throw new IllegalArgumentException("Name can not be empty");}

        // Validate the account number.
        if(accountNumber == null ||accountNumber.isBlank()){
            throw new IllegalArgumentException("Account Number  can not be empty");
        }
        // The initial balance must be valid and non-negative.
        if(balance<0){
            throw new IllegalArgumentException("Initial balance can not be negative");}
        this.accountNumber=accountNumber;
        this.accountholder=accountholder;
        this.balance=balance;
    }
    /*
     * Returns the account holder's name.
     *
     * @return the account holder's name
     */


        public String getAccountholder(){
            return accountholder;
       }


        public String getAccountNumber(){
        return accountNumber;
    }

    /*
     * Returns the current account balance.
     *
     * @return the current balance
     */

    public double getBalance(){
        return balance;
    }

    /*
     * Updates the account balance.
     * This method is protected so subclasses can update
     * the balance without accessing the private field directly.
     *
     * @param newBalance the new balance
     */

    protected void changeBalance(double newBalance){
        this.balance=newBalance;
    }


    /*
     * Deposits money into the account.
     *
     * @param amount the amount to deposit
     * @throws IllegalArgumentException if the amount is invalid
     */
    @Override
    public void deposit(double amount){
        // A deposit amount must be greater than zero
        if(!Double.isFinite(amount)||amount<=0){
            System.out.println("Deposit must be greater than zero");
            return;
        }

if (!Double.isFinite(balance+amount)){
    System.out.println("Amount is to large");
    return;
}
changeBalance(balance+amount);
        System.out.println("Deposit Successful");
        System.out.println("New balance "+balance);
    }

    /*
     * Withdraws money from the account.
     * Each account type implements its own withdrawal rules.
     *
     * @param amount the amount to withdraw
     */
public abstract boolean withdraw(double amount);


    /*
     * Returns the specific type of the account.
     *
     * @return the account type
     */
    public abstract String getAccountType();

    /*
     * Displays the account's basic information.
     */

    @Override
    public void showDetails(){
    System.out.println("\n -- Account Details ---");
    System.out.println("Name : "+accountholder);
    System.out.println("Account Number : "+accountNumber);
    System.out.println("Account type : "+getAccountType());
    System.out.println("Balance "+balance);
    }
    //performing and validation of withdraw operatioin
    protected boolean performWithdrawal(double amount) {
        if (!Double.isFinite(amount) || amount <= 0 || amount > balance) {
            return false;
        }
        changeBalance(balance-amount);
        return true;
    }
}