public interface AccountOperation {
    void deposit(double amount);
    boolean withdraw(double amount);
    void showDetails();
}
