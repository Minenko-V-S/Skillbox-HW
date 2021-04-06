package Person;

public abstract class Client {
    private long balance;

    public long getBalance() {
        return balance;
    }

    public abstract boolean deposit(long sum);
    public abstract boolean withdraw(long amount);

    protected void increaseAccount(long sum)
    {
        balance += sum;
    }
    protected void reduceAccount(long sum) {
        balance -= sum;
    }

    protected boolean isSumValid(long sum) {
        return sum > 0;
    }

    protected boolean printInvalidSum(long sum) {
        System.out.println("Некорректные входные данные '" + sum + "'");
        return false;
    }

}
