package Person;
// физ лицо
public class Individual extends Client{
    @Override
    public boolean deposit(long sum) {
        if (!isSumValid(sum)) {
            return printInvalidSum(sum);
        } else {
            System.out.println("Пополнение " + sum);
            increaseAccount(sum);
            return true;
        }
    }

    @Override
    public boolean withdraw(long amount) {
        if (!isSumValid(amount)) {
            return printInvalidSum(amount);
        }

        if (getBalance() >= amount) {
            System.out.println("Снятие " + amount);
            reduceAccount(amount);
            return true;
        } else {
            System.out.println("Недостаточно денег");
            return false;
        }
    }
    }
