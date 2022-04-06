import java.util.*;
public class PlusOne_LeetCode66 {
    public static int[] plusOne(int[] digits) {
        int carry=0;

        for(int i=digits.length-1;i>=0;i--) {
            if(digits[i]<9) {
                digits[i]++;
                return digits;
            }
            digits[i]=0;
            }
        //it does not return meaning the array is now all zeroes

        int[] result= new int[digits.length+1];
        result[0]=1;
        return result;
    }

    public static void main(String[] args) {
        int[] num=new int[]{1,7,9};
        //System.out.println(plusOne(num));
        Map<Integer,Integer> map=new HashMap<>();
        char c =' ';
        System.out.println(c);

    }
}