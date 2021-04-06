package hw_61;

public class CardAccount extends BankAccount {
    protected int commission = 1;

    @Override
    public boolean withdraw(long value) {
        long sum = value + (long) Math.round(value * commission / 100);
        System.out.printf("Комиссия составляет %d%%\nК списанию %d\n", commission, sum);
        return super.withdraw(sum);
    }
}