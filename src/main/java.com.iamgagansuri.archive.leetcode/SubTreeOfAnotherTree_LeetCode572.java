public class SubTreeOfAnotherTree_LeetCode572
{

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(root==null && subRoot==null) {
            return true;
        } else if((root==null && subRoot!=null) || ((root!=null && subRoot==null))) {
            return false;
        }else if(root.val == subRoot.val) {
            return isSubtree(root.left,subRoot.left) && isSubtree(root.right,subRoot.right);
        } else if(root.val!=subRoot.val) {
            return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
        } else {
            return false;
        }

    }

    class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode()
        {
        }

        TreeNode(int val)
        {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right)
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
