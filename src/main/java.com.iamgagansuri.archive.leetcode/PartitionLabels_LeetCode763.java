import java.util.*;
public class PartitionLabels_LeetCode763
{

    public static void main(String[] args)
    {
        String s= "ababcbacadefegdehijhklij";
        s="caedbdedda";
        partitionLabels(s).forEach(System.out::println);

    }

    public static List<Integer> partitionLabels(String s) {
        List<Integer> result  = new ArrayList<>();
        int[] lastoccurence=new int[26];

        for(int i=0;i<s.length();i++) {
            lastoccurence[s.charAt(i)-'a']=i;
        }

        //Arrays.stream(lastoccurence).forEach(System.out::println);
        int i=0;
        while(i<s.length()) {
            //find the last occurence of first charcter

            int end=lastoccurence[s.charAt(i)-'a'];

            /*
             int j=i;
            while(j!=end) {
                end=Math.max(end,lastoccurence[s.charAt(j++)-'a']);
            }
             */

            //now from next character j=i+1 to end see that none of the characters last occurence is greater than end
            int j=i;
            while(j<=end) {
                if(lastoccurence[s.charAt(j)-'a']>end) {
                    end=lastoccurence[s.charAt(j)-'a'];

                }
                j++;
            }

            result.add(j-i+1);
            i=j+1;

        }
        return result;
    }
}
