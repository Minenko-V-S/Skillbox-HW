import java.util.Scanner;

public class loder {


    public static void main(String[] args) {
        int size = 7;
        String[] x = new String[size];
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((i + j + 1) == size || i == j) {
                    str.append('X');
                } else {
                    str.append(" ");
                }
            }
            x[i] = str.toString();
            str.delete(0, str.length());
        }

        for (String s : x) {
            System.out.println(s);
        }
    }
}
