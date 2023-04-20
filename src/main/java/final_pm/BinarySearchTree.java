/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package final_pm;

/**
 *
 * @author maison info
 */
import java.util.Scanner;

class Node {
   public int key;
    Node left, right;
    
    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BST {
    Node root;
    
    BST() {
        root = null;
    }
    
    void insert(int key) {
        root = insertRec(root, key);
    }
    
    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        }
        else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        
        return root;
    }
    
    void delete(int key) {
        root = deleteRec(root, key);
    }
    
    Node deleteRec(Node root, int key) {
        if (root == null) {
            return root;
        }
        
        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        }
        else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        }
        else {
            if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }
            
            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        
        return root;
    }
    
    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
    
    boolean search(int key) {
        Node curr = root;
        while (curr != null) {
            if (key == curr.key) {
                return true;
            }
            else if (key < curr.key) {
                curr = curr.left;
            }
            else {
                curr = curr.right;
            }
        }
        return false;
    }
    
    boolean isBST() {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    boolean isBSTUtil(Node node, int min, int max) {
        if (node == null) {
            return true;
        }
        
        if (node.key < min || node.key > max) {
            return false;
        }
        
        return (isBSTUtil(node.left, min, node.key-1) && isBSTUtil(node.right, node.key+1, max));
    }
    
    void inorder() {
        inorderRec(root);
        System.out.println();
    }
    
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }
}

public class BinarySearchTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BST bst = new BST();
        boolean loop = true;
           System.out.print("Combien de clés voulez-vous saisir ? ");
                    int n = sc.nextInt();
                    System.out.print("Entrez les clés : ");
                    for (int i = 0; i < n; i++) {
                        int key = sc.nextInt();
                        bst.insert(key);
                    }
                    System.out.print("Arbre binaire de recherche saisi : ");
                    bst.inorder();
              if (bst.isBST()) {
                        System.out.println("C'est bien un arbre binaire de recherche.");
                    }
                    else {
                        System.out.println("Ce n'est pas un arbre binaire de recherche.");
                    }
        while (loop) {
           // System.out.println("1. Saisir un arbre binaire de recherche");
            //System.out.println("2. Vérifier qu'il s'agit bien d'un arbre binaire de recherche");
            System.out.println("1. Insérer une clé");
            System.out.println("2. Rechercher une clé");
                        System.out.println("3. Supprimer une clé");
            System.out.println("4. Quitter");
            System.out.print("Choix : ");
            
            int choice = sc.nextInt();
            
            switch(choice) {
                //case 1:
                  //  System.out.print("Combien de clés voulez-vous saisir ? ");
                  //  int n = sc.nextInt();
                    //System.out.print("Entrez les clés : ");
                    //for (int i = 0; i < n; i++) {
                      //  int key = sc.nextInt();
                        //bst.insert(key);
                   // }
                   // System.out.print("Arbre binaire de recherche saisi : ");
                    //bst.inorder();
                   // break;
                    
               /* case 2:
                    if (bst.isBST()) {
                        System.out.println("C'est bien un arbre binaire de recherche.");
                    }
                    else {
                        System.out.println("Ce n'est pas un arbre binaire de recherche.");
                    }
                    break;
                 */   
                case 1:
                    System.out.print("Entrez la clé à insérer : ");
                    int key = sc.nextInt();
                    bst.insert(key);
                    System.out.print("Arbre binaire de recherche mis à jour : ");
                    bst.inorder();
                    break;
                    
                case 2:
                    System.out.print("Entrez la clé à rechercher : ");
                    int searchKey = sc.nextInt();
                    if (bst.search(searchKey)) {
                        System.out.println("La clé " + searchKey + " a été trouvée.");
                    }
                    else {
                        System.out.println("La clé " + searchKey + " n'a pas été trouvée.");
                    }
                    break;
                    
                case 3:
                    System.out.print("Entrez la clé à supprimer : ");
                    int deleteKey = sc.nextInt();
                    bst.delete(deleteKey);
                    System.out.print("Arbre binaire de recherche mis à jour : ");
                    bst.inorder();
                    break;
                    
                case 4:
                    loop = false;
                    break;
                    
                default:
                    System.out.println("Choix invalide.");
            }
        }
    }

   
}


