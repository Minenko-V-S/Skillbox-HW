import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int box = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сколько ящиков нужно доставить?");
        box = scanner.nextInt();

        Cargo cargo = new Cargo(box);
        System.out.println("Доставить коробки("+ cargo.getBox() +") тебе понадобится: \n" + "Truck: " + cargo.getTruck()+ "\nContainer: " + cargo.getContainer());
        System.out.println("===================================");
        cargo.result();
    }
    }

    class Cargo {
        private int truck;
        private int box;
        private int container;

        public Cargo(int box) {
            this.box = box;
            if (box != 0) {
                container = box % 27 == 0 ? box / 27 : box / 27 + 1;
            }
            if (container != 0) {
                truck = container % 12 == 0 ? container / 12 : container / 12 + 1;
            }
        }

        public int getBox() {
            return box;
        }

        public int getContainer() {
            return container;
        }

        public int getTruck() {
            return truck;
        }

        public void result() {
            int b = 1;
            int c = 1;
            for (int i = 0; i <= truck; i++) {
                System.out.println("Номер грузовика: " + i);
                int j = 0;
                while (j < 12 && c <= container) {
                    System.out.println("Номер контейнира: " + c);
                    int k = 0;
                    while (k < 27 && b <= box) {
                        System.out.println("Номер коробки: " + b);
                        k++;
                        b++;
                    }
                    j++;
                    c++;
                    System.out.println();
                }
            }
        }
    }


