import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class D3P1 {

    public static int height = 1000;
    public static int width = 1000;
    public static List<Integer[]> claims = new ArrayList<Integer[]>();

    public static void main(String[] args) {
        processClaims();
    }

    public static void processClaims(){
        try {
            File file = new File("D3Input.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String request = scan.nextLine();
                int id = Integer.parseInt(request.substring(1, request.indexOf(' ')));
                int leftEdgeDistance = Integer.parseInt(request.substring((request.indexOf('@') + 2), request.indexOf(',')));
                int topEdgeDistance = Integer.parseInt((request.substring((request.indexOf(',') + 1), request.indexOf(':'))));
                int claimWidth = Integer.parseInt((request.substring((request.indexOf(':') + 2), request.indexOf('x'))));
                int claimHeight = Integer.parseInt((request.substring((request.indexOf('x') + 1), request.length())));
                populateClaims(id, leftEdgeDistance, topEdgeDistance, claimWidth, claimHeight);
            }
            scan.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void populateClaims(int id, int left, int top, int width, int height) {
        Integer[] claim = {id, left, top, width, height};
        claims.add(claim);
    }
}