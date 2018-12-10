import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.lang.Iterable;
import java.io.File;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;


class D1P2 {

    public static List<Integer> previousValues = new ArrayList<Integer>();
    public static int total = 0;
    
    public static void main(String[] args) {
        int number = findSecond();
        while (number == -1) {
            number = findSecond();
        }
        System.out.println(number);
    }

    public static int findSecond(){
        try {
            File file = new File("input.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                total += Integer.parseInt(line);
                previousValues.add(total);
            }
            int result = 0;
            result = findDuplicate(previousValues);
            if(result != 0) {
                return result;
            }
            scan.close();
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    public static <Integer> int findDuplicate(Iterable<Integer> all) {
        int i = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (Integer each : all){
            if (!set.add(each)){
                return previousValues.get(i);
            }
            i++;
        }
        return 0;
    }
}