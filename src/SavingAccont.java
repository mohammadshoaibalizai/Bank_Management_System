/*
 * Represents a savings bank account.
 * Inherits common account features from BankAccount
 * and applies savings-specific withdrawal rules.
 */
public class SavingAccont extends BankAccount{

    /*
     * Creates a savings account with the specified details.
     *
     * @param accountHolder the account owner's name
     * @param accountNumber the unique account number
     * @param initialBalance the initial account balance
     */

    public SavingAccont(String accountholder,String accountholderNumber,double initialBalance){
                super(accountholder,accountholderNumber,initialBalance);
    }
    /*
     * Withdraws money if sufficient balance is available.
     * @param amount the amount to withdraw
     * @return true if the withdrawal succeeds; otherwise, false
     */
        @Override
        public boolean withdraw(double amount){
        if(!Double.isFinite(amount)||amount<=0){
            System.out.println("Invalid withdraw");
            return false;
        }

       if(amount>getBalance()){
           System.out.println("Insufficient Balance ");
           return false;
       }
       return withdrawFromSavings(amount);}

       private boolean withdrawFromSavings(double amount){

           return performWithdrawal(amount);
        }
    // Returns the specific type of this account.
        @Override
        public String getAccountType(){
        return "Saving Account";
        }
    }


