//leetcode 110

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}
class Q2_BalanceBinaryTree{
   public int height(TreeNode root){
    if(root==null || (root.left==null && root.right==null))return 0;
    return 1+Math.max(height(root.left),height(root.right));
   }
   public boolean isBalance(TreeNode root){
        if(root==null)return true;
        int lh = height(root.left);
        if(root.left!=null)lh++;
        int rh = height(root.right);
        if(root.right!=null)rh++;
        int d= lh-rh;
        if(d<0) d = -d;
        if(d>1) return false;
        return isBalance(root.left) && isBalance(root.right);

   } 
    public static void main(String[] args) {
        Q2_BalanceBinaryTree obj = new Q2_BalanceBinaryTree();

        /*
                  1
                 / \
                2   3
               /
              4
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        boolean isBalanced = obj.isBalance(root);
        System.out.println("Is the tree balanced? " + isBalanced);
    }
}