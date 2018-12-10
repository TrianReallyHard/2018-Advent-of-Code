import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Point;

class D3P1 {

    public static int fHeight = 1000;
    public static int fWidth = 1000;
    public static List<Integer[]> claims = new ArrayList<Integer[]>();
    public static List<Integer> solution = new ArrayList<Integer>();

    public static void main(String[] args) {
        processClaims();
        findOverlap(claims);
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

    public static void findOverlap(List<Integer[]> list) {
        for (int i = 0; i < list.size(); i++) {
            int id1 = list.get(i)[0];
            int left = list.get(i)[1];
            int top = list.get(i)[2];
            int width = list.get(i)[3];
            int height = list.get(i)[4];
            int xadd = left + width;
            int yadd = top + height;
            Point pl1 = new Point();
            pl1.setX(left);
            pl1.setY(top);
            Point pr1 = new Point();
            pr1.setX(xadd);
            pr1.setY(yadd);
            for (int j = i + 1; j < list.size(); j++) {
                int id2 = list.get(j)[0];
                int left2 = list.get(j)[1];
                int top2 = list.get(j)[2];
                int width2 = list.get(j)[3];
                int height2 = list.get(j)[4];
                int xadd2 = left2 + width2;
                int yadd2 = top2 + height2;
                Point pl2 = new Point();
                pl2.setX(left2);
                pl2.setY(top2);
                Point pr2 = new Point();
                pr2.setX(xadd2);
                pr2.setY(yadd2);
                if(pl1.getX() > pr2.getX() || pl2.getX() > pr1.getX()) { 
                    continue;
                }
                solution.add(id1);
                solution.add(id2);
            }
        }
        String result = "";
        for (int id : solution) {
            result += id;
            result += ", ";
        }
        System.out.println(result);
    }
}