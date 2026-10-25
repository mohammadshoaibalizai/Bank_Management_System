//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class Main {
    private static final Scanner sc=new Scanner(System.in);
    private static final AccountManager manager=new AccountManager();
    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n===============Bank System =======================");
            System.out.println("1. Create saving account ");
            System.out.println("2. Create current account ");
            System.out.println("3. Deposit ");
            System.out.println("4. Withdraw ");
            System.out.println("5.Check Account");
            System.out.println("6. Show All Account ");
            System.out.println("7. Exit");
            int option = readInt("Choose an option");
            switch (option) {
                case 1:

                    createSavingAccount();
                    break;
                case 2:
                    createCurrentAccount();
                    break;
                case 3:
                    depositMoney();
                    break;
                case 4:
                    withdrawMoney();
                    break;
                case 5:
                    checkAccount();
                    break;
                case 6:
                    manager.showAllAccounts();
                    break;
                case 7:
                    running = false;
                    System.out.println("GoodBye!");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
        sc.close();
    }
    private static void createSavingAccount(){
        String name=readText("Enter account holder name");
        String number=readText("Enter account number : ");
        double balance=readDouble("Enter initial balance :");
        try {
            BankAccount account=new SavingAccont(name,number,balance);
        manager.addAccount(account);
        }catch (IllegalArgumentException e){
            System.out.println("Error : "+e.getMessage());
        }
    }
    private static void createCurrentAccount(){
        String name=readText("Enter account holder name :");
        String number =readText("Enter account number : ");
        double balance=readDouble("Enter account number :");
        double limit=readDouble("Enter overdraft limit : ");
        try {
       BankAccount account=new CurrentAccont(name,number,balance,limit);
       manager.addAccount(account);


        }catch (IllegalArgumentException e){
            System.out.println("Error : "+e.getMessage());
        }
    }
    private static void depositMoney(){
    BankAccount account= getAccountFromInput();
    if (account== null){
        return;
    }
    double amount =readDouble("Enter deposit amount");
    account.deposit(amount);

    }
    private static void withdrawMoney(){
        BankAccount account=getAccountFromInput();
        if(account==null){
            return;
        }
        double amount =readDouble("Enter withdraw amount");
        account.withdraw(amount);

    }
    private static void checkAccount(){
        BankAccount account=getAccountFromInput();
        if(account !=null){
            account.showDetails();
        }
    }
    private static BankAccount getAccountFromInput(){
        String number =readText("Enter account number :");
        BankAccount account=manager.findAccount(number);
        if (account==null){
            System.out.println("Account Not Found " );
        }
        return account;
    }
    private static String readText(String message){
        System.out.println(message);
        return sc.nextLine().trim();

        }
        private static int readInt(String message) {
            while (true) {
                System.out.println(message);
                String input = sc.nextLine().trim();
                try {
                    return Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Enter a valid Integer");
                }
            }
        }
    private static double readDouble(String message){
        while (true){
            System.out.println(message);
            String input =sc.nextLine().trim();
            try{
                double value=Double.parseDouble(input);
                if (!Double.isFinite(value)){
                    System.out.println("Enter a finite number");
                    continue;
                }
                return value;
            }catch (NumberFormatException e){
                System.out.println("Enter a valid Number");
            }
        }
    }}