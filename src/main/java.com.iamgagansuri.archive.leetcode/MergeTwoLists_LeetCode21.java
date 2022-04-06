import java.util.*;

public class MergeTwoLists_LeetCode21 {

    public static void main(String[] args) {
        ListNode head_One=new ListNode(1);
        ListNode two_One=new ListNode(2);
        ListNode three_One=new ListNode(4);
        head_One.next=two_One;
        two_One.next=three_One;
        three_One.next=null;

        ListNode head_two=new ListNode(1);
        ListNode two_two=new ListNode(3);
        ListNode three_two=new ListNode(4);
        head_two.next=two_two;
        two_two.next=three_two;
        three_two.next=null;

        print(head_One);
        print(head_two);

        MergeTwoLists_LeetCode21 ml=new MergeTwoLists_LeetCode21();
        print(ml.mergeTwoLists1(head_One,head_two));
        print(ml.mergeTwoLists(head_One,head_two));

    }

    static void print(ListNode n) {
        while(n!=null) {
            System.out.print(n.val +" ->  ");
            n=n.next;
        }
        System.out.println();
    }

   static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

        public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {

            PriorityQueue<Integer> minHeap=new PriorityQueue<>();
            while(l1!=null) {
                minHeap.add(l1.val);
                l1=l1.next;
            }

            while(l2!=null) {
                minHeap.add(l2.val);
                l2=l2.next;
            }

            ListNode ls=new ListNode(-1);
            ListNode temp=ls;

            while(!minHeap.isEmpty()) {
                int num=minHeap.remove();
                ListNode n=new ListNode(num);
                temp.next=n;
                temp=temp.next;
            }
            return ls.next;

        }


        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head=new ListNode();
            ListNode temp=head;
            while(l1!=null && l2!=null) {
                if(l1.val<l2.val) {
                    temp.next=l1;
                    l1=l1.next;
                    temp=temp.next;
                } else if(l2.val<=l1.val) {
                    temp.next=l2;
                    l2=l2.next;
                    temp=temp.next;
                } /*else if(l1.val==l2.val) {
                    temp.next=l1;
                    temp=temp.next;
                    temp.next=l2;
                    temp=temp.next;
                    l1=l1.next;
                    l2=l2.next;
                }*/
            }

            while(l1!=null) {
                temp.next=l1;
                l1=l1.next;
                temp=temp.next;
            }

            while(l2!=null) {
                temp.next=l2;
                l2=l2.next;
                temp=temp.next;
            }
            return head.next;
        }
    }
