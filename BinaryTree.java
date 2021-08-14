import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BinaryTree {
    private Node root;
    private Node root2;
    private BufferedReader bufferedReader;
    private int count = 0;

    public BinaryTree() throws IOException, FileNotFoundException {
        root = null;
        root2 = null;
        bufferedReader = new BufferedReader(new FileReader("./data/daffodils.txt"));
    }

    public boolean isEmpty() {
        if (root == null)
            return true;

        return false;
    }

    public Node addWordToList() throws IOException, FileNotFoundException {

        while (true) {
            String line = bufferedReader.readLine();
            String newLine1 = " ", newLine2 = " ";
            if (line != null) {
                newLine1 = line.replaceAll("[^A-Za-z0-9 -]", "");
                newLine2 = newLine1.replace("-", " ");
                String[] field = newLine2.split(" ");
                for (int index = 0; index < field.length; index++) {
                    count++;
                    if (field[index] == " ")
                        continue;
                    if (root == null) {
                        Node node = new Node();
                        node.setWordCount(1);
                        node.setWordName(field[index]);
                        node.insertLeft(null);
                        node.insertRight(null);
                        root = node;
                        root.addRoot(root);
                    } else
                        root = insert(root, field[index].toUpperCase());

                }
            } else {
                break;
            }

        }

        return root;
    }

    public int size() {
        return count;
    }

    private Node insert(Node node, String word) {

        if (node == null) {
            node = new Node();
            node.setWordCount(1);
            node.setWordName(word);
            node.insertLeft(null);
            node.insertRight(null);
            return node;
        }

        if (word.equals(node.getWordName())) {
            int freq = node.getWordCount();
            node.setWordCount(freq + 1);
            return node;
        }

        if (word.compareTo(node.getWordName()) <= 0)
            node.insertLeft(insert(node.Left(), word));
        else if (word.compareTo(node.getWordName()) > 0)
            node.insertRight(insert(node.Right(), word));

        return node;
    }

    public void showTree() {
        if (isEmpty())
            System.out.println("No elements exist");
        else
            traverse(root);

    }

    private void traverse(Node node) {
        if (node != null) {

            System.out.println(node.getWordName() + "-" + node.getWordCount());
            traverse(node.Left());
            traverse(node.Right());
        }
    }

    private void traverseAlphabetical(Node node) {

        if (node != null) {
            traverseAlphabetical(node.Left());
            System.out.println(node.getWordName() + "-" + node.getWordCount());
            traverseAlphabetical(node.Right());
        }

    }

    public void showTreeAlphabetical() {
        if (isEmpty())
            System.out.println("No elements exist");
        else
            traverseAlphabetical(root);

    }

    private void reverseTree(Node node) {
        if (node != null) {

            reverseTree(node.Right());
            System.out.println(node.getWordName() + "-" + node.getWordCount());
            reverseTree(node.Left());

        }
    }

    public void showReverseTree() {
        if (isEmpty())
            System.out.println("No elements exist");
        else
            reverseTree(root);

    }

}
