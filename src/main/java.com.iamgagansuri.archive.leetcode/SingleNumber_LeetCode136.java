public class SingleNumber_LeetCode136 {


    public static void main(String[] args) {
        System.out.println(2^2);
        int[] nums=new int[]{6, 1, 3, 3,  6};
        System.out.println(singleNumber(nums));
    }

    public static  int singleNumber(int[] nums) {
        int result=nums[0];

        for(int i =1;i<nums.length;i++) {
            result=result^nums[i];
        }
    return result;
    }
}
