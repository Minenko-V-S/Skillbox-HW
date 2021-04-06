import java.util.Scanner;
//Примеры:
//+79261234567
//89261234567
//79261234567
//+7 926 123 45 67
//8(926)123-45-67
//123-45-67
//9261234567
//79261234567
//(495)1234567
//(495) 123 45 67
//89261234567
//8-926-123-45-67
//8 927 1234 234
//8 927 12 12 888
//8 927 12 555 12
//8 927 123 8 123
//+7 909 123-45-67
//+7 (909) 1234567
//7-909-123-45-67
//8 905 1234567


public class Phone {
    public static void main(String[] args){
        System.out.print("укажите номер телефона: ");
        Scanner scanner = new Scanner(System.in);
        String phone = scanner.nextLine();

        System.out.println(phone.replaceAll("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$\\s", ""));
        System.out.println(phone);

    }
}
