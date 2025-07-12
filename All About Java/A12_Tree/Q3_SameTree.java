/*leetcode 100
Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value. 
Input: p = [1,2,3], q = [1,2,3]
Output: true
*/
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
    
}
class Q3_SameTree{
    public static  boolean isSameTree(TreeNode p, TreeNode q){
        // Base cases
        if (p == null && q == null) return true;     // Both null => same
        if (p == null || q == null) return false;    // One null => not same
        if (p.val != q.val) return false;            // Value mismatch => not same
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    public static void main(String[] args){
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        System.out.println(isSameTree(root1, root2)); // true

        
    }
    
}