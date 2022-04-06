import java.util.*;

public class FirstUniqueCharacter_LeetCode387 {


        public int firstUniqChar(String s) {

            Map<Character,Integer> map=new HashMap<>();
            char[]chars=s.toCharArray();
            for(char c: chars) {
               map.put(c,map.getOrDefault(c,0)+1);
            }
            int i=0;
            for(char c: chars) {
                if(map.get(c)==1) return i;
                i++;

            }

            return -1;
        }


    public int firstUniqChar1(String s) {

        Map<Character,Integer> map=new HashMap<>();
        char[]chars=s.toCharArray();
        for(int i=0;i<chars.length;i++) {
            map.put(chars[i],map.getOrDefault(chars[i],0)+1);
        }

        for(int i=0;i<chars.length;i++) {
            if(map.get(chars[i])==1) return i;
            i++;

        }

        return -1;
    }


    public int firstUniqChar3(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int minIndex=0;
        for(int i=0;i<s.length();i++) {
            char c =s.charAt(i);
            if(map.containsKey(c)) {
                map.put(c,map.get(c)+1);
            } else {
                map.put(c,1);
            }
        }

        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (map.get(c) == 1) return i;
        }
        return -1;

    }
    }



