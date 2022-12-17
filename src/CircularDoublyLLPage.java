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
            pageNo = countOfPage + 1;
        }
        temp = temp.prevNode;
        present = temp.data;

        System.out.println("Page: " + (pageNo - 1));
        return present;
    }

    public void displayAllPage() {
        Node currentNode = new Node();
        currentNode = head;
        if (head == null) {
            System.out.println("text is empty!");
        } else {
            int pageNo = 1;
            while (currentNode != tail) {
                System.out.println("***********Page " + pageNo + ": ");
                currentNode.data.displayPage();
                pageNo++;
                currentNode = currentNode.nextNode;
            }
            System.out.println("***********Page " + pageNo + ": ");
            currentNode.data.displayPage();
        }
    }

    public void insertPAGE(CircularDoublyLL safhe, int x) {
        Node newNode = new Node();
        Node temp = new Node();
        temp = head;
        newNode.data = safhe;
        if (x == 1) {
            newNode.nextNode = temp;
            newNode.prevNode = tail;
            temp.prevNode = newNode;
            tail.nextNode = newNode;
            head = newNode;
        } else {
            for (int i = 1; i < x - 1; i++) {
                temp = temp.nextNode;
            }
            newNode.nextNode = temp.nextNode;
            (temp.nextNode).prevNode = newNode;
            temp.nextNode = newNode;
            newNode.prevNode = temp;
        }
    }

    public void DeletPAGE(int x, int z) {
        Node temp = new Node();
        temp = head;
        if (x == 1 && z == 1) {
            head = null;
        } else if (x == 1 && z != 1) {
            (temp.nextNode).prevNode = tail;
            tail.nextNode = temp.nextNode;
            head = temp.nextNode;
        } else if (x == z) {
            (tail.prevNode).nextNode = head;
            head.prevNode = tail.prevNode;
            tail = tail.prevNode;
        } else {
            for (int i = 1; i < x; i++) {
                temp = temp.nextNode;
            }
            temp.nextNode.prevNode = temp.prevNode;
            temp.prevNode.nextNode = temp.nextNode;
        }
    }

    public CircularDoublyLL showNTHpages(int x) {
        Node currentNode = head;
        if (head == null) {
            System.out.println("Text is empty!");
        } else {
            int pageNo = 1;
            do {
                pageNo++;
                currentNode = currentNode.nextNode;

            } while (pageNo <= x);
        }
        return currentNode.data;
    }

}
