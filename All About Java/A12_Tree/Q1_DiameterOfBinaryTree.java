/*leetcode 543
Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any 
two nodes in a tree. This path may or may not pass through the root. */
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Q1_DiameterOfBinaryTree {
    public static  int height(TreeNode root){
        if(root==null || (root.left==null && root.right==null))return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
    public static  int diameterOfBinaryTree(TreeNode root) {
        if(root==null || (root.left==null && root.right==null))return 0;
        int leftAns= diameterOfBinaryTree(root.left);
        int rightAns= diameterOfBinaryTree(root.right);
        int mid = height(root.left)+height(root.right);
        if(root.left!=null)mid++;
        if(root.right!=null)mid++;

        int max = Math.max(leftAns,Math.max(rightAns,mid));

        return max;
    }

    // Main to test
    public static void main(String[] args) {
        /*
                1
               / \
              2   3
             / \
            4   5
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Diameter of Tree: " + diameterOfBinaryTree(root)); // Output: 3 (path: 4-2-1-3)
    }
}

