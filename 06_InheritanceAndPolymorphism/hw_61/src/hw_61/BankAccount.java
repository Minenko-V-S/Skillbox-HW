package hw_61;


public class BankAccount {
    private long balance;

    public BankAccount() {

    }

    public BankAccount(long amount) {
        balance = amount;
    }

    public void deposit (long value) {
        System.out.println("Пополнение");
        balance += value;
    }

    public boolean withdraw (long value) {
        System.out.println("Снимаем...");
        if (balance >= value) {
            balance -= value;
            System.out.printf("Успех. Списано %d\n", value);
            return true;
        } else {
            System.out.println("Ошибка. Недостаточно средств");
            return false;
        }
    }

    public long getBalance() {
        return balance;
    }
}
