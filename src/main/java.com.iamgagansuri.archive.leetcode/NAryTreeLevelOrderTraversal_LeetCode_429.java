import java.util.*;

public class NAryTreeLevelOrderTraversal_LeetCode_429
{

    public List<List<Integer>> levelOrder(Node root) {


        List<List<Integer>> result=new ArrayList<>();

        Queue<Node> bfsQueue=new LinkedList<>();
        if(root==null) return result;

        bfsQueue.add(root);

        while(!bfsQueue.isEmpty()) {
            //get all nodes in the queue
            int size=bfsQueue.size();
            List<Integer> level=new ArrayList<>();
            for(int i =0;i<size;i++) {
                Node n = bfsQueue.remove();
                level.add(n.val);
                bfsQueue.addAll(getNodesForALevel(n));
            }
            // for each node get childNodes and add them to the queu
            // add each node to the list
            result.add(level);
        }

        return result;
    }

    Queue<Node> getNodesForALevel(Node node){
        Queue<Node> levelQueue=new LinkedList<>();
        for(Node n: node.children) {
            levelQueue.add(n);
        }
        return levelQueue;

    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
