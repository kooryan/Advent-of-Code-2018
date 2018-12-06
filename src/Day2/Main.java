package Day2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        //PART 1

        String line = fileReader("src/Day2/list.txt");
        String[] lines = line.split(System.getProperty("line.separator"));

        Scanner scanner = new Scanner(new File("src/Day2/list.txt"));
        ArrayList<String> list = new ArrayList();
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }

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

//                System.out.println(map);
//                System.out.println(each);


            }
        }

        System.out.println(occurs2 * occurs3);


        // PART 2

        List<String> lin = Files.readAllLines(new File("src/Day2/list.txt").toPath());

        for (int i = 0; i < lin.size(); i++) {
            String firstLine = lin.get(i);
            for (int j = i; j < lin.size(); j++) {
                int distance = 0;
                String secondLine = lin.get(j);
                StringBuilder commonLetters = new StringBuilder();
                for (int k = 0; k < firstLine.length(); k++) {
                    if (firstLine.charAt(k) == secondLine.charAt(k)) {
                        commonLetters.append(secondLine.charAt(k));

                    } else if (distance++ > 1) {
                        break;
                    }
                }
                if (distance == 1) {
                    System.out.println(commonLetters.toString());
                }
            }
        }

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
