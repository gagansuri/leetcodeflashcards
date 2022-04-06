import java.util.*;

public class CalendarImplementation_LeetCode {

    public static void main(String[] args) {
        /*
        ["MyCalendar","book","book","book","book","book","book","book","book","book","book"]
[[],[47,50],[33,41],[39,45],[33,42],[25,32],[26,35],[19,25],[3,8],[8,13],[18,27]]
         */
        /*
        ["MyCalendar","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book"]
[[],[97,100],[33,51],[89,100],
[83,100],[75,92],[76,95],
[19,30],
[53,63],[8,23],
[18,37],[87,100],[83,100],
[54,67],[35,48],[58,75],[70,89],[13,32],[44,63],[51,62],[2,15]]
        */
        CalendarImplementation_LeetCode myCalendar=new CalendarImplementation_LeetCode();
        System.out.print(myCalendar.book(97,100)+" ");
        System.out.print(myCalendar.book(33,51)+" ");
        System.out.print(myCalendar.book(89,100)+" ");
        System.out.print(myCalendar.book(83,100)+" ");
        System.out.print(myCalendar.book(75,92)+" ");
        System.out.print(myCalendar.book(76,95)+" ");
        System.out.print(myCalendar.book(19,30)+" ");

        System.out.print(myCalendar.book(53,63)+" ");
        System.out.print(myCalendar.book(8,23)+" ");
        System.out.print(myCalendar.book(18,37)+" ");
        System.out.print(myCalendar.book(87,100)+" ");
        System.out.print(myCalendar.book(83,100)+" ");
        System.out.print(myCalendar.book(54,67)+" ");
        System.out.print(myCalendar.book(35,48)+" ");
        System.out.print(myCalendar.book(58,75)+" ");
        System.out.print(myCalendar.book(70,89)+" ");

        System.out.print(myCalendar.book(13,32)+" ");
        System.out.print(myCalendar.book(44,63)+" ");
        System.out.print(myCalendar.book(51,62)+" ");
        System.out.print(myCalendar.book(2,15)+" ");
/*  [null,true,true,false,false,true,false,true,true,false,false,false,false,false,false,false,false,true,false,false,false]
    [null,true,true,false,false,true,false,true,true,false,false,false,false,false,false,false,false,false,false,false,true]
         true,true,false,false,true,false,true,true,false,false,false,false,false,false,false,false,false,false,false,true
*/

    }
    List<Slot> slots;
    public CalendarImplementation_LeetCode() {
        slots=new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for(Slot slot:slots) {
            if(start==13 && end==32) {
            //    System.out.println("start :"+start +" end :"+end);
            //    System.out.println("Slotstart :"+slot.getStart() +" Slot end :"+slot.getEnd());
            }
            if(     (start>=slot.getStart() && start< slot.getEnd()) ||
                    (end>slot.getStart() && end < slot.getEnd()) ||
                    (start<=slot.getStart() && end>slot.getStart() && end <= slot.getEnd()) ||
                    (start<=slot.getStart() && end >= slot.getEnd())) {
                return false;
            }
        }
        slots.add(new Slot(start,end));
        return true;
    }

    class Slot{
        int startTime;
        int endTime;

        public Slot(int _s,int _t) {
            this.startTime=_s;
            this.endTime=_t;
        }

        public int getStart(){return startTime;}
        public int getEnd(){return endTime;}

    }

}
