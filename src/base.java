import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class base {
    public static void main(String[] args) {

    }


    static String fileReader(String pathname) throws IOException {

        File file = new File(pathname);
        Scanner sc = new Scanner(file);
        StringBuilder fileContents = new StringBuilder((int) file.length());

        try (sc) {
            while(sc.hasNextLine()) {
                fileContents.append(sc.nextLine() + System.lineSeparator());
            }
            return fileContents.toString();
        }
    }
}
