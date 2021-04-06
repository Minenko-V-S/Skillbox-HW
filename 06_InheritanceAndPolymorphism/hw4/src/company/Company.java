package company;

import hw4.Employee;

import java.util.*;

public class Company  {

    private final int COMPANY_GOAL;
    private int gainedMoney = 0;
    private List<Employee> employees = new LinkedList<>();

    private TreeSet<Employee> rangedEmployees = new TreeSet<>(Comparator.comparingInt(Employee::getMonthSalary).reversed().thenComparing(Employee::getName));
    private int monthIncome = 0;

    public Company(int companyGoal) {
        COMPANY_GOAL = companyGoal;
    }

    public void hire(Employee employee) {
        this.employees.add(employee);
    }

    public void hireAll(Collection<Employee> employees) {
        this.employees.addAll(employees);
    }

    public void fire(Employee employee) {
        this.employees.remove(employee);
    }

    public void fireAll() {
        this.employees.clear();
    }

    public void fireAll(Collection<Employee> employees) {
        this.employees.removeAll(employees);
    }

    public void closeNextMonth() {

        for (Employee e : employees) gainedMoney(e.gainMoney());
        monthIncome = gainedMoney;

        for (Employee employee : employees) {
            employee.countBonus();
        }

        rangedEmployees.clear();

        rangedEmployees.addAll(employees);
    }

    public int gainedMoney(int gainMoney) {
        return gainMoney;
    }

    public Integer getIncome() {
        return monthIncome;
    }

    public boolean isCompanyGoalAchieved() {
        return monthIncome >= COMPANY_GOAL;
    }

    public Collection<Employee> getEmployees() { return employees; }

    public ArrayList<Employee> getTopSalaryStaff(int count) {
        return getStaffBySalary(rangedEmployees.iterator(), count);
    }

    public ArrayList<Employee> getLowestSalaryStaff(int count) {
        return getStaffBySalary(rangedEmployees.descendingIterator(), count);
    }

    private ArrayList<Employee> getStaffBySalary(Iterator<Employee> iterator, int count) {
        if (count > rangedEmployees.size()) {
            return new ArrayList<>(rangedEmployees);
        }

        ArrayList<Employee> result = new ArrayList<>(5);
        for (int i = 0; i < count && iterator.hasNext(); i++) {
            result.add(iterator.next());
        }

        return result;
    }
}
