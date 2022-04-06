import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement
{
    /**
     *
     *
     * find the kth largest element in the list
     *
     *
     * @param args
     */
    public static void main(String[] args)
    {
        int nums[]={7,6,9,3,8,10,12,15,1,202,99,5005};
        int kth=5;

        System.out.println(kthLargest(nums,kth));
        System.out.println(kthLargestPriorityQueue(nums,kth));
    }

    static int kthLargest(int[] nums,int k) {
        //Arrays.sort(nums,(a,b)->b.compareTo(a));
        Arrays.sort(nums);
        //System.out.println(nums);
        return nums[nums.length-k];
    }


    static int kthLargestPriorityQueue(int[] nums,int k) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>(k);

        for(int n:nums) {
            minHeap.add(n);
            if(minHeap.size()>k) minHeap.remove();
        }
        return minHeap.remove();

    }

}
