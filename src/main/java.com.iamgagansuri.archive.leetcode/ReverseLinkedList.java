


import java.io.*;
        import java.util.*;
// Add any extra import statements you may need here


public class ReverseLinkedList {

    class Node {
        int data;
        Node next;
        Node(int x) {
            data = x;
            next = null;
        }
    }

    // Add any helper functions you may need here


    Node reverse1(Node head) {
        // Write your code here
        List<Integer> evens=new ArrayList<>();
        int position=0;
        boolean evenStart=false;
        Node temp=head;
        while(head != null) {
            if(head.data %2==0 && evenStart==false) {
                evenStart=true;
                evens.add(position);
            } else if(head.data%2!=0 && evenStart==true) {
                evenStart=false;
                evens.add(position-1);
            }
            head=head.next;
            position++;
        }
        if(evenStart==true) {evens.add(position-1);}
        System.out.println(evens);
        head=temp;

        while(head!=null) {


        }

        return null;

    }




    Node reverseAll(Node head) {
        Node previous,current,next;

        previous=next=null;
        current=head;

        while(current!=null) {
            next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }
        return previous;

    }

    Node reverse(Node head,Node previous) {
        if(head==null) return null;
        Node current,next;

        next=null;
        current=head;

        while(current!=null && current.data%2==0) {
            next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }
        //if current swap
        if(current!=head) {
            //if current node swaped with some node
            // then
            head.next=current;
            reverse(current,null);
            return previous;

        } else {
            head.next=reverse(head.next,head);
            return head;

    }

    }

    Node reverse(Node head) {
        return reverse(head,null);
    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void printLinkedList(Node head) {
        System.out.print("[");
        while (head != null) {
            System.out.print(head.data);
            head = head.next;
            if (head != null)
                System.out.print(" ");
        }
        System.out.print("]");
    }
    void check(Node expectedHead, Node outputHead) {
        boolean result = true;
        Node tempExpectedHead = expectedHead;
        Node tempOutputHead = outputHead;
        while (expectedHead != null && outputHead != null) {
            result &= (expectedHead.data == outputHead.data);
            expectedHead = expectedHead.next;
            outputHead = outputHead.next;
        }
        if (!(expectedHead == null && outputHead == null)) result = false;

        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printLinkedList(tempExpectedHead);
            System.out.print(" Your output: ");
            printLinkedList(tempOutputHead);
            System.out.println();
        }
        test_case_number++;
    }
    Node createLinkedList(int[] arr) {
        Node head = null;
        Node tempHead = head;
        for (int v : arr) {
            if (head == null) {
                head = new Node(v);
                tempHead = head;
            } else {
                head.next = new Node(v);
                head = head.next;
            }
        }
        return tempHead;
    }

    public void run() {

        int[] arr_1 = {1, 2, 8, 9, 12, 16};
        int[] expected1 = {1, 8, 2, 9, 16, 12};
        Node head_1 = createLinkedList(arr_1);
        Node expected_1 = createLinkedList(expected1);
        Node output_1 = reverse(head_1);
        check(expected_1, output_1);

        int[] arr_2 = {2, 18, 24, 3, 5, 7, 9, 6, 12};
        int[] expected2 = {24, 18, 2, 3, 5, 7, 9, 12, 6};
        Node head_2 = createLinkedList(arr_2);
        Node expected_2 = createLinkedList(expected2);
        Node output_2 = reverse(head_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new ReverseLinkedList().run();
    }
}