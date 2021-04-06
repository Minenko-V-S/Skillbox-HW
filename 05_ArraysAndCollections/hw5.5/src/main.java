import java.util.*;


public class main {
    private static List<String> numbers = new ArrayList<>();
    private final static String[] NUMBER_LETTERS = new String[]{"А", "В","Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
    private static int regionNumRange = 200;

    public static void main(String[] args) {
        System.out.println("Формирование списка номеров..");
        numbers = numGen();
        System.out.println("Список номеров сформирован." + numbers.size());
        System.out.println(numbers.size());

        while (true) {
            System.out.println("Введите номер автомобиля для поиска в системе: ");
            String numberSearch = new Scanner(System.in).nextLine();

            searchBeautifulNumber(numberSearch);
            binarySearch(numberSearch);

            TreeSet<String> numbersTreeSet = new TreeSet<>(numbers);
            System.out.println("=======TreeSet======");

            if (numbersTreeSet.contains(numberSearch)) {
                System.out.println("Номер найден. Время поиска: " + (System.nanoTime()) + "нс");
            } else {
                System.out.println("Номер не найден. Время поиска: " + (System.nanoTime()) + "нс");
            }

            HashSet<String> numbersHashSet = new HashSet<>(numbers);
            System.out.println("=======HashSet======");

            if (numbersHashSet.contains(numberSearch)) {
                System.out.println("Номер найден. Время поиска: " + (System.nanoTime()) + "нс");
            } else {
                System.out.println("Номер не найден. Время поиска: " + (System.nanoTime()) + "нс");
            }
        }
    }
    //создание и поиск красивых номеров
    private static List<String> numGen() {

        List<String> result = new ArrayList<>();

        for (String x : NUMBER_LETTERS) {
            for (String y : NUMBER_LETTERS) {
                for (String z : NUMBER_LETTERS) {
                    for (int j = 1; j < 1000; j++) {
                        if (regionNumRange >= 0) {
                            result.add(String.format("%s %03d %s%s %03d", x, j, y, z, regionNumRange));
                        } else {
                            result.add(String.format("%s %03d %s%s %03d", x, j, y, z, regionNumRange));
                        }
                    }
                }
            }
            regionNumRange++;
        }
        return result;
    }


    private static void searchBeautifulNumber(String myNumber) {
        System.out.println("=======Поиск перебором======");

            for (String number : numbers) {
            if (number.equals(myNumber)) {
                System.out.println("Номер найден. Время поиска: " + (System.nanoTime()) + "нс");

            } else {
                System.out.println("Номер не найден. Время поиска: " + (System.nanoTime()) + "нс");
                break;
            }
        }
    }
    private static void binarySearch(String myNumber) {
        System.out.println("=======Двоичный поиск======");
        Collections.sort(numbers);


        long result = Collections.binarySearch(numbers, myNumber);
        if (result != -1) {
            System.out.println("Номер найден. Время поиска: " + (System.nanoTime()) + "нс");
        } else {
            System.out.println("Номер не найден. Время поиска: " + (System.nanoTime()) + "нс");
        }
    }
}





