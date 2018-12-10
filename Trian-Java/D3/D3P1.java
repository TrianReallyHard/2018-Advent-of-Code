import java.io.File;
import java.util.Scanner;

class D3P1 {

    public static int height = 1000;
    public static int width = 1000;

    public static void main(String[] args) {
        findConflicts();
    }

    public static void findConflicts(){
        try {
            File file = new File("D3Input.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String request = scan.nextLine();
                int id = request.substring(0, request.indexOf(' '));
                System.out.println(id);
            }
            scan.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}