import java.io.File;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class D2P2 {

    public static List<Map<Character, Integer>> charMapList = new ArrayList<Map<Character, Integer>>();

    public static void main(String[] args) {
        verify();
        findCodes(charMapList);
    }

    public static void verify(){
        int length = 0;
        Map<Character, Integer> charCount = new HashMap<Character, Integer>(Math.min(length, 26));
        String line;
        try {
            File file = new File("D2Input.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                line = scan.nextLine();
                length = line.length();
                charCount = new HashMap<Character, Integer>(Math.min(length, 26));
                for (int i = 0; i < length; ++i) {
                    char charFound = line.charAt(i);
                    if (!charCount.containsKey(charFound)){
                        charCount.put(charFound, 1);
                    } else {
                        charCount.put(charFound, charCount.get(charFound) + 1);
                    }
                }
                charMapList.add(charCount);
            }
            scan.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void findCodes(List<Map<Character, Integer>> list) {
        System.out.println(list.size());
        Stack<Integer> badMaps = new Stack<Integer>();
        Map<Character, Integer> first = list.get(0);
        for (Map<Character, Integer> map : list) {
            if(map.size() == first.size()) {
                badMaps.push(list.indexOf(map));
            }
        }
        while(!badMaps.empty()) {
            int index = badMaps.pop();
            list.remove(index);
        }
        System.out.println(list.size());
    }
}