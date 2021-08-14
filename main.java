import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
        BinaryTree read = new BinaryTree();
        Node word = new Node();
        System.out.println("1. Read words in a tree and display :");
        System.out.println("2. Implement some methods of a binary tree : ");
        System.out.println("3. Display tree in alphabetical order : ");
        System.out.println("4. Display tree in reverse order : ");
        System.out.println("5. Display tree according to frequency of words(highest to lowest) : ");
        System.out.println("6. Exit : ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                long start = System.currentTimeMillis();
                Node root = read.addWordToList();
                read.showTree();
                long end = System.currentTimeMillis();
                long timeTaken = end - start;
                System.out.println("Time taken to print unique words in tree with frequency is : " + timeTaken);
                System.out.println("Number of words in tree is : " + (read.size()));
                break;

            case 2:
                root = read.addWordToList();
                word.hasleftRight(root);
                word.isInternalExternal(root);

                if (read.isEmpty())
                    System.out.println("Tree is empty");
                else
                    System.out.println("Tree has elements in it ");

                word.checkRoot(root);
                break;

            case 3:
                read.addWordToList();
                read.showTreeAlphabetical();

                break;

            case 4:
                read.addWordToList();
                read.showReverseTree();
                break;

            case 5:
                root = read.addWordToList();

                break;

            case 6:
                System.exit(0);
                break;
        }

    }

}
