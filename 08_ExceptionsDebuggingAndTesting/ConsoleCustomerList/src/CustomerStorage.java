import java.util.HashMap;
import ConsoleCustomerList.exceptions.EmptyDataException;
import ConsoleCustomerList.exceptions.EmptyListException;
import ConsoleCustomerList.exceptions.NotFindCustomerException;

public class CustomerStorage {
    private HashMap<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        if (data != null && !data.isEmpty()) {
            try {
                String[] components = data.split("\\s+");
                String name = components[0] + " " + components[1];
                storage.put(name, new Customer(name, components[3], components[2]));
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.err.println("Ошибка формата ввода. Образец для ввода: \n" +
                        "add Василий Петров vasily.petrov@gmail.com +79215637722");
            }
        } else {
            throw new EmptyDataException();
        }
    }

        public void listCustomers ()
        {
            if (storage.values().size() != 0) {
                storage.values().forEach(System.out::println);
            } else {
                throw new EmptyListException();
            }
        }

    public void removeCustomer(String name) {
        if (name != null && !name.isEmpty()) {
            Customer tmpCustomer = new Customer(name, null, null);
            if (storage.containsValue(tmpCustomer)) {
                storage.remove(name);
            } else {
                throw new NotFindCustomerException();
            }
        } else {
            throw new EmptyDataException();
        }
    }

        public int getCount ()
        {
            return storage.size();
        }
    }
