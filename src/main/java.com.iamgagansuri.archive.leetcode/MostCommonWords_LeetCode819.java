import java.util.Arrays;

public class MostCommonWords_LeetCode819
{

    public static void main(String[] args)
    {
        String paragraph="Bob hit a ball, the hit BALL flew far after it was hit.";

        paragraph=paragraph.replaceAll("[^a-zA-Z]","");

        System.out.println(paragraph);
        int[] occurence=new int[26];
        String s= "ababcbacadefegdehijhklij";
        //occurence of a = occurence[0
        for(int i=0;i<s.length();i++) {
            occurence[s.charAt(i)-'a']=i;
        }
       Arrays.stream(occurence).forEach(System.out::println);
    }
}
