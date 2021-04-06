package company;
import hw4.Employee;

public class TopManager implements Employee {
    private  String ID;
    private int monthProceeds = 0;
    private int salary;
    private Company company;
    private int bonusValue = 0;

    public TopManager(String ID,int salary, Company company) {
        this.ID = ID;
        this.salary = salary;
        this.company = company;
    }

    @Override
    public int getMonthSalary() {
        return salary + bonusValue;
    }

    @Override
    public int gainMoney() {
        monthProceeds = (int)Math.round(Math.random() * 400000);
        return monthProceeds;
    }

    @Override
    public int countBonus() {
        bonusValue = company.isCompanyGoalAchieved() ? (int)Math.round(salary * 1.5) : 0;
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
