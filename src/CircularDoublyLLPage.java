public class CircularDoublyLLPage {
    Node head = null;
    Node tail = null;

    public void insertLast(CircularDoublyLL Line) {
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

   /*  public void displayAllPage() {
        Node currentNode = head;
        if (head == null) {
            System.out.println("Page is empty!");
        } else {
            int pageNo = 1;
            while (currentNode != tail) {
                if (!currentNode.data.equals("/")) {
                    System.out.println("Page " + pageNo + ": " + currentNode.data);
                    pageNo++;
                }
                currentNode = currentNode.nextNode;

            }
            System.out.println("Page " + pageNo + ": " + currentNode.data);
        }
    }*/
    
}
