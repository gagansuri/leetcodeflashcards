import java.util.*;


public class GroupAnagrams_LeetCode49 {

    public static void main(String[] args) {
        char[] s="gagan".toCharArray();Arrays.sort(s);
        System.out.println(s);
        String[]strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        GroupAnagrams_LeetCode49 gr=new GroupAnagrams_LeetCode49();
        System.out.println(gr.groupAnagrams(strs));
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String s : strs) {
            char[] s1=s.toCharArray();
            Arrays.sort(s1);
            String s2 =new String(s1);
            if(map.containsKey(s2)) {
                map.get(s2).add(s);
            } else {
                List<String> sameAnagrams=new ArrayList<>();
                sameAnagrams.add(s);
                map.put(s2,sameAnagrams);
            }

        }
        List<List<String>> result=new ArrayList<>();
        for(String s: map.keySet()) {
            result.add(map.get(s));
        }
        return result;
    }
}
