public class BSTree {

    class Node {
        int key;
        Node left, right;

        public Node(int data) {
            key = data;
            left = right = null;
        }
    }

    Node root;

    BSTree() { 
        root = null; 
    }

    BSTree(int value) { 
        root = new Node(value); 
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    void inorderTrav(Node root) {
        if (root != null) {
            inorderTrav(root.left);
            System.out.print(root.key + " ");
            inorderTrav(root.right);
        }
    }

    void preorderTrav(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderTrav(root.left);
            preorderTrav(root.right);
        }
    }

    void postorderTrav(Node root) {
        if (root != null) {
            postorderTrav(root.left);
            postorderTrav(root.right);
            System.out.print(root.key + " ");
        }
    }

    boolean search(int key) {
        root = searchRec(root, key); 
        if (root != null)
            return true;
        else
            return false;
    }

    Node searchRec(Node root, int key) {
        if (root == null || root.key == key) 
            return root; 
        if (key < root.key) 
            return searchRec(root.left, key); 
        else 
            return searchRec(root.right, key); 
    }

    public static void main(String[] args) {        
        BSTree tree = new BSTree();

        tree.insert(8);
        tree.insert(3);
        tree.insert(1);
        tree.insert(6);
        tree.insert(10);
        tree.insert(9);
        tree.insert(14);

        System.out.print("Preorder traversal: ");
        tree.preorderTrav(tree.root);

        System.out.print("\nInorder traversal: ");
        tree.inorderTrav(tree.root);

        System.out.print("\nPostorder traversal: ");
        tree.postorderTrav(tree.root);

        boolean found = tree.search(9);

        System.out.println("\nSearch element: " + found );      
    }
}