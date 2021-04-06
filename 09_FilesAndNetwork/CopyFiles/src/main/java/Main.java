import java.io.*;

import static org.apache.commons.io.FileUtils.copyDirectory;


public class Main {

    public static void main(String[] args) throws IOException{
        File source = new File("C:\\Users\\Anarh\\Desktop\\IT\\Cat");
        File dest = new File("C:\\Users\\Anarh\\Desktop\\Cat");
       copyFileUsingStream(source, dest);
   //       copyFileUsingApacheCommonsIO(source, dest);


    }




    // копируем файл с помощью потоков
    private static void copyFileUsingStream(File source, File dest) throws IOException {


        if (source.isDirectory()) {
            if (!dest.exists()) {
                dest.mkdir();
            }

            String[] children = source.list();
            for (int i=0; i<children.length; i++) {
                copyDirectory(new File(source, children[i]),
                        new File(dest, children[i]));

                            }
        } else {

            InputStream in = new FileInputStream(source);
            OutputStream out = new FileOutputStream(dest);


            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
        }
    }


//    // копируем файл с помощью Apache Commons io  ++
//    public static void copyFileUsingApacheCommonsIO(File source, File dest) throws IOException {
//        FileUtils.copyDirectoryToDirectory(source, dest);
//    }
}
