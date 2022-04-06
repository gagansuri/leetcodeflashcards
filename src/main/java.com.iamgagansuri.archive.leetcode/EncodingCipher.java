import java.util.*;
public class EncodingCipher {
    Map<Character,Integer>lookupMap=new HashMap<>();

    {
        lookupMap.put('a',1);
        lookupMap.put('a', 2);
        lookupMap.put('a', 3);
        lookupMap.put('a', 4);
        lookupMap.put('a', 5);
        lookupMap.put('a', 6);
        lookupMap.put('a', 7);
        lookupMap.put('a', 8);
        lookupMap.put('a', 9);
        lookupMap.put('a', 10);
        lookupMap.put('a', 11);
        lookupMap.put('a', 12);
        lookupMap.put('a', 13);
        lookupMap.put('a', 14);
        lookupMap.put('a', 15);
        lookupMap.put('a', 16);
        lookupMap.put('a', 17);
        lookupMap.put('a', 18);
        lookupMap.put('a', 19);
        lookupMap.put('a', 20);
        lookupMap.put('a', 21);
        lookupMap.put('a', 22);
        lookupMap.put('a', 23);
        lookupMap.put('a', 24);
        lookupMap.put('a', 25);
    }
    public static void main(String[] args) {

     String input ="124567";
     int count=new EncodingCipher().decode(input);
        System.out.println(count);
    }


    int decode(String message) {
        String pre="";
        int count=0;
        for(int i=0;i<message.length();i++) {
            char c= message.charAt(i);
            if(c=='0') return 0;
            if(c>'0' && c<='9') {
                count++;
            }
            if(pre.equals("")==false) {
                String key2 = new StringBuilder().append(pre).append(c).toString();
                int key = Integer.valueOf(key2);
                if (key >= 0 && key <= 26) {
                    count++;
                }
            }
                pre=c+"";
        }
return count;

    }



}
