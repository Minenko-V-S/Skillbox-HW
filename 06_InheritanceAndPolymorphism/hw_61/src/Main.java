import hw_61.BankAccount;
import hw_61.CardAccount;
import hw_61.DepositAccount;

import java.time.LocalDate;


public  class Main {
    public static void main(String[] args) {
        LocalDate lastDateOfDepo = LocalDate.of(2020,07,16);
        BankAccount bankAccount = new BankAccount();
        DepositAccount depositAccount = new DepositAccount(lastDateOfDepo, 1000);
        CardAccount cardAccount = new CardAccount();

        System.out.println("Банковский счет");
        System.out.println("на счету " + bankAccount.getBalance());
        bankAccount.deposit(1000);
        System.out.println("на счету " + bankAccount.getBalance());
        bankAccount.withdraw(900);
        System.out.println("на счету " + bankAccount.getBalance());
        bankAccount.withdraw(101);
        System.out.println("на счету " + bankAccount.getBalance());
        System.out.println("==================================\n");

        System.out.println("Депозитный счет");
        System.out.println("на счету " + depositAccount.getBalance());
        depositAccount.withdraw(100);
        System.out.println("на счету " + depositAccount.getBalance());
        depositAccount.deposit(100);
        System.out.println("на счету " + depositAccount.getBalance());
        depositAccount.withdraw(100);
        System.out.println("на счету " + depositAccount.getBalance());
        System.out.println("==================================\n");

        System.out.println("Карточный");
        System.out.println("на счету " + cardAccount.getBalance());
        cardAccount.withdraw(100);
        System.out.println("на счету " + cardAccount.getBalance());
        cardAccount.deposit(1010);
        System.out.println("на счету " + cardAccount.getBalance());
        cardAccount.withdraw(1000);
        System.out.println("на счету " + cardAccount.getBalance());
        System.out.println("==================================\n");

    }
}
