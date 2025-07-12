/*leetcode 257
Given the root of a binary tree, return all root-to-leaf paths in any order.
A leaf is a node with no children.
Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]

*/
import java.util.*; 
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
    
}
class Q4_BinaryTreePath{
    public static List<String> binaryTreePath(TreeNode root){
        List<String> ans = new ArrayList<>();
        helper(root,ans,"");
        return ans;
    } 
    public static void helper(TreeNode root, List<String> ans,String s){
        if(root == null) return;
        if(root.left == null && root.right == null){
            ans.add(s+root.val);
            return;
            }
        helper(root.left,ans,s+root.val+"->");
        helper(root.right,ans,s+root.val+"->");


    }

    public static void main(String[] args){
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(5); // 2 -> 5

        List<String> result = binaryTreePath(root1);
        System.out.println("Root-to-leaf paths: " + result);


        
        
    }
    
}