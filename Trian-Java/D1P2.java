import java.io.File;
import java.util.Scanner;

class D1P2 {

    public static void main(String[] args) {
        int number = findSecond();
        System.out.println(number);
    }

    public static int findSecond(){
        try {
            File file = new File("input.txt");
            Scanner scan = new Scanner(file);
            int lines = 0;
            int total = 0;
            int[] array = new int[10000];
            array[0] = 0;
            do {
                if(scan.hasNextLine()){
                    String line = scan.nextLine();
                    String operand = line.replaceAll("[0-9]*$", "");
                    int value = Integer.parseInt(line.replaceAll("[-+*/]", ""));
                    if(operand.equals("+")){
                        total += value;
                        array[lines] = total;
                    }
                    if(operand.equals("-")){
                        total -= value;
                        array[lines] = total;
                    }
                    for(int num : array) {
                        if (num == total) {
                            return total;
                        }
                    }
                    lines++;
                } else {
                    scan.reset();
                    scan = new Scanner("input.txt");
                }
            } while (lines < 10);
            scan.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -100;
    }
}