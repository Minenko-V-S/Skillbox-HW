

import Person.Entity;
import Person.Individual;
import Person.Businessman;



public class Main {
    public static void main(String[] args) {
        Individual individual = new Individual();
        Entity entity = new Entity();
        Businessman entrepreneur = new Businessman();

        System.out.println("Физ. лицо");
        System.out.println("Баланс " + individual.getBalance());
        individual.deposit(500);
        System.out.println("Баланс " + individual.getBalance());
        individual.withdraw(499);
        System.out.println("Баланс " + individual.getBalance());
        individual.withdraw(-1);

        System.out.println("\nЮр. лицо");
        System.out.println("Баланс " + entity.getBalance());
        entity.deposit(1000);
        System.out.println("Баланс " + entity.getBalance());
        entity.withdraw(100);
        System.out.println("Баланс " + entity.getBalance());
        entity.deposit(201);
        System.out.println("Баланс " + entity.getBalance());
        entity.withdraw(1000);
        System.out.println("Баланс " + entity.getBalance());


        System.out.println("\nПредприниматель");
        System.out.println("Баланс " + entrepreneur.getBalance());
        entrepreneur.deposit(-1);
        entrepreneur.deposit(1000);
        System.out.println("Баланс " + entrepreneur.getBalance());
        entrepreneur.deposit(100);
        System.out.println("Баланс " + entrepreneur.getBalance());

    }
}
