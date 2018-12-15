import java.util.ArrayList;
import java.util.Set;
import java.awt.Rectangle;
import java.util.HashSet;
import java.io.File;
import java.util.Scanner;

class D3P1 {

    public static ArrayList<Integer[]> claims = new ArrayList<Integer[]>();
    public static Set<Rectangle> rectSet = new HashSet<Rectangle>();

    public static void main(String[] args) {
        processClaims();
        findOverlap(claims);
    }

    public static void processClaims(){
        try {
            File file = new File("testInput.txt");
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

    public static void findOverlap(ArrayList<Integer[]> list) {
        boolean add = true;
        Long timeStart = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            int left = list.get(i)[1];
            int top = list.get(i)[2];
            int width = list.get(i)[3];
            int height = list.get(i)[4];
            Rectangle rect1 = new Rectangle(left, top, width, height);
            for (int j = i + 1; j < list.size(); j++) {
                int left2 = list.get(j)[1];
                int top2 = list.get(j)[2];
                int width2 = list.get(j)[3];
                int height2 = list.get(j)[4];
                Rectangle rect2 = new Rectangle(left2, top2, width2, height2);
                if(!rect1.intersection(rect2).isEmpty()) {
                    Rectangle zone = rect1.intersection(rect2);
                    if(rectSet.contains(zone)) {
                        add = false;
                    }
                    if(add) {
                        rectSet.add(zone);
                    }
                }
            }
        }
        Long timeEnd = System.currentTimeMillis();
        Long timeTaken = timeEnd - timeStart;
        System.out.println(rectSet.size());
        int result = 0;
        for (Rectangle rect : rectSet) {
            result += (rect.width * rect.height);
        }
        System.out.println(result);
    }
}