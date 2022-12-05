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

    public void where(CircularDoublyLL present) {
        Node temp = new Node();
        temp = head;
        int pageNo = 1;
        while (present != temp.data) {
            pageNo++;
            temp = temp.nextNode;
        }
        System.out.println("Page: " + pageNo);
    }

    public CircularDoublyLL nextPage(CircularDoublyLL present) {
        Node temp = new Node();
        temp = head;
        int pageNo = 1;
        while (present != temp.data) {
            pageNo++;
            temp = temp.nextNode;
        }
        if (present == tail.data) {
            pageNo = 0;
        }
        temp = temp.nextNode;
        present = temp.data;
        System.out.println("Page: " + (pageNo + 1));
        return present;
    }

    public CircularDoublyLL previousPage(CircularDoublyLL present, int countOfPage) {
        Node temp = new Node();
        temp = head;
        int pageNo = 1;
        while (present != temp.data) {
            pageNo++;
            temp = temp.nextNode;
        }
         if (present == head.data) {
            pageNo =countOfPage + 1;
        }
        temp = temp.prevNode;
        present = temp.data;
       
        System.out.println("Page: " + (pageNo - 1));
        return present;
    }

    /*
     * public void displayAllPage() {
     * Node currentNode = head;
     * if (head == null) {
     * System.out.println("Page is empty!");
     * } else {
     * int pageNo = 1;
     * while (currentNode != tail) {
     * if (!currentNode.data.equals("/")) {
     * System.out.println("Page " + pageNo + ": " + currentNode.data);
     * pageNo++;
     * }
     * currentNode = currentNode.nextNode;
     * 
     * }
     * System.out.println("Page " + pageNo + ": " + currentNode.data);
     * }
     * }
     */

}
