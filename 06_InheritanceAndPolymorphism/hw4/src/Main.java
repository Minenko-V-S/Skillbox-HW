import company.Company;
import company.Manager;
import company.Operator;
import company.TopManager;
import hw4.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;



public class Main {

    public static void main(String[] args) {

        Company company = new Company(10000000);

        System.out.println("\n--- Проверка нанять/уволить ---");
        Employee fake = new Operator("НЕ НАСТОЯЩИЕ", 100000000, company);
        company.hire(fake);
        System.out.println("Нанять. Не настоящее содержании компании: " + (company.getEmployees().contains(fake)));
        company.fire(fake);
        System.out.println("Уволить. Не настоящее содержании компании: " + (company.getEmployees().contains(fake)));


        System.out.println("\n--- Найм 270 сотрудников ---");
        for (int i = 0; i < 10; i++) {
            company.hire(new TopManager("TopManager " + i, i * 1000, company));
        }

        for (int i = 0; i < 80; i++) {
            company.hire(new Manager("Manager " + i, i * 10, company));
        }

        Collection<Employee> operators = new ArrayList<>();
        for (int i = 0; i < 180; i++) {
            operators.add(new Operator("Operator " + i, i * 100, company));
        }
        company.hireAll(operators);

        testWorking(company);

        /// FIRE!!!
        System.out.println("\n--- Уволить 50% (135) ---");
        company.fireAll(company.getLowestSalaryStaff(135));
        testWorking(company);

    }

    private static void testWorking(Company company) {
        System.out.println("Количество сотрудников: " + company.getEmployees().size());
        System.out.println("\n--- Компания заработала ---");
        company.closeNextMonth();
        System.out.println("Доход компании: " + company.getIncome());
        printStaff(company, 10, 30);
    }

    private static void printStaff(Company company, int top, int low) {
        int amount = company.getEmployees().size();
        if (top + low > amount) {
            throw new IllegalArgumentException();
        }

        System.out.println("\n--- Зарплаты до и после увальнения людей: ");

        int i = 1;

        for (Employee e:
                company.getTopSalaryStaff(top)) {
            System.out.println(i + ".\t\t" + printMonthSalary(e));
            i++;
        }

        System.out.println("\t...");

        i = amount - low + 1;
        List<Employee> lowestSalaryStaff = company.getLowestSalaryStaff(low);
        Collections.reverse(lowestSalaryStaff);
        for (Employee e:
                lowestSalaryStaff) {
            System.out.println(i + ".\t\t" + printMonthSalary(e));
            i++;
        }
    }

    private static String printMonthSalary(Employee e) {
        if(e.getBonusValue() > 0) {
            return String.format("%-10s: %10d (Повышение зарплаты: %d, Бонус: %d)", e.getName(), e.gainMoney(), e.getMonthSalary(), e.getBonusValue());
        } else {
            return String.format("%-10s: %10d", e.getName(), e.getMonthSalary());
        }
    }
}