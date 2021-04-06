package company;

import hw4.Employee;

public class Manager implements Employee {

    private final static double BONUS_PERCENT = 0.05;
    private int monthProceeds = 0;
    private  String ID;
    private int salary;
    private Company company;
    public int bonusValue;

    public Manager(String ID,int salary, Company company) {
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
        bonusValue = (int)Math.round(monthProceeds * BONUS_PERCENT);
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
