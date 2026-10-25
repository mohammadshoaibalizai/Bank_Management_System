public abstract class BankAccount implements AccontOperation{
    private String accountholder;
    private String accountNumber;
    private double balance;
    public BankAccount(String accountholder,String accountNumber,double balance){
        if(accountholder==null ||accountholder.isBlank()){
            throw new IllegalArgumentException("Name can not be empty");}
        if(accountNumber == null ||accountNumber.isBlank()){
            throw new IllegalArgumentException("Account Number  can not be empty");
        }if(balance<0){
            throw new IllegalArgumentException("Initial balance can not be negative");}
        this.accountNumber=accountNumber;
        this.accountholder=accountholder;
        this.balance=balance;
    }


        public String getAccountholder(){
            return accountholder;
       }


        public String getAccountNumber(){
        return accountNumber;
    }


    public double getBalance(){
        return balance;
    }


    protected void changeBalance(double newBalance){
        this.balance=newBalance;}
    public void deposit(double amount){
        if(!Double.isFinite(amount)||amount<=0){
            System.out.println("Deposit must be greater than zero");
            return;}
if (!Double.isFinite(balance+amount)){
    System.out.println("Amount is to large");
    return;}
changeBalance(balance+amount);
        System.out.println("Deposit Successful");
        System.out.println("New balance "+balance);}
public abstract boolean withdraw(double amount);
    public abstract String getAccountType();
    @Override
    public void showDetails(){
    System.out.println("\n -- Account Details ---");
    System.out.println("Name : "+accountholder);
    System.out.println("Account Number : "+accountNumber);
    System.out.println("Account type : "+getAccountType());
    System.out.println("Balance "+balance);
    }
    protected boolean performWithdrawal(double amount) {
        if (!Double.isFinite(amount) || amount <= 0 || amount > balance) {
            return false;
        }
        changeBalance(balance-amount);
        return true;
    }
    }