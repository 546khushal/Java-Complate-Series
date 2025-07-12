import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    public Node(int value) {
        data = value;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    // Create a new node in the tree
    public void createNode(int value) {
        root = insert(root, value);
    }

    private Node insert(Node tree, int value) {
        if (tree == null) {
            return new Node(value);
        }
        if (value > tree.data) {
            tree.right = insert(tree.right, value);
        } else {
            tree.left = insert(tree.left, value);
        }
        return tree;
    }

    // PreOrder Traversal
    public void preOrder(Node tree) {
        if (tree != null) {
            System.out.print(tree.data + " ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    // PostOrder Traversal
    public void postOrder(Node tree) {
        if (tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.print(tree.data + " ");
        }
    }

    // InOrder Traversal
    public void inOrder(Node tree) {
        if (tree != null) {
            inOrder(tree.left);
            System.out.print(tree.data + " ");
            inOrder(tree.right);
        }
    }

    // Determine the height of the tree
    public int determineHeight(Node tree) {
        if (tree == null) return 0;
        int leftHeight = determineHeight(tree.left);
        int rightHeight = determineHeight(tree.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Count total nodes
    public int totalNodes(Node tree) {
        if (tree == null) return 0;
        return totalNodes(tree.left) + totalNodes(tree.right) + 1;
    }

    // Count internal nodes
    public int internalNodes(Node tree) {
        if (tree == null || (tree.left == null && tree.right == null)) return 0;
        return internalNodes(tree.left) + internalNodes(tree.right) + 1;
    }

    // Count external nodes
    public int externalNodes(Node tree) {
        if (tree == null) return 0;
        if (tree.left == null && tree.right == null) return 1;
        return externalNodes(tree.left) + externalNodes(tree.right);
    }

    // Find the minimum value in the tree
    public int findMinValue(Node tree) {
        if (tree == null) {
            System.out.println("Tree is empty.");
            return -1;
        }
        while (tree.left != null) {
            tree = tree.left;
        }
        return tree.data;
    }

    // Find the maximum value in the tree
    public int findMaxValue(Node tree) {
        if (tree == null) {
            System.out.println("Tree is empty.");
            return -1;
        }
        while (tree.right != null) {
            tree = tree.right;
        }
        return tree.data;
    }

    // Search for a node
    public boolean searchNode(Node tree, int value) {
        if (tree == null) return false;
        if (tree.data == value) return true;
        return value < tree.data ? searchNode(tree.left, value) : searchNode(tree.right, value);
    }

    // Remove the entire tree
    public void removeTree() {
        root = null;
        System.out.println("Tree has been deleted.");
    }

    // Delete a node
    public Node deleteNode(Node tree, int value) {
        if (tree == null) {
            System.out.println("Node with value " + value + " not found.");
            return null;
        }

        if (value < tree.data) {
            tree.left = deleteNode(tree.left, value);
        } else if (value > tree.data) {
            tree.right = deleteNode(tree.right, value);
        } else {
            // Node with one or no child
            if (tree.left == null) return tree.right;
            if (tree.right == null) return tree.left;

            // Node with two children
            tree.data = findMinValue(tree.right);
            tree.right = deleteNode(tree.right, tree.data);
        }
        return tree;
    }
}

public class BinaryTreeDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        int choice, value;
        do {
            System.out.println("\n----Binary Search Tree Operations----");
            System.out.println("1. Create Tree");
            System.out.println("2. Traversal");
            System.out.println("3. Height of Tree");
            System.out.println("4. Total Nodes");
            System.out.println("5. Internal Nodes");
            System.out.println("6. External Nodes");
            System.out.println("7. Remove Tree");
            System.out.println("8. Insert Node");
            System.out.println("9. Search Node");
            System.out.println("10. Find Smallest Node");
            System.out.println("11. Find Largest Node");
            System.out.println("12. Delete Node");
            System.out.println("13. Exit");
            System.out.print("Enter Your Choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter number of nodes to create: ");
                    int n = scanner.nextInt();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Enter value to insert: ");
                        value = scanner.nextInt();
                        bst.createNode(value);
                    }
                    break;

                case 2:
                    System.out.println("\nPreOrder: ");
                    bst.preOrder(bst.root);
                    System.out.println("\nPostOrder: ");
                    bst.postOrder(bst.root);
                    System.out.println("\nInOrder: ");
                    bst.inOrder(bst.root);
                    break;

                case 3:
                    System.out.println("Height of Tree: " + bst.determineHeight(bst.root));
                    break;

                case 4:
                    System.out.println("Total Nodes: " + bst.totalNodes(bst.root));
                    break;

                case 5:
                    System.out.println("Internal Nodes: " + bst.internalNodes(bst.root));
                    break;

                case 6:
                    System.out.println("External Nodes: " + bst.externalNodes(bst.root));
                    break;

                case 7:
                    bst.removeTree();
                    break;

                case 8:
                    System.out.print("Enter value to insert: ");
                    value = scanner.nextInt();
                    bst.createNode(value);
                    System.out.println("Inserted successfully.");
                    break;

                case 9:
                    System.out.print("Enter value to search: ");
                    value = scanner.nextInt();
                    System.out.println(bst.searchNode(bst.root, value) ? "Element present" : "Element not present");
                    break;

                case 10:
                    System.out.println("Smallest Value: " + bst.findMinValue(bst.root));
                    break;

                case 11:
                    System.out.println("Largest Value: " + bst.findMaxValue(bst.root));
                    break;

                case 12:
                    System.out.print("Enter value to delete: ");
                    value = scanner.nextInt();
                    bst.root = bst.deleteNode(bst.root, value);
                    break;

                case 13:
                    System.out.println("Program Ended...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 13);

        scanner.close();
    }
}
