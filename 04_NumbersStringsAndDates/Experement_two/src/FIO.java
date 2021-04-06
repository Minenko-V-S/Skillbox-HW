//Аль Даббаг Светлана Анатольевна
// Аль-Хаулани Диляра Мохаммедовна
// Адитья Пратап Сингх Чаухан
//Зубайдуйллаев Алмасхон Рахматиллаевич
//Абрам Семенович Бетман
//Аман-Гельды Молдагазыевич
//Михаил Евграфович Салтыков-Щедрин
//Николай Васильевич Гоголь-Яновский
//Ольга Семенова-Тянь-Шанская
//Антуан де Сент-Экзюпери
//Леопольд фон Захер-Мазох
//Салим-оглы Мамед
//Салим-кызы Лейла
//Абу Зейд Абдуррахман ибн Мухаммад аль-Хадрами



import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FIO {
    public static void main(String[] args)
    {

        System.out.print("Укажите Ф.И.О.: ");
        Scanner scanner = new Scanner(System.in);
        String fullName = scanner.nextLine();
        Pattern p = Pattern.compile("([A-Za-zА-Яа-яЁё]+[\\-\\s]?+[A-Za-zА-Яа-яЁё]){1,}");

        Matcher m = p.matcher(fullName);
        if (m.find( )) {
            System.out.println("Найдено значение: " + m.group(0));
        }else {
            System.out.println("НЕ СОВПАДАЕТ");
        }
    }
}
