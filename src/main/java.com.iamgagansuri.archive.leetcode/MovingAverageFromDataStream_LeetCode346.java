import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageFromDataStream_LeetCode346 {


    public static void main(String[] args) {
        MovingAverageQueue mAQ=new MovingAverageQueue(3);
        System.out.println(mAQ.next(1));
        System.out.println(mAQ.next(10));
        System.out.println(mAQ.next(3));
        System.out.println(mAQ.next(5));
    }

static class MovingAverageQueue {
    private Queue<Integer> queue;
    private double sum;
    private int size;
    public MovingAverageQueue(int size) {
        queue=new LinkedList<>();
        this.sum=0.0;
        this.size=size;

    }

    public double next(int val) {
        if(queue.size()==size) {
            int elem=queue.remove();
            sum-=elem;
        }
        queue.add(val);
        sum+=val;
        return sum/queue.size();
    }
}
}