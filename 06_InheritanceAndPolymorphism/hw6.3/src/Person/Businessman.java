package Person;
//ИП
public class Businessman extends Client{
    private final float ONE_PERCENT = 1.0f;
    private final float LOWER_PERCENT = 0.5f;
    private final long COMISSION_THRESHOLD = 1000;


    @Override
    public boolean deposit(long sum) {
        if (!isSumValid(sum)){
            return printInvalidSum(sum);
        }

        float commission;
        if (sum < COMISSION_THRESHOLD) {
            commission = ONE_PERCENT;
        } else {
            commission = LOWER_PERCENT;
        }

        long totalSum = sum - (long) Math.round(sum * commission / 100);
        System.out.printf("Пополнение %d. Комиссия %.1f%%. Итого к пополнению: %d\n", sum, commission, totalSum);
        increaseAccount(totalSum);
        return true;
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


