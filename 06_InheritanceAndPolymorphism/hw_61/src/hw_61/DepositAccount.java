package hw_61;


import java.time.LocalDate;
public class DepositAccount extends BankAccount {
    private LocalDate dateOfLastDepo;
    private LocalDate currentDate;

    public DepositAccount(LocalDate date, long amount) {
        super(amount);
        dateOfLastDepo = date;
        currentDate = LocalDate.now();
    }

    @Override
    public void deposit(long value) {
        super.deposit(value);
        dateOfLastDepo = LocalDate.now();
    }

    @Override
    public boolean withdraw(long value) {
        if (currentDate.isAfter(dateOfLastDepo.plusMonths(1))) {
            return super.withdraw(value);
        } else {
            System.out.printf("Прошло недостаточно времени с момента последнего депозита\n");
            return false;
        }
    }
}
