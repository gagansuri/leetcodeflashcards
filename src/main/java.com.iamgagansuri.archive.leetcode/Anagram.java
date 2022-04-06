import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagram {


    boolean isAnagram(String s, String t) {
        if(s!=null && t!=null && s.length()!=t.length()) return false;
        char[] s1 =s.toCharArray();
        char[] t1 =t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);

        String s1Sorted=new String(s1);
        String t1Sorted=new String(t1);

        return s1Sorted.equals(t1Sorted);
     /*   Arrays.sort(s.toCharArray());

        Map<Character,Integer> frequencyMapOfS=new HashMap<>();
        Map<Character,Integer> frequencyMapOfT=new HashMap<>();

        for(int i =0;i<s.length();i++) {
            frequencyMapOfS.put(s.charAt(i),frequencyMapOfS.getOrDefault(s.charAt(i),0)+1);
            frequencyMapOfT.put(t.charAt(i),frequencyMapOfT.getOrDefault(t.charAt(i),0)+1);
        }

        for(Character c : frequencyMapOfS.keySet()) {
            if(frequencyMapOfS.get(c)!=frequencyMapOfT.get(c)) return false;
        }
         return true;*/
    }


    public static void main(String[] args) {
        String s="anagram",t="nagaram";
        System.out.println(new Anagram().isAnagram(s,t));

        System.out.println(new Anagram().isAnagram("rat","car"));


    }
}
