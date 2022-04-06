import java.util.*;
public class FindAllNumbersDisapperaredInArray_LeetCode448 {

    public static void main(String[] args) {
        int[]nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }




    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result= new ArrayList<>();
        Arrays.sort(nums);
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++) {
            set.add(nums[i]);
        }

        for(int i=1;i<nums.length+1;i++) {
            if(!set.contains(i)) {
                result.add(i);
            }
        }
return result;
    }
}
