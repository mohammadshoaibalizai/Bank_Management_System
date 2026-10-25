
import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.List;
public class AccountManager {
private final  List<BankAccount> accounts=new ArrayList<>();
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
    public BankAccount findAccount(String accountNumber){
    for (BankAccount account:accounts){
        if(account.getAccountNumber().equals(accountNumber)){
            return account;
        }
    }
    return null;
}
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
// Return number of registered accounts
public int getAccountCount(){
    return accounts.size();
}
}
