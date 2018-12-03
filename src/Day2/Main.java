package Day2;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        //PART 1

        String line = fileReader("src/Day2/list.txt");
        String[] lines = line.split(System.getProperty("line.separator"));

        int occurs2 = 0;
        int occurs3 = 0;

        for (int i=0; i<lines.length;i++) {

            String newLine = lines[i];

            for (int j = 0; j < newLine.length(); j++) {


                Map<Character,Integer> frequencies = new HashMap<>();

                for (char ch : newLine.toCharArray()) {
                    Map<String, Integer> frequency = new HashMap<>();
                    frequencies.put(ch, frequencies.getOrDefault(ch, 0) + 1);
                    if () {

                    }
                    System.out.println(frequencies);

                }

            }
        }

        System.out.println(occurs2 * occurs3);


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
