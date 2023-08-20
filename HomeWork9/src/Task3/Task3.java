package Task3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Scanner;


public class Task3 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Введите путь к существующей директории: ");
//        String source = scanner.next();
//        File directorySource = new File(source);
//        if ((!directorySource.isDirectory()) || (!directorySource.exists())) {
//            System.out.println("Ошибка. Не является папкой или не папка не существует");
//        } else {
//            System.out.println("Введите путь, куда вы хотите скопировать папку: ");
//            String destination = scanner.next();
//            File directoryDestination = new File(destination);
//            try {
//                directoryDestination.mkdirs();
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        }

        File file = new File("C:\\File");
        File file1 = new File("C:\\copy");


        CopyFolder(file,file1);

    }


    private static void CopyFolder(File sourceFolder, File destinationFolder) {
        if (!destinationFolder.exists()) {
            destinationFolder.mkdir();
        }
        File[] files = sourceFolder.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    CopyFolder(f, new File(destinationFolder.getAbsolutePath(), f.getName()));
                } else {
                    try {
                        Files.copy(f.toPath(), (new File(destinationFolder, f.getName()).toPath()), StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
}
