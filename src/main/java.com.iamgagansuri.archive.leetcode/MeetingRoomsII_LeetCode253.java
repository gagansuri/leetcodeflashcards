import java.util.Arrays;

public class MeetingRoomsII_LeetCode253 {


    class Interval{
        int start;
        int end;
        Interval(){start=0;end=0;}
        Interval(int s ,int e) {start=s;end=e;}
    }


    public int meetingRooms(Interval[] intervals) {
        //sort the interval

        Arrays.sort(intervals,(a,b)->a.start-b.start);

        return 0;
    }


    public  void call() {
        Interval i1=new Interval(0,30);
        Interval i2=new Interval(5,10);
        Interval i3=new Interval(15,20);
        Interval[] intervals = new Interval[3];
        intervals[0]=i3;intervals[1]=i2;intervals[2]=i1;
        meetingRooms(intervals);
    }

    public static void main(String[] args) {
        new MeetingRoomsII_LeetCode253().call();
    }
}
