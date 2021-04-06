package company;
import hw4.Employee;

public class Operator implements Employee {

    private  String ID;
    private int salary;
    private Company company;
    private int bonusValue = 0;

    public Operator(String ID,int salary, Company company) {
        this.ID = ID;
        this.salary = salary;
        this.company = company;
    }

    @Override
    public int getMonthSalary() {
        return salary;
    }

    @Override
    public int gainMoney() {
        return salary;
    }

    @Override
    public int countBonus() {
       return 0;
    }

    @Override
    public String getName() {
        return ID;
    }

    @Override
    public int getBonusValue() {
        return bonusValue;
    }

}
