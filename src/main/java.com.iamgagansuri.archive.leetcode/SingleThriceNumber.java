import java.util.*;

public class SingleThriceNumber {


    public static void main(String[] args) {
        System.out.println(2^2);
        int[] nums=new int[]{6,6,3, 1,1, 3, 3,  6};
        System.out.println(singleNumber(nums));
    }

    public static  int singleNumber(int[] nums) {
        int result=nums[0];
        int sum=0;
        int uniqueNumberSum=0;
        Set<Integer> numSet=new HashSet<>();
        for(int i =0;i<nums.length;i++) {
            numSet.add(nums[i]);
            sum+=nums[i];
        }
        for(int n : numSet) {
            uniqueNumberSum+=n;
        }
        System.out.println("Sums : "+sum+ " unique sums : "+uniqueNumberSum);
        return uniqueNumberSum*3-sum;
    //return result;
    }
}
