package Solid;

/*
* 1. Transfer money in Thailand only
* 2. Transfer money (International)
*
* */

public class DemoBank {
    public static void main(String[] args) {
        // Local
        LocalBankAccount bankAccount = new LocalBankAccount();
        bankAccount.transferMoney(1000);

        // Inter
        InterBankAccount interBankAccount = new InterBankAccount();
        interBankAccount.transferMoney(20000);
    }
}

enum AccountType {
    Local,
    Inter
}

interface TransferMoneyProcess{
    void transferMoney(int amount);
}

class LocalBankAccount implements TransferMoneyProcess{
    public void transferMoney(int amount){
        System.out.println("Transfer money in Thailand only");
    }
}

class InterBankAccount implements TransferMoneyProcess {
    @Override
    public void transferMoney(int amount){
        System.out.println("Transfer money (International)");
    }
}