import java.util.*;
public class SumOfASubArray {


    public static void main(String[] args) {
        int[] nums=new int[]{3,1,4,23};
        int k =8;
        nums=new int[]{12, 1, 61, 5, 9, 2};
        k=24;

        nums=new int[]{1, 4, 20, 3, 10, 5};
        k=33;
        System.out.println(isSumPresent(nums,33));
    }

    static boolean isSumPresent(int[]nums,int k) {
        int currentSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            //say current sum is 38 and we get 5 while target is 33
            int rem = currentSum-k;
            if (map.containsKey(rem)) {
                //check if the difference between their positions is atleast 2
                //if current position - the position of the previous same mod is more than 2
                if (i - map.get(rem) >= 2)
                    return true;
            } else {
                map.put(currentSum, i);
            }
            System.out.println(map);
        }
        return false;
    }
























    static boolean isSumPresent1(int[]nums,int k) {
        int currentSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            //say current sum is 38 and we get 5 while target is 33
            int mod = currentSum % k;
            if (map.containsKey(mod)) {
                //check if the difference between their positions is atleast 2
                //if current position - the position of the previous same mod is more than 2
                if (i - map.get(mod) >= 2)
                    return true;
            } else {
                map.put(mod, i);
            }

        }
        return false;
    }
}
