
public class Main {

    public static void main(String[] args) {
        String alphabet = "ABCDEFGHIKLMNOPQRSTVXYZabcdefghiklmnopqrstvxyz";
        System.out.println(alphabet.length());
        System.out.println(alphabet.substring(0, 46));

        for (int i = 65; i < 91; i++) {
            System.out.println(i + ". " + (char) i);
        }
        System.out.println();
        for (int i = 97; i < 123; i++) {
            System.out.println(i + ". " + (char) i);
        }





    }
}


