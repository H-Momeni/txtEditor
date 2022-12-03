public class CircularDoublyLL {
    NodeOfLines head = null;
    NodeOfLines tail = null;

    public void insertLastL(String Line) {
        NodeOfLines newNode = new NodeOfLines();
        newNode.dataL = Line;

        if (head == null) {
            head = tail = newNode;
            head.nextNodeL = head;
            head.prevNodeL = head;
        } else {
            tail.nextNodeL = newNode;
            newNode.prevNodeL = tail;
            newNode.nextNodeL = head;
            head.prevNodeL = newNode;
            tail = newNode;
        }
    }

    public void displayPage() {
        NodeOfLines currentNode = head;
        if (head == null) {
            System.out.println("Page is empty!");
        } else {
            int pageNo = 1;
            while (currentNode != tail) {
                if (!currentNode.dataL.equals("#")) {
                    System.out.println("Line " + pageNo + ": " + currentNode.dataL);
                    pageNo++;
                }
                currentNode = currentNode.nextNodeL;

            }
            System.out.println("Line " + pageNo + ": " + currentNode.dataL);
        }
    }

    // public void displayAllPage() {
    //     Node currentNode = head;
    //     if (head == null) {
    //         System.out.println("Page is empty!");
    //     } else {
    //         int pageNo = 1;
    //         while (currentNode != tail) {
    //             if (!currentNode.data.equals("/")) {
    //                 System.out.println("Page " + pageNo + ": " + currentNode.data);
    //                 pageNo++;
    //             }
    //             currentNode = currentNode.nextNode;

    //         }
    //         System.out.println("Page " + pageNo + ": " + currentNode.data);
    //     }
    // }
}
