import java.util.Arrays;
import java.util.PriorityQueue;

public class ConnectSticks_LeetCode1167
{

    public static int connectSticks(int[] sticks) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->a-b);
        for(int i =0;i<sticks.length;i++) {
            minHeap.add(sticks[i]);
        }

        int sum=0;
        while(minHeap.size()>1) {
            int stick1=minHeap.remove();
            int stick2=minHeap.remove();
            int cost=stick1+stick2;
            sum+=cost;
            minHeap.add(cost);
        }

        return sum;
    }

    public static void main(String[] args)
    {
        //int[]sticks=new int[]{1,3,5,8};
        int[]sticks=new int[]{2,4,3};
        System.out.println(connectSticks(sticks));
    }
}