import java.util.*;
public class FindKthLargetElementFromArray_LeetCode215 {

    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();

        for(int n:nums) {
            minHeap.add(n);
            if(minHeap.size()>k) {
                System.out.println(minHeap.remove());
            }

        }
        return minHeap.remove();
    }

    public static void main(String[] args) {
        int[] nums={3,2,1,5,6,4};
        System.out.println(findKthLargest(nums,2));
    }

}
