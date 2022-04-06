


import java.io.*;
        import java.util.*;
// Add any extra import statements you may need here


public class MinimumLengthSubString  {

    // Add any helper functions you may need here


    int minLengthSubstring(String s, String t) {
        // Write your code here
    Map<Character,Integer> textMap=new HashMap<>();
    Map<Character,Integer> patternMap=new HashMap<>();
    int currentMatchCount=0;
    int requiredMatchCount=t.length();

    for(Character c :t.toCharArray()) {
        patternMap.put(c,patternMap.getOrDefault(c,0)+1);
    }
    int startPointer_i=0;
    int leftPointer_j=0;
    String result="";
    while(true) {
        boolean rightPointerFlag=false,leftPointerFlag=false;
        // acquire the input and check if we meet the count of all the characters in the String
        while (startPointer_i < s.length() && currentMatchCount < requiredMatchCount) {
            rightPointerFlag=true;
            char c = s.charAt(startPointer_i++);
            textMap.put(c, textMap.getOrDefault(c, 0) + 1);
            //if this character is present in the pattern and the count of the character in text is still less than or equal to Pattern then increment the match count
            if (patternMap.containsKey(c) && textMap.get(c) <= patternMap.get(c)) {
                currentMatchCount++;
            }
        }

        //we have found a string matching out criteria. Now we need to minimize it by removing some characters from it.
        // either characters which are not in the pattern string or the ones for which count is more in text string than in the pattern string
            while(leftPointer_j<startPointer_i && currentMatchCount==requiredMatchCount) {
                leftPointerFlag=true;
                String potentialString=s.substring(leftPointer_j,startPointer_i);
                if(result.length()==0 || potentialString.length()<result.length()) {
                            result=potentialString;
                }
                char c = s.charAt(leftPointer_j++);
                //if the frequency of this char is more than required you can reduce this character frequency
                //if the frequency is 1 remove the char from the textmap
                if(textMap.get(c)==1) {
                    textMap.remove(c);
                } else {
                    textMap.put(c,textMap.get(c)-1);
                }

                if(textMap.getOrDefault(c,0)<patternMap.get(c)) {
                    currentMatchCount--;
                }
            }
            if(leftPointerFlag==false && rightPointerFlag==false) break;
        }
    return result.length()==0?-1:result.length();
    }











    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }
    public void run() throws IOException {
        String s_1 = "dcbefebce";
        String t_1 = "fd";
        int expected_1 = 5;
        int output_1 = minLengthSubstring(s_1, t_1);
        check(expected_1, output_1);

        String s_2 = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
        String t_2 = "cbccfafebccdccebdd";
        int expected_2 = -1;
        int output_2 = minLengthSubstring(s_2, t_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }
    public static void main(String[] args) throws IOException {
        new MinimumLengthSubString().run();
    }
}