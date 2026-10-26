import java.util.ArrayList;
import java.util.List;

// Registers a new bank account.
// Finds an account by its account number.
// Displays all registered bank accounts.
// Returns the total number of registered accounts.

public class AccountManager {
private final  List<BankAccount> accounts=new ArrayList<>();
//Register a new account
public boolean addAccount(BankAccount account) {

    if (account == null) {
        return false;
    }
    if (findAccount(account.getAccountNumber()) != null) {
        System.out.println("Account Number already Exists!");
        return false;
    }
    accounts.add(account);
    System.out.println("Account created successfully");
    return true;
}
//Find account by its account number.
    public BankAccount findAccount(String accountNumber){
    for (BankAccount account:accounts){
        if(account.getAccountNumber().equals(accountNumber)){
            return account;
        }
    }
    return null;
}
    // Displays all registered bank accounts.
public void showAllAccounts(){
    if (accounts.isEmpty()){
        System.out.println("No accounts registered .");
        return;
    }
    for (BankAccount account:accounts){
        account.showDetails();
        System.out.println("------------------------------------------------------------------");
    }
}
// Returns the total number of registered accounts.ts
public int getAccountCount(){
    return accounts.size();
}
}
