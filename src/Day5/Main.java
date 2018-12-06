package Day5;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        // PART 1
        File file = new File("src/Day5/list.txt");
        Scanner sc = new Scanner(file);
        StringBuilder fileContents = new StringBuilder((int) file.length());

        while (sc.hasNextLine()) {
            fileContents.append(sc.nextLine() + System.lineSeparator());
        }

        reducePolymer(fileContents);


        // PART 2

        String str = fileReader("src/Day5/list.txt");

        int min = Integer.MAX_VALUE;
        StringBuilder build;
        for (int i = 0; i < 26; i++) {
            String newStr = str.replaceAll("[" + (char) (i + 'a') + (char) (i + 'A') + "]", "");
            build = new StringBuilder(newStr);
            //System.out.println(build);

            min = Math.min(min, reducePolymer(build));

        }

        System.out.println(min);

    }


    static int reducePolymer(StringBuilder fileContents) {
        boolean removed = false;
        while (!removed) {
            for (int i = 0; i < fileContents.length() - 1; i++) {
                if (Math.abs(fileContents.charAt(i) - fileContents.charAt(i + 1)) == 32) {
                    fileContents.delete(i, i + 2);
                    removed = false;
                    break;
                }
                removed = true;
            }
        }
        //  System.out.print(fileContents.toString());
        return (fileContents.length() - 1);
    }


    static String fileReader(String pathname) throws IOException {

        File file = new File(pathname);
        Scanner sc = new Scanner(file);
        StringBuilder fileContents = new StringBuilder((int) file.length());

        try (sc) {
            while (sc.hasNextLine()) {
                fileContents.append(sc.nextLine() + System.lineSeparator());
            }
            return fileContents.toString();
        }
    }


}
