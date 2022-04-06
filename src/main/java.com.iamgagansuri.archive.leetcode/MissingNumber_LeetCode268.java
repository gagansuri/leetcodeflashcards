import java.util.*;

public class MissingNumber_LeetCode268 {


    /*

    given an array of numbers from 0,1,2,3,4,5....n find the missing number

     */

    public int missingNumber(int[] nums) {
        Set<Integer> numberSet=new HashSet<>();

        for(int i=0;i<nums.length;i++) {
            numberSet.add(nums[i]);
        }

        for(int i=0;i<nums.length+1;i++) {
            if(!numberSet.contains(i)) return i;
        }
        return -1;
    }
    public int missingNumberOptm(int[] nums) {
        int sum=0;
        int originalLengthOfNumbers=nums.length+1;

        for(int i=0;i<nums.length;i++) {
            sum+=nums[i];
        }

        return (originalLengthOfNumbers*(originalLengthOfNumbers-1)/2) - sum;
    }

    public static void main(String[] args) {
        System.out.println("{3,0,1}->2 :  "+new MissingNumber_LeetCode268().missingNumber(new int[]{3,0,1}));

        System.out.println("{9,6,4,2,3,5,7,0,1}->8 : "+new MissingNumber_LeetCode268().missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));

        System.out.println("optmoptmoptmoptmoptmoptmoptmoptmoptmoptmoptmoptmoptmoptmoptmoptmoptmoptmoptmoptmoptmoptmoptmoptmoptmoptm");
        System.out.println("{3,0,1}->2 :  "+new MissingNumber_LeetCode268().missingNumberOptm(new int[]{3,0,1}));
        System.out.println("{9,6,4,2,3,5,7,0,1}->8 : "+new MissingNumber_LeetCode268().missingNumberOptm(new int[]{9,6,4,2,3,5,7,0,1}));


    }
}
