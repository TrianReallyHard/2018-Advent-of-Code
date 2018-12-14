import java.io.*;
import java.util.*;
import java.awt.*;
import java.lang.*;

class D3P1 {

    public static ArrayList<Integer[]> claims = new ArrayList<Integer[]>();
    public static Set<Rectangle> solution = new HashSet<Rectangle>();

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

    public static void findOverlap(ArrayList<Integer[]> list) {
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
                if(rect1.intersects(rect2)) {
                    Rectangle zone = rect1.union(rect2);
                    zone.setLocation(0, 0);
                    if(!solution.contains(zone)){
                        solution.add(zone);
                    } else {
                        continue;
                    }
                }
            }
        }
        Long timeEnd = System.currentTimeMillis();
        Long timeTaken = timeEnd - timeStart;
    }
}