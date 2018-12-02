import java.io.BufferedReader;
import java.io.FileReader;

class D1P1 {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
            int lines = 0;
            int total = 0;
            do {
                String line = reader.readLine();
                String operand = line.replaceAll("[0-9]*$", "");
                String value = line.replaceAll("[-+*/]", "");
                if(operand.equals("+")){
                    total += Integer.parseInt(value);
                }
                if(operand.equals("-")){
                    total -= Integer.parseInt(value);
                }
                lines++;
            } while (lines < 967);
            System.out.println(total);
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}