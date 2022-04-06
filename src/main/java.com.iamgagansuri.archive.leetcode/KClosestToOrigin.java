import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestToOrigin {

    public static int[][] kClosest(int[][] points, int k) {

        int[][] result=new int[k][2];
        PriorityQueue<int[]> maxHeap=new PriorityQueue<>((p1,p2)->(p2[0]*p2[0]+p2[1]*p2[1]) - (p1[0]*p1[0] + p1[1]*p1[1]));

        for(int i=0;i<points.length;i++) {
            maxHeap.add(points[i]);
            if(maxHeap.size()>k) {
                maxHeap.remove();
            }
        }

        for(int i=0;i<k;i++) {
            result[i]=maxHeap.remove();
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[][] points=new int[][] {{1,3},{-2,2}};
        int k =1;
        Arrays.stream(kClosest(points,k)).forEach(a->System.out.println(a[0] +" : "+a[1]));
    }
}