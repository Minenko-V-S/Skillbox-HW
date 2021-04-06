import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Loader
{

    public static Queue<String> queue = new ConcurrentLinkedQueue<>();
    public static void main(String[] args) {
        int coreCount = Runtime.getRuntime().availableProcessors() * 2;
        long startTime = System.currentTimeMillis();
        Path targetPath = Paths.get("res\\num2_multi.txt");
        ExecutorService executorService = Executors.newFixedThreadPool(coreCount);
        try {
            executorService.submit(() -> {
                try {
                    generateNumbers();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String str;
                while (queue.size() > 0) {
                    try {
                        if ((str = queue.poll()) != null) {
                            Files.write(targetPath, str.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            executorService.shutdown();
            executorService.awaitTermination(30, TimeUnit.SECONDS);
            System.out.println((System.currentTimeMillis() - startTime) + " ms\n");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void generateNumbers() throws IOException {
        for (int i = 0; i < 10; i++) {

            char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};

            for (int regionCode = 1; regionCode < 100; regionCode++) {
                StringBuilder carNumber = new StringBuilder();
                for (int number = 1; number < 1000; number++) {
                    for (char firstLetter : letters) {
                        for (char secondLetter : letters) {
                            for (char thirdLetter : letters) {
                                carNumber.append(firstLetter);
                                carNumber.append(padNumber(number, 3));
                                carNumber.append(secondLetter);
                                carNumber.append(thirdLetter);
                                carNumber.append(padNumber(regionCode, 2));
                                carNumber.append('\n');
                            }
                        }

                    }

                }
                queue.add(carNumber.toString());
            }
        }
    }

    private static String padNumber(int number, int numberLength)
    {
        StringBuilder numberStr = new StringBuilder(Integer.toString(number));
        int padSize = numberLength - numberStr.length();
        for(int i = 0; i < padSize; i++) {
            numberStr.insert(0, "0");
        }
        return numberStr.toString();
    }
}
