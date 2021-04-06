//Написать программу, которая будет работать как телефонная книга: если пишем новое имя,
//просит ввести номер телефона и запоминает его, если новый номер телефона — просит ввести
//имя и тоже запоминает. Если вводим существующее имя или номер телефона, программа должна
//выводить всю информацию о контакте. При вводе команды LIST программа должна печатать в
//консоль список всех абонентов в алфавитном порядке с номерами.


import java.util.Scanner;
import java.util.TreeMap;

public class PhoneBook {
    private static TreeMap<String, String> contacts = new TreeMap<>();
    private static final String NAME = "([A-Za-zА-Яа-яЁё]+[\\-\\s]?+[A-Za-zА-Яа-яЁё]){1,}";
    private static final String PHONE_NUMBER = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$\\s";
    private static final String TEST_REGEX = "[7|8]\\d{10}";
    private static String input;

    public static void main(String[] args) {


        for (; ; ) {
            System.out.println("Введите ФИО или номер телефона : ");
            input = new Scanner(System.in).nextLine();

            if (input.matches(PHONE_NUMBER)) {
                contactsPhone();
            } else if (input.matches(NAME)) {
                contactsName();
            } else if (input.matches("LIST")) {
                contacts.forEach((name, phone) -> System.out.println(name + " " + phone));
            } else {
                System.out.println("Данные указаны не верно.");
            }

        }

    }

    private static void contactsName() {
        if (contacts.containsKey(input)) {
            System.out.println("Найден контакт: " + contacts.ceilingEntry(input));
        } else {
            System.out.println("Введите номер телефона для нового контакта: ");
            for (int i = 0; i < 3; i++) {
                System.out.println("Попытка " + (i + 1));
                String newNumber = new Scanner(System.in).nextLine();
                if (newNumber.matches(TEST_REGEX)) {
                    if (newNumber.startsWith("7")) {
                        newNumber = newNumber.replaceAll("^7", "8");
                    }
                    StringBuilder sb = new StringBuilder(newNumber);
                    sb.insert(1, "(");
                    sb.insert(5, ")");
                    sb.insert(9, "-");
                    sb.insert(12, "-");
                    System.out.println(sb.toString());

                    contacts.put(input, newNumber);
                    System.out.println("новый контакт " + input + " успешно добавлен в телефонную книгу.");
                    break;
                } else {
                    System.out.println("!> Некорректный номер телефона.");
                }
            }
        }
    }
    private static void contactsPhone() {
        if (contacts.containsValue(input)) {
            System.out.println("Контакт с таким телефоном есть в телефонной книге.");
        } else {
            System.out.println("Введите имя для нового контакта: ");
            for (int i = 0; i < 3; i++) {
                System.out.println("Попытка " + (i + 1));
                String newName = new Scanner(System.in).nextLine();
                if (newName.matches(NAME)) {
                    contacts.put(newName, input);
                    System.out.println("новый контакт " + newName + " успешно добавлен в телефонную книгу.");
                    break;
                } else {
                    System.out.println("!> Некорректное имя.");
                }
            }
        }
    }
}

