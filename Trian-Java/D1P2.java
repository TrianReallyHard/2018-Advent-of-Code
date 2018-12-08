import java.io.File;
import java.util.Scanner;

class D1P2 {

    public static void main(String[] args) {
        int number = findSecond();
        System.out.println(number);
    }

    public static int findSecond(){
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        int lines = 0;
        int total = 0;
        int[] array = new int[10000];
        array[0] = 0;
        do {
            if(scan.hasNextLine()){
                String line = scan.nextLine();
                total += Integer.parseInt(line);
                lines++;
            }
        } while (lines < 967);
        scan.close();
        return 0;
    }
}