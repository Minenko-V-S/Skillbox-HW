package src;//Написать программу, которая будет распечатывать Ваш возраст и соответствующий ему день рождения и день недели до
// текущего момента времени. Формат:
// 0 - 13.02.1989 - Mon
// 1 - 13.02.1990 - Tue




import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;



public class birthDay {
public static final DateTimeFormatter dtf =  DateTimeFormatter.ofPattern("dd.MM.yyyy - EEE");

    public static void main(String[] args) {

        LocalDate dr = LocalDate.of(1990, Month.MARCH, 12);// жень рождения
        LocalDate drreal = dr;
        LocalDate today = LocalDate.now();// сегоднешняя дата
        Period period = Period.between(dr, LocalDate.now());

        for (int i = 0; drreal.isBefore(today); i++){
            System.out.println(i+ " " + drreal.format(dtf));
            drreal = drreal.plusYears(1);


        }
           System.out.println("Мне " + period.getYears() + " годиков:))");
    }
   }




