public class SavingAccont extends BankAccount{
    public SavingAccont(String name,String accountholderNumber,double initialBalance){
                super(name,accountholderNumber,initialBalance);
    }

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
        @Override
        public String getAccountType(){
        return "Saving Account";
        }
    }


