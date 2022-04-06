package datastructures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstTraversal
{
    public Node createTree()
    {
        int[] nodes=new int[]{9,6,12,1,4,34,45};
        Node root=new Node(9);
        Node nL1=new Node(6);
        Node nR1=new Node(12);
        root.left=nL1;
        root.right=nR1;

        Node nL2L=new Node(1);
        Node nL2R=new Node(14);
        nL1.left=nL2L;
        nL1.right=nL2R;


        Node nR2L=new Node(34);
        Node nR2R=new Node(45);
        nR1.left=nR2L;
        nR1.right=nR2R;
        return root;


    }



    class Node {
           int data;
           Node left=null;
           Node right=null;
           Node(int d) {
               this.data=d;
           }
    }


    public static void main(String[] args)
    {
        BreadthFirstTraversal bfs=new BreadthFirstTraversal();
        Node root=bfs.createTree();

        bfs.traverseBFS(root);
        System.out.println("========================================DFS");
        bfs.traverseDFS(root);

    }


    void traverseBFS(Node root) {
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int nodes=queue.size();

            for(int i=0;i<nodes;i++) {
                Node n=queue.remove();
                if(n.left!=null) queue.add(n.left);
                if(n.right!=null) queue.add(n.right);
                System.out.print(n.data +"   ");
            }
            System.out.println();
        }
    }

    void traverseDFS(Node root) {
        Stack<Node> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty())
        {
        Node n=stack.pop();
        if(n.right!=null) stack.push(n.right);
        if(n.left!=null) stack.push(n.left);
            System.out.println(n.data);
        }
    }
}
