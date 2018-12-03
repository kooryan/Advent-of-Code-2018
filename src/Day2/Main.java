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

        for (String each : lines) {

            boolean foundTwo = false,
                    foundThree = false;

            Map<Character, Integer> frequencies = new HashMap<>();

            for (int j = 0; j < each.length(); j++) {

                char ch = each.charAt(j);

                frequencies.merge(ch, 1, (a, b) -> (a + b));

            }

            for (Map.Entry<Character, Integer> map : frequencies.entrySet()) {
                if (!foundTwo && map.getValue() == 2) {
                    occurs2++;
                    foundTwo = true;
                }
                if (!foundThree && map.getValue() == 3) {
                    occurs3++;
                    foundThree = true;
                }

                System.out.println(map);
                System.out.println(each);


            }
        }

        System.out.println(occurs2 * occurs3);


        // PART 2
        for (int i =0; i< lines.length; i++) {
            String comp1 = lines[i];
            for (int j = i+1; j<lines.length; j++) {
                String comp2 = lines[j];
                int distance = 0;
                StringBuilder differingCharacters = new StringBuilder();
                for (int n = 0; n<comp1.length(); n++) {
                    if (comp1.charAt(n) != comp2.charAt(n)) {
                        if (++distance > 1) {
                            differingCharacters.append(comp1.charAt(n));
                        }
                    }
                    if (distance == 1) {
                        differingCharacters.toString();
                    }

                }
            }
        }

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
