import java.util.*;

public class LetterCombinationsPhoneNumber_LeetCode17 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<>();
        String[] mapping={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if(digits==null || digits.length()==0) {
            return result;
        }

        letterCombinationsRecursive(digits,result,mapping,0,"");
        return result;
    }

    private static void letterCombinationsRecursive(String digits,List<String>result,String[]mapping,int currentIndex,String currentCombinationString) {
        if(currentIndex==digits.length()) {
            result.add(currentCombinationString);
            return;
        }
        //for digits 2 3 , get mapping [2] which is abc
        String letters=mapping[digits.charAt(currentIndex)-'0'];
        // for each letter
        for(int i =0;i<letters.length();i++) {
            letterCombinationsRecursive(digits,result,mapping,currentIndex+1,currentCombinationString+letters.charAt(i));
        }
    }
}