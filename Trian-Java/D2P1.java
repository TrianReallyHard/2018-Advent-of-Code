import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.util.Scanner;

class D2P1 {

    public static void main(String[] args) {
        verify();
    }

    public static void verify(){
        int doubles = 0;
        try {
            File file = new File("D2Input.txt");
            Scanner scan = new Scanner(file);
            Pattern regex = Pattern.compile("(.)\1{2,}");
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                Matcher matcher = regex.matcher(line);
                if(matcher.find()){
                    System.out.println(matcher.group());
                }
            }
            scan.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}