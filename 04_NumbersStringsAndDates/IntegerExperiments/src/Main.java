import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
//4.13 Homework 4.2
        System.out.println("max Double = " + Double.MAX_VALUE);
        System.out.println("min Double = " + Double.MIN_VALUE*-1);
        System.out.println();
        System.out.println("max float = " + Float.MAX_VALUE);
        System.out.println("min float = " + Float.MIN_VALUE*-1);
        System.out.println();
        System.out.println("max byte = " + Byte.MAX_VALUE);
        System.out.println("min byte = " + Byte.MIN_VALUE);
        System.out.println();
        System.out.println("max short = " + Short.MAX_VALUE);
        System.out.println("min short = " + Short.MIN_VALUE);
        System.out.println();
        System.out.println("max long = " + Long.MAX_VALUE);
        System.out.println("min long = " + Long.MIN_VALUE);
        System.out.println();
        System.out.println("max Integer = " + Integer.MAX_VALUE);
        System.out.println("min Integer = " + Integer.MIN_VALUE);

        //4.6 Домашняя работа 4.1
        System.out.println();
        Container container = new Container();
        container.count += 7843;
        System.out.println(container.count);

        System.out.println(sumDigits(556564));

    }

    public static Integer sumDigits(Integer number) {
        String a = String.valueOf(number);
        int Length = a.length();
        System.out.println("Длинна строки  = " + Length);
        int sum = 0;

        for (int i = 0; i < a.length(); i++) {
            sum += Character.getNumericValue(a.charAt(i));
        }

        return sum;

    }
}
