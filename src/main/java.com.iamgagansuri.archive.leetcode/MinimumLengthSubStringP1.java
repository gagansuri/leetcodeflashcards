import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
// Add any extra import statements you may need here


public class MinimumLengthSubStringP1 {

    // Add any helper functions you may need here


    int minLengthSubstring(String s, String t) {
        /*
        create a frequency map of the pattern
         */
        Map<Character,Integer> patternFrequencyMap=new HashMap<>();
        Map<Character,Integer> textFrequencyMap=new HashMap<>();
        String result="";
        for(char c : t.toCharArray()) {
            patternFrequencyMap.put(c,patternFrequencyMap.getOrDefault(c,0)+1);
        }

        /*
        now create a frequency map of text, with left and right pointer.
        rightPointer to keep track of when the countofCharacters matches the pattern
         */
        int leftPointer=0,rightPointer=0;
        int matchCount=0,requiredMatchCount=t.length();
        while(true) {

            boolean leftPointerFlag = false, rightPointerFlag = false;

            while (rightPointer < s.length() && matchCount < requiredMatchCount) {
                rightPointerFlag = true;
                char c = s.charAt(rightPointer++);
                textFrequencyMap.put(c, textFrequencyMap.getOrDefault(c, 0) + 1);
                if (patternFrequencyMap.containsKey(c) && textFrequencyMap.get(c) <= patternFrequencyMap.get(c)) {
                    matchCount++;
                }
            }


            //here we have a string from leftPointer to rightPointer that contains all the characters present in t and equal or more counts
            //try to shorten the length of the string from the left as long as matchCount == requiredMatchCount
            //decrement matchCount when u reduce the count in textmap and it becomes lesser than its count in patternmap
            while (leftPointer < rightPointer && matchCount == requiredMatchCount) {
                String probableSubString = s.substring(leftPointer, rightPointer);

                if (result.length() == 0 || result.length() > probableSubString.length()) {
                    result = probableSubString;
                }
                leftPointerFlag = true;

                char c = t.charAt(leftPointer++);
                if (textFrequencyMap.get(c) == 1) {
                    textFrequencyMap.remove(c);
                } else {
                    textFrequencyMap.put(c, textFrequencyMap.get(c) - 1);
                }
                if (textFrequencyMap.getOrDefault(c,0)<patternFrequencyMap.get(c) ) {
                    matchCount--;
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
        new MinimumLengthSubStringP1().run();
    }
}