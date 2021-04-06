

public class loder {
    public static void main(String[] args) {

        String[] color = {"Фиолетовый", "Синий", "Голубой", "Зелёный", "Жёлтый", "Оранжевый", "Красный"};
        System.out.println("Вперед : ");
        for (int i = 0; i < color.length; i++) {
            System.out.println(color[i]);
        }
        System.out.println();
        System.out.println("Назад: ");
        for (int l = color.length - 1; l >= 0; l--) {
            System.out.println(color[l]);
        }

        //реверс
        System.out.println();
        //String[] colors = {"Фиолетовый", "Синий", "Голубой", "Зелёный", "Жёлтый", "Оранжевый", "Красный"};
       String[] colors = {"Красный", "Оранжевый", "Жёлтый", "Зелёный", "Голубой", "Синий", "Фиолетовый"};
        int size = colors.length;

        for (int k = 0; k < size / 2; k++) {
            String temp = colors[k];
            colors[k] = colors[size - 1 - k];
            colors[size - 1 - k] = temp;
        }

        System.out.println(colors[0]);
        System.out.println(colors[6]);
        }

    }








