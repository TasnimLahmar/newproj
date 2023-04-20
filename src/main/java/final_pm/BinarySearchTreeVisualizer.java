/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package final_pm;

/**
 *
 * @author maison info
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Scanner;

public class BinarySearchTreeVisualizer extends JPanel {

    private BST bst;
    private int width;
    private int height;
    private int x0;
    private int y0;

    /**
     *
     * @param bst
     */
    public BinarySearchTreeVisualizer(BST bst) {
        this.bst = bst;
        this.width = 800;
        this.height = 600;
        this.x0 = width / 2;
        this.y0 = 50;
        setPreferredSize(new Dimension(width, height));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTree(g, bst.root, x0, y0, x0 / 2);
    }

    private void drawTree(Graphics g, Node node, int x, int y, int dx) {
        if (node != null) {
            // Dessiner le noeud courant
            g.setColor(Color.BLACK);
            g.drawOval(x - 15, y - 15, 30, 30);
            g.drawString(String.valueOf(node.key), x - 5, y + 5);

            // Dessiner le sous-arbre gauche
            Node left = node.left;
            if (left != null) {
                int xLeft = x - dx;
                int yLeft = y + 60;
                g.setColor(Color.BLUE);
                g.drawLine(x, y, xLeft, yLeft - 15);
                drawTree(g, left, xLeft, yLeft, dx / 2);
            }

            // Dessiner le sous-arbre droit
            Node right = node.right;
            if (right != null) {
                int xRight = x + dx;
                int yRight = y + 60;
                g.setColor(Color.RED);
                g.drawLine(x, y, xRight, yRight - 15);
                drawTree(g, right, xRight, yRight, dx / 2);
            }
        }
    }

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
        } else {
            System.out.println("Ce n'est pas un arbre binaire de recherche.");
        }
        
        
        //visualisation graphique
        JFrame frame = new JFrame("Arbre binaire de recherche");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new BinarySearchTreeVisualizer(bst));
        frame.pack();
        frame.setVisible(true);
        
        
        while (loop) {
            // System.out.println("1. Saisir un arbre binaire de recherche");
            //System.out.println("2. Vérifier qu'il s'agit bien d'un arbre binaire de recherche");
            System.out.println("1. Insérer une clé");
            System.out.println("2. Rechercher une clé");
            System.out.println("3. Supprimer une clé");
            System.out.println("4. Quitter");
            System.out.print("Choix : ");

            int choice = sc.nextInt();

            switch (choice) {
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
                    } else {
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

/* public static void main(String[] args) {
        // Créer un arbre binaire de recherche
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
        
        // Créer la fenêtre d'affichage
        JFrame frame = new JFrame("Arbre binaire de recherche");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new BinarySearchTreeVisualizer(bst));
        frame.pack();
        frame.setVisible(true);
    }*/
