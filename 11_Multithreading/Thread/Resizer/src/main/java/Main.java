import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

public class Main {
    private static int newWidth = 300;

    public static void main(String[] args) {

        String srcFolder = "data/src"; //Путь к папке с изображениями.
        String dstFolder = "data/dst"; //Путь к папке с миниатюрами изображений.

        File srcDir = new File(srcFolder);
        File[] files = srcDir.listFiles();

        int countOfCores = Runtime.getRuntime().availableProcessors();
        System.out.println("Процессоров в системе:  " + countOfCores);

        ExecutorService service = Executors.newFixedThreadPool(countOfCores);
        for (int i = 0; i < files.length; i++) {
            service.submit(new ImageResizer(files[i], newWidth, dstFolder));
        }
        service.shutdown();
    }
}