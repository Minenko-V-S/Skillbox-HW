//Написать программу, в которой будет храниться перечень e-mail-ов.
//E-mail’ы  можно добавлять через консоль командой ADD и печатать весь список командой LIST.
// * Проверять корректность вводимых e-mail’ов и в случае необходимости печатать сообщение об ошибке.


import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static Pattern pattern = Pattern.compile("^((\\w|[-+])+(\\.[w-]+)*@[\\w-]+((\\.[\\d\\p{Alpha}]+)*(\\.\\p{Alpha}{2,})*)*)$");
    private static Matcher matcher;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashSet<String> emailList = new HashSet<>();

        for (; ; ) {
            System.out.println("Введите команду: ");
            String[] in = scan.nextLine().trim().split("\\s+", 2);

            String inputCommand = in[0].toUpperCase();
            String inputArgument = in.length > 1 ? in[1] : "";

            switch (inputCommand) {
                case "ADD":
                    if (pattern.matcher(inputArgument).matches()) {
                        emailList.add(inputArgument);
                        System.out.println("Запись добавлена");
                    } else {
                        System.out.println("Электронный адрес введен некорректно");
                    }
                    break;
                case "LIST":
                    if (emailList.size() > 0) {
                        for (String email : emailList) {
                            System.out.println(email);
                        }
                    } else {
                        System.out.println("Список эл. адресов пуст");
                    }
                    break;
                case "EXIT":
                    scan.close();
                    return;
                default:
                    continue;
            }
        }
    }
}
