package Day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException{


        Scanner scanner = new Scanner(new File("src/Day1/list.txt"));
        ArrayList<Integer> list = new ArrayList();
        while(scanner.hasNextInt()){
             list.add(scanner.nextInt());
        }

        //PART 1

        System.out.println(list);

        int sum = 0;
        for (int i =0; i<list.size(); i++) {
            sum += list.get(i);
        }

        System.out.println(sum);


        // PART 2

        Set<Integer> log = new HashSet<>();

        boolean dupNotFound = true;
        int frequency = 0;

        while (dupNotFound) {
            for (int i = 0; i < list.size(); i++) {

                log.add(frequency);
                frequency += list.get(i);

                if (log.contains(frequency)) {
                    System.out.println(frequency);
                    dupNotFound = false;
                    break;
                }

                log.add(frequency);

            }
        }

    }

}
