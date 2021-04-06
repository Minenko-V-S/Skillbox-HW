//Создать массив с температурами 30-ти пациентов (от 32 до 40 градусов).
//Написать код, рассчитывающий среднюю температуру по больнице и количество здоровых пациентов (с температурой от 36,2 до 36,9).

import java.text.DecimalFormat;
import java.util.Arrays;

public class loder {
     final static int PATIENTS = 30;
     final static double MAX_TEMP = 40.5;
     final static double MIN_TEMP = 32.0;
     final static double MIN_TEMP_HEALTH_PATIENTS = 36.2;
     final static double MAX_TEMP_HEALTH_PATIENTS = 36.9;

    public static void main(String[] args) {



        double[] people = new double[PATIENTS];
        double s = 0;
        for (int i = 0; i < people.length; i++) {
            people[i] = (Math.random() * 5 + 36);
            s = s + people[i];
            System.out.println(i + " Температура пациента - " + people[i]);

        }
        Double[] tempretures = {MIN_TEMP_HEALTH_PATIENTS, MAX_TEMP_HEALTH_PATIENTS};
        DecimalFormat formatter = new DecimalFormat("#0.00°C");
        double d = 37.67;
        System.out.println("Средняя температура по больнице: " + formatter.format(d));
        long numberOfHealthPeople = Arrays.stream(tempretures)
                .filter(t -> t >= MIN_TEMP && t <= MAX_TEMP)
                .count();

        System.out.println("Количиство звдоровых людей: " + numberOfHealthPeople);
    }
}



