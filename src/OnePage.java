import java.util.Arrays;

class Node {
    String data;
    Node nextNode;
    Node prevNode;
}

class CircularDoublyLL {
    Node head = null;
    Node tail = null;

    public void insertLast(String Line) {
        Node newNode = new Node();
        newNode.data = Line;

        if (head == null) {
            head = tail = newNode;
            head.nextNode = head;
            head.prevNode = head;
        } else {
            tail.nextNode = newNode;
            newNode.prevNode = tail;
            newNode.nextNode = head;
            head.prevNode = newNode;
            tail = newNode;
        }
    }

    public void displayPlayist() {
        Node currentNode = head;
        if (head == null) {
            System.out.println("Page is empty!");
        } else {
            int songNo = 1;
            while (currentNode != tail) {
                System.out.println("Line " + songNo + ": " + currentNode.data);
                currentNode = currentNode.nextNode;
                songNo++;
            }
            System.out.println("Line " + songNo + ": " + currentNode.data);
        }
    }
}

public class OnePage {
    public static void main(String[] args) {
        CircularDoublyLL Page = new CircularDoublyLL();

        String str = "Ali/Mohammad/Sahar/#";
        String[] nodes;
        /*
         * for (int i = 0; i < str.length(); i++) {
         * 
         * /* nodes = str.split("/");
         * if (str.charAt(i) == '/') {
         * 
         * 
         * System.out.println(str.charAt(i));
         * }
         * nodes = str.split("/");
         * playlist.insertLast(Arrays.toString(nodes));
         * }
         */

        // System.out.println(Arrays.toString(nodes));
        nodes = str.split("/");
        for (String a : nodes) {
            Page.insertLast(a);
            //System.out.println(a);
        }

       
        Page.displayPlayist();
    }
}